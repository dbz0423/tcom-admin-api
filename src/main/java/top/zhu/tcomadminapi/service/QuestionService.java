package top.zhu.tcomadminapi.service;

import org.springframework.transaction.annotation.Transactional;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.common.result.QuestionPageResult;
import top.zhu.tcomadminapi.common.result.OperationResult;
import top.zhu.tcomadminapi.model.entity.QuestionBank;
import top.zhu.tcomadminapi.model.vo.QuestionSearch;
import top.zhu.tcomadminapi.model.vo.QuestionVO;
import top.zhu.tcomadminapi.model.vo.DeleteQuestionRequest;
import top.zhu.tcomadminapi.model.vo.UpdateQuestionRequest;

import java.util.List;

public interface QuestionService {
    //    List<QuestionVO> getQuestions();
//    List<QuestionBank> getAllQuestions();
//    QuestionPageResult<QuestionVO> getQuestionsPage(int page, int size);
    QuestionPageResult<QuestionVO> getQuestionsByCriteria(QuestionSearch questionSearch);

    OperationResult addQuestion(QuestionBank questionBank);



    @Transactional
    OperationResult deleteQuestion(Integer pkId);

    OperationResult updateQuestion(UpdateQuestionRequest updateRequest);
}