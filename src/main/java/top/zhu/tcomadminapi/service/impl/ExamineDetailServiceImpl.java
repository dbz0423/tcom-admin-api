package top.zhu.tcomadminapi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zhu.tcomadminapi.mapper.ExamineDetailRepository;
import top.zhu.tcomadminapi.model.entity.ExamineDetail;
import top.zhu.tcomadminapi.service.ExamineDetailService;

@Service
public class ExamineDetailServiceImpl implements ExamineDetailService {

    private static final Logger logger = LoggerFactory.getLogger(ExamineDetailServiceImpl.class);

    private final ExamineDetailRepository examineDetailRepository;

    @Autowired
    public ExamineDetailServiceImpl(ExamineDetailRepository examineDetailRepository) {
        this.examineDetailRepository = examineDetailRepository;
    }

    @Override
    @Transactional
    public boolean addExamineDetail(Integer contentId, Integer questionId) {
        ExamineDetail detail = new ExamineDetail();
        detail.setContentId(contentId);
        detail.setQuestionId(questionId);

        try {
            int rows = examineDetailRepository.insert(detail);
            return rows > 0;
        } catch (Exception e) {
            logger.error("插入练习详情记录失败，contentId: {}, questionId: {}, 错误信息: {}", contentId, questionId, e.getMessage());
            throw new RuntimeException("插入练习详情记录失败: " + e.getMessage(), e);
        }
    }
}
