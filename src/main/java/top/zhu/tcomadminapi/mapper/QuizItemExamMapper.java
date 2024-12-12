package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.zhu.tcomadminapi.model.entity.QuizItemExam;

import java.util.List;

public interface QuizItemExamMapper extends BaseMapper<QuizItemExam> {

    List<String> selectTitleByQuizDetailId(Integer quizDetailId);

    List<Long> selectPkIdByQuizDetailId(Integer quizDetailId);
}
