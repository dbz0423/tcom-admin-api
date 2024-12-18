package top.zhu.tcomadminapi.service;

import top.zhu.tcomadminapi.model.dto.QuizDTO;
import top.zhu.tcomadminapi.model.dto.QuizUpdateDTO;
import top.zhu.tcomadminapi.model.entity.Quiz;

import java.util.List;

public interface QuizService {

    List<QuizDTO> getQuizListByIds();

    boolean addQuiz(Quiz quiz);

    List<QuizDTO> searchQuizDTOsByTitle(String title);

    boolean updateQuiz(QuizUpdateDTO quizUpdateDTODTO);
}
