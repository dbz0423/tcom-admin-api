package top.zhu.tcomadminapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import top.zhu.tcomadminapi.mapper.ExamineDetailMapper;
import top.zhu.tcomadminapi.model.entity.Examine;
import top.zhu.tcomadminapi.model.entity.QuestionBank;

import java.util.List;

public interface ExamineService {
    List<Examine> getAllExamine();

    List<QuestionBank> getQuestionsByExaminationId(Integer examinationId);

    boolean deleteExamineDetailByQuestionId(Integer questionId);

}