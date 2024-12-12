package top.zhu.tcomadminapi.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zhu.tcomadminapi.common.result.QuestionPageResult;
import top.zhu.tcomadminapi.common.result.OperationResult;
import top.zhu.tcomadminapi.mapper.QuestionBankMapper;
import top.zhu.tcomadminapi.mapper.QuestionBankOptionMapper;
import top.zhu.tcomadminapi.model.entity.QuestionBank;
import top.zhu.tcomadminapi.model.entity.QuestionBankOption;
import top.zhu.tcomadminapi.model.vo.QuestionSearch;
import top.zhu.tcomadminapi.model.vo.QuestionVO;
import top.zhu.tcomadminapi.model.vo.UpdateQuestionRequest;
import top.zhu.tcomadminapi.service.QuestionService;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Getter
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionBankMapper, QuestionBank> implements QuestionService {

    //初始化数据获取mapper
    private final QuestionBankMapper questionBankMapper;
    private final QuestionBankOptionMapper questionBankOptionMapper;
    @Autowired
    public QuestionServiceImpl(final QuestionBankMapper questionBankMapper,
                               final QuestionBankOptionMapper questionBankOptionMapper) {
        this.questionBankMapper = questionBankMapper;
        this.questionBankOptionMapper = questionBankOptionMapper;
    }


    //格式化时间
    private String formatDate(Timestamp createTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return createTime.toLocalDateTime().format(formatter);
    }


    //实现条件查询带分页的逻辑
    @Override
    public QuestionPageResult<QuestionVO> getQuestionsByCriteria(QuestionSearch questionSearch) {
        int page = questionSearch.getPage();
        int size = questionSearch.getSize();
        Integer optionType = questionSearch.getOptionType();
        String keyword = questionSearch.getKeyword();

        Page<QuestionBank> questionPage = new Page<>(page, size);
        QueryWrapper<QuestionBank> queryWrapper = new QueryWrapper<>();

        // 验证分页参数
        if (page <= 0 || size <= 0) {
            throw new IllegalArgumentException("分页参数错误：页码和每页大小必须大于0");
        }


        //检查条件字段
        if (optionType != null) {
            queryWrapper.eq("option_type", optionType);
        }

        if (keyword != null && !keyword.trim().isEmpty()) {
            queryWrapper.like("question", "%" + keyword + "%");
        }

        questionBankMapper.selectPage(questionPage, queryWrapper);

        List<QuestionBank> records = questionPage.getRecords();
        if (records.isEmpty()) {
            throw new NoSuchElementException("没有符合条件的题目");
        }

        List<QuestionVO> questionVOList = questionPage.getRecords().stream()
                .map(questionBank -> {
                    List<String> options = getOptionsForQuestion(questionBank.getPkId(), questionBank.getOptionType());
                    QuestionVO vo = new QuestionVO();
                    vo.setQuestion(questionBank.getQuestion());
                    vo.setOptionType(questionBank.getOptionType());  // 保持Integer类型
                    vo.setOptions(options);
                    vo.setAnswer(questionBank.getAnswer());
                    vo.setCreateTime(formatDate(questionBank.getCreateTime()));
                    vo.setPkId(questionBank.getPkId());
                    return vo;
                })
                .collect(Collectors.toList());


        return new QuestionPageResult<>(questionVOList, questionPage.getTotal(), (int) questionPage.getCurrent(), (int) questionPage.getSize());
    }

    @Override
    public OperationResult addQuestion(QuestionBank questionBank) {
        return null;
    }

    @Transactional
    @Override
    public OperationResult deleteQuestion(@RequestBody Integer pkId) {
        if (pkId == null) {
            throw new IllegalArgumentException("pkId不能为空");
        }

        // 检查题目是否存在
        QuestionBank question = questionBankMapper.selectById(pkId);
        if (question == null) {
            throw new IllegalArgumentException("未找到对应的题目");
        }

        try {
            // 删除选项表中的相关记录
            QueryWrapper<QuestionBankOption> optionWrapper = new QueryWrapper<>();
            optionWrapper.eq("bank_id", pkId);
            questionBankOptionMapper.delete(optionWrapper);

            // 删除题库表中的记录
            int deletedRows = questionBankMapper.deleteById(pkId);

            if (deletedRows > 0) {
                return new OperationResult(true, "删除成功");
            } else {
                throw new IllegalStateException("删除题目失败");
            }
        } catch (Exception e) {
            // 记录日志（如果有日志系统）
            // logger.error("删除题目失败", e);
            throw new RuntimeException("删除过程中发生错误: " + e.getMessage());
        }
    }




    @Override
    public OperationResult updateQuestion(UpdateQuestionRequest updateRequest) {
        return null;
    }

    // 辅助方法：获取题目选项
    private List<String> getOptionsForQuestion(Integer bankId, Integer optionType) {
        List<QuestionBankOption> options = questionBankOptionMapper.selectList(
                new QueryWrapper<QuestionBankOption>().eq("bank_id", bankId)
        );

        if (optionType == 2) {
            return List.of("空");
        } else {
            return options.stream()
                    .map(option -> option.getOption() + ". " + option.getContent())
                    .collect(Collectors.toList());
        }
    }

    // 辅助方法：将选项类型数字转换为中文
    private String convertOptionTypeToString(Integer optionType) {
        return switch (optionType) {
            case 0 -> "单选";
            case 1 -> "多选";
            case 2 -> "填空";
            default -> "未知";
        };
    }

    // 辅助方法：转换 QuestionBank 为 QuestionVO
    private QuestionVO convertToVO(QuestionBank questionBank) {
        QuestionVO vo = new QuestionVO();
        vo.setQuestion(questionBank.getQuestion());
        vo.setOptionType(questionBank.getOptionType());
        vo.setOptions(getOptionsForQuestion(questionBank.getPkId(), questionBank.getOptionType()));
        vo.setAnswer(questionBank.getAnswer());
        vo.setCreateTime(formatDate(questionBank.getCreateTime()));
        return vo;
    }
}



