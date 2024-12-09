package top.zhu.tcomadminapi.service;

import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.model.entity.QuestionBank;
import top.zhu.tcomadminapi.model.vo.QuestionVO;

import java.util.List;

public interface QuestionService {

    // 获取所有题目及其选项
    List<QuestionBank> getAllQuestions();

    PageResult<QuestionVO> getQuestionsPage(int page, int size);

    List<QuestionVO> getQuestions();

    PageResult<QuestionVO> getQuestionsByCriteria(int page, int size, Integer optionType, String keyword);

    // 新增题目
    void addQuestion(QuestionBank questionBank);

    // 删除题目
    void deleteQuestion(Integer questionId);

    // 更新题目
    void updateQuestion(QuestionBank questionBank);
}
