package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.ExamineDetailMapper;
import top.zhu.tcomadminapi.mapper.ExamineDetailRepository;
import top.zhu.tcomadminapi.mapper.ExamineMapper;
import top.zhu.tcomadminapi.model.entity.Examine;
import top.zhu.tcomadminapi.model.entity.QuestionBank;
import top.zhu.tcomadminapi.service.ExamineService;

import java.util.List;

@Service
public class ExamineServiceImpl implements ExamineService {

    private final ExamineDetailRepository examineDetailRepository ;
    private final ExamineMapper examineMapper;
    private final ExamineDetailMapper examineDetailMapper;

    @Autowired
    public ExamineServiceImpl(
            ExamineMapper examineMapper,
            ExamineDetailMapper examineDetailMapper,
            ExamineDetailRepository examineDetailRepository
    ) {
        this.examineMapper = examineMapper;
        this.examineDetailMapper = examineDetailMapper;
        this.examineDetailRepository = examineDetailRepository;
    }

    @Override
    public List<Examine> getAllExamine() {
        // 获取所有数据，无条件查询
        return examineMapper.selectList(new LambdaQueryWrapper<>());
    }

    @Override
    public List<QuestionBank> getQuestionsByExaminationId(Integer examinationId) {
        return examineDetailMapper.selectQuestionsByExaminationId(examinationId);
    }

    @Override
    public boolean deleteExamineDetailByQuestionId(Integer questionId) {
        if (questionId == null) {
            throw new IllegalArgumentException("questionId 不能为空");
        }

        int rows = examineDetailRepository.deleteByQuestionId(questionId);
        return rows > 0;
    }


}