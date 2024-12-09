package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.mapper.QuestionBankMapper;
import top.zhu.tcomadminapi.mapper.QuestionBankOptionMapper;
import top.zhu.tcomadminapi.model.entity.QuestionBank;
import top.zhu.tcomadminapi.model.entity.QuestionBankOption;
import top.zhu.tcomadminapi.model.vo.QuestionVO;
import top.zhu.tcomadminapi.service.QuestionService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionBankMapper, QuestionBank> implements QuestionService {

    private final QuestionBankMapper questionBankMapper;
    private final QuestionBankOptionMapper questionBankOptionMapper;

    @Autowired
    public QuestionServiceImpl(final QuestionBankMapper questionBankMapper,
                               final QuestionBankOptionMapper questionBankOptionMapper) {
        this.questionBankMapper = questionBankMapper;
        this.questionBankOptionMapper = questionBankOptionMapper;
    }

    @Override
    public List<QuestionBank> getAllQuestions() {
        // 获取所有题目
        List<QuestionBank> questions = questionBankMapper.selectList(null);

        // 为每个题目添加选项并进行拼接
        for (QuestionBank question : questions) {
            // 根据题目 ID 查询对应的选项
            List<QuestionBankOption> options = questionBankOptionMapper.selectList(
                    new QueryWrapper<QuestionBankOption>().eq("bank_id", question.getPkId())
            );
            question.setOptions(options);  // 将选项添加到题目中

            // 根据题目类型拼接题目和选项
            if (question.getOptionType() == 0) {  // 单选题
                StringBuilder optionsBuilder = new StringBuilder();
                for (QuestionBankOption option : options) {
                    optionsBuilder.append(option.getOption())
                            .append(" : ")
                            .append(option.getContent())
                            .append("\n");
                }
                question.setQuestion(question.getQuestion() + "\n" + optionsBuilder.toString());
            } else if (question.getOptionType() == 1) {  // 多选题
                StringBuilder optionsBuilder = new StringBuilder();
                for (QuestionBankOption option : options) {
                    optionsBuilder.append(option.getOption())
                            .append(" : ")
                            .append(option.getContent())
                            .append("\n");
                }
                question.setQuestion(question.getQuestion() + "\n" + optionsBuilder.toString());
            } else if (question.getOptionType() == 2) {  // 填空题
                question.setQuestion(question.getQuestion());  // 题干后添加空白
            }
        }

        return questions;
    }

    @Override
    public PageResult<QuestionVO> getQuestionsPage(int page, int size) {
        // 创建 MyBatis Plus 分页对象
        Page<QuestionBank> questionPage = new Page<>(page, size);

        // 使用 QueryWrapper 查询所有题目，或根据需求添加查询条件
        questionBankMapper.selectPage(questionPage, new QueryWrapper<>());

        // 将查询结果转换为 VO 对象
        List<QuestionVO> questionVOList = questionPage.getRecords().stream()
                .map(this::convertToVO)
                .collect(Collectors.toList());

        // 返回分页结果
        return new PageResult<>(questionPage.getTotal(), questionVOList);
    }

    @Override
    public List<QuestionVO> getQuestions() {
        // 获取所有题目
        List<QuestionBank> questionBanks = questionBankMapper.selectList(null);

        // 将题目数据转换为 VO 格式
        return questionBanks.stream().map(questionBank -> {
            QuestionVO vo = new QuestionVO();
            vo.setQuestion(questionBank.getQuestion());  // 题目内容
            vo.setType(convertOptionTypeToString(questionBank.getOptionType()));  // 题目类型（中文）
            vo.setOptions(getOptionsForQuestion(questionBank.getPkId(), questionBank.getOptionType()));  // 选项（内容+详细描述）
            vo.setAnswer(questionBank.getAnswer());  // 题目答案
            vo.setCreateTime(formatDate(questionBank.getCreateTime()));  // 格式化时间
            return vo;
        }).collect(Collectors.toList());
    }




    @Override
    public PageResult<QuestionVO> getQuestionsByCriteria(int page, int size, Integer optionType, String keyword) {
        // 创建分页对象
        Page<QuestionBank> questionPage = new Page<>(page, size);

        // 创建查询条件
        QueryWrapper<QuestionBank> queryWrapper = new QueryWrapper<>();

        // 按题目类型查询
        if (optionType != null) {
            queryWrapper.eq("option_type", optionType);
        }

        // 按题干内容查询
        if (keyword != null && !keyword.trim().isEmpty()) {
            queryWrapper.like("question", "%" + keyword + "%");  // LIKE 查询
        }

        // 执行分页查询
        questionBankMapper.selectPage(questionPage, queryWrapper);

        // 将查询结果转换为 VO 格式
        List<QuestionVO> questionVOList = questionPage.getRecords().stream()
                .map(this::convertToVO)
                .collect(Collectors.toList());

        // 返回分页结果：total 表示总记录数，questionVOList 表示当前页的数据
        return new PageResult<>(questionPage.getTotal(), questionVOList);
    }

    @Override
    @Transactional
    public void addQuestion(QuestionBank questionBank) {
        // 1. 数据验证（不包括 word_limit 的验证）
        validateQuestionForAdd(questionBank);

        // 2. 处理填空题的 word_limit
        if (questionBank.getOptionType() == 2) {
            // 计算 question 中 $ 的数量
            int wordLimit = countPlaceholders(questionBank.getQuestion());
            questionBank.setWordLimit(wordLimit);

            // 验证 answer 的长度是否等于 word_limit
            if (questionBank.getAnswer().length() != wordLimit) {
                throw new RuntimeException("填空题的答案字数必须与题干中的占位符数量相等");
            }
        }

        // 3. 插入题目
        questionBankMapper.insert(questionBank);

        // 4. 处理选择题的选项插入
        if (questionBank.getOptionType() == 0 || questionBank.getOptionType() == 1) {
            List<QuestionBankOption> options = questionBank.getOptions();
            if (options != null && !options.isEmpty()) {
                for (QuestionBankOption option : options) {
                    option.setBankId(questionBank.getPkId());  // 设置外键关联
                    questionBankOptionMapper.insert(option);
                }
            } else {
                throw new RuntimeException("选择题必须包含选项");
            }
        }
    }

    @Override
    @Transactional
    public void deleteQuestion(Integer questionId) {
        // 1. 检查题目是否存在
        QuestionBank questionBank = questionBankMapper.selectById(questionId);
        if (questionBank == null) {
            throw new RuntimeException("题目不存在");
        }

        // 2. 删除选项（如果是选择题）
        if (questionBank.getOptionType() == 0 || questionBank.getOptionType() == 1) {
            int deletedOptions = questionBankOptionMapper.delete(
                    new QueryWrapper<QuestionBankOption>().eq("bank_id", questionId)
            );
            // 可选：记录删除的选项数量
        }

        // 3. 删除题目
        int deletedQuestions = questionBankMapper.deleteById(questionId);
        if (deletedQuestions == 0) {
            throw new RuntimeException("删除题目失败");
        }

        // 4. 事务自动提交
    }

    @Override
    @Transactional
    public void updateQuestion(QuestionBank questionBank) {
        // 1. 数据验证（不包括 word_limit 的验证）
        validateQuestionForUpdate(questionBank);

        // 2. 处理填空题的 word_limit
        if (questionBank.getOptionType() == 2) {
            // 计算 question 中 $ 的数量
            int wordLimit = countPlaceholders(questionBank.getQuestion());
            questionBank.setWordLimit(wordLimit);

            // 验证 answer 的长度是否等于 word_limit
            if (questionBank.getAnswer().length() != wordLimit) {
                throw new RuntimeException("填空题的答案字数必须与题干中的占位符数量相等");
            }

            // 删除原有的选项（如果有）
            questionBankOptionMapper.delete(new QueryWrapper<QuestionBankOption>().eq("bank_id", questionBank.getPkId()));
        } else if (questionBank.getOptionType() == 0 || questionBank.getOptionType() == 1) {
            // 选择题的处理逻辑
            // 1. 删除原有的选项
            questionBankOptionMapper.delete(new QueryWrapper<QuestionBankOption>().eq("bank_id", questionBank.getPkId()));

            // 2. 插入新的选项
            List<QuestionBankOption> newOptions = questionBank.getOptions();
            if (newOptions != null && !newOptions.isEmpty()) {
                for (QuestionBankOption option : newOptions) {
                    option.setBankId(questionBank.getPkId()); // 设置外键关联
                    questionBankOptionMapper.insert(option);
                }
            } else {
                throw new RuntimeException("选择题必须包含选项");
            }
        }

        // 3. 更新题目
        int updateCount = questionBankMapper.updateById(questionBank);
        if (updateCount == 0) {
            throw new RuntimeException("更新题目失败");
        }
    }


    // 将题目类型（数字）转换为中文
    private String convertOptionTypeToString(Integer optionType) {
        switch (optionType) {
            case 0:
                return "单选";
            case 1:
                return "多选";
            case 2:
                return "填空";
            default:
                return "未知";
        }
    }

    // 获取该题目的选项内容
    private List<String> getOptionsForQuestion(Integer bankId, Integer optionType) {
        // 查询该题目的选项
        List<QuestionBankOption> options = questionBankOptionMapper.selectList(
                new QueryWrapper<QuestionBankOption>().eq("bank_id", bankId)
        );

        // 如果是填空题，返回"空"
        if (optionType == 2) {
            return List.of("空");
        } else {
            // 拼接选项内容和详细描述
            return options.stream()
                    .map(option -> option.getOption() + "." + option.getContent())  // A.选项描述
                    .collect(Collectors.toList());
        }
    }

    // 格式化时间
    private String formatDate(LocalDateTime createTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return createTime.format(formatter);
    }

    // 转换 QuestionBank 为 QuestionVO
    private QuestionVO convertToVO(QuestionBank questionBank) {
        QuestionVO vo = new QuestionVO();
        vo.setQuestion(questionBank.getQuestion());
        vo.setType(convertOptionTypeToString(questionBank.getOptionType()));
        vo.setOptions(getOptionsForQuestion(questionBank.getPkId(), questionBank.getOptionType()));
        vo.setAnswer(questionBank.getAnswer());
        vo.setCreateTime(formatDate(questionBank.getCreateTime()));
        return vo;
    }

    // 数据验证 - 新增
    private void validateQuestionForAdd(QuestionBank questionBank) {
        // 验证 question 字段
        if (questionBank.getQuestion() == null || questionBank.getQuestion().trim().isEmpty()) {
            throw new RuntimeException("题目内容不能为空");
        }
        if (questionBank.getQuestion().length() > 60) {
            throw new RuntimeException("题目内容不能超过60个字符");
        }

        // 根据 option_type 进行不同的验证
        if (questionBank.getOptionType() == 0 || questionBank.getOptionType() == 1) {
            // 选择题的验证
            // ...
        } else if (questionBank.getOptionType() == 2) {
            // 填空题需要验证 question 和 answer
            if (questionBank.getAnswer() == null || questionBank.getAnswer().trim().isEmpty()) {
                throw new RuntimeException("答案不能为空");
            }
            // 不再验证 word_limit，这将在后续计算
        } else {
            throw new RuntimeException("无效的选项类型");
        }
    }

    // 数据验证 - 更新
    private void validateQuestionForUpdate(QuestionBank questionBank) {
        // 与新增时的验证类似
        validateQuestionForAdd(questionBank);
    }

    private int countPlaceholders(String question) {
        int count = 0;
        for (char c : question.toCharArray()) {
            if (c == '$') {
                count++;
            }
        }
        return count;
    }
}
