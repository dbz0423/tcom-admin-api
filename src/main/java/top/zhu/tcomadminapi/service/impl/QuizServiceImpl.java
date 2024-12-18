package top.zhu.tcomadminapi.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import top.zhu.tcomadminapi.convert.QuizConvert;
import top.zhu.tcomadminapi.mapper.QuizMapper;
import top.zhu.tcomadminapi.model.dto.QuizDTO;
import top.zhu.tcomadminapi.model.dto.QuizUpdateDTO;
import top.zhu.tcomadminapi.model.entity.Quiz;
import top.zhu.tcomadminapi.service.QuizService;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizServiceImpl extends ServiceImpl<QuizMapper, Quiz> implements QuizService {

    /**
     * 转换实体类 Quiz 为 DTO
     */
    private final QuizMapper quizMapper;

    @Override
    @Transactional
    public List<QuizDTO> getQuizListByIds() {
        List<Quiz> quizzes = baseMapper.selectList(null);

        return QuizConvert.INSTANCE.convertList(quizzes);
    }

    //格式化时间
    private String formatDate(Timestamp createTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return createTime.toLocalDateTime().format(formatter);
    }

    @Override
    public boolean addQuiz(Quiz quiz) {
        // 补全状态和时间字段
        quiz.setState(1); // 状态写死为 1
        quiz.setCreateTime(new Timestamp(System.currentTimeMillis())); // 当前时间
        quiz.setUpdateTime(new Timestamp(System.currentTimeMillis())); // 当前时间

        // 执行插入操作
        return quizMapper.insert(quiz) > 0;
    }

    @Override
    @Transactional
    public List<QuizDTO> searchQuizDTOsByTitle(String title) {
        // 使用 MyBatis-Plus 提供的 Wrapper 构建模糊查询条件
        QueryWrapper<Quiz> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", title);

        // 查询匹配条件的 Quiz 列表
        List<Quiz> quizzes = quizMapper.selectList(queryWrapper);

        // 转换为 DTO 并返回
        return QuizConvert.INSTANCE.convertList(quizzes);
    }

    @Override
    public boolean updateQuiz(QuizUpdateDTO quizUpdateDTODTO) {
        // 校验字段不为空
        if (!StringUtils.hasText(quizUpdateDTODTO.getTitle()) ||
                !StringUtils.hasText(quizUpdateDTODTO.getBrief()) ||
                !StringUtils.hasText(quizUpdateDTODTO.getCover()) ||
                !StringUtils.hasText(quizUpdateDTODTO.getCertificateUrl())) {
            throw new IllegalArgumentException("修改的字段不能为空");
        }

        // 构建更新对象
        UpdateWrapper<Quiz> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("pk_id", quizUpdateDTODTO.getPkId());

        Quiz quiz = new Quiz();
        quiz.setTitle(quizUpdateDTODTO.getTitle());
        quiz.setBrief(quizUpdateDTODTO.getBrief());
        quiz.setCover(quizUpdateDTODTO.getCover());
        quiz.setCertificateUrl(quizUpdateDTODTO.getCertificateUrl());

        // 执行更新操作
        return quizMapper.update(quiz, updateWrapper) > 0;
    }
}
