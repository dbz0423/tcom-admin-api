package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.convert.PaperConvert;
import top.zhu.tcomadminapi.mapper.QuizItemExamMapper;
import top.zhu.tcomadminapi.mapper.QuizItemMapper;
import top.zhu.tcomadminapi.mapper.QuizPaperMapper;
import top.zhu.tcomadminapi.model.dto.ExamItemInfoDTO;
import top.zhu.tcomadminapi.model.entity.QuizItem;
import top.zhu.tcomadminapi.model.entity.QuizPaper;
import top.zhu.tcomadminapi.model.vo.ExaminationVO;
import top.zhu.tcomadminapi.service.ScreenService;

import java.util.List;

@Service
@AllArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private QuizPaperMapper quizPaperMapper;
    private QuizItemMapper quizItemMapper;
    private QuizItemExamMapper quizItemExamMapper;

    @Override
    public ExaminationVO getExamination(Integer examId) {
        ExaminationVO examinationVO = new ExaminationVO();

        QueryWrapper<QuizItem> selectExamsWrapper = new QueryWrapper<>();
        selectExamsWrapper.eq("examine_id", examId)
                .eq("type", 0);

        List<QuizItem> quizItems = quizItemMapper.selectList(selectExamsWrapper);
        Integer quizItemId = quizItems.get(0).getPkId();

        List<String> titles = quizItemExamMapper.selectTitleByQuizDetailId(quizItemId);

        List<Long> paperIds = quizItemExamMapper.selectPkIdByQuizDetailId(quizItemId);

        QueryWrapper<QuizPaper> selectPaperWrapper = new QueryWrapper<>();
        selectPaperWrapper.eq("quiz_exam_id", paperIds.get(0));

        List<QuizPaper> quizPapers = quizPaperMapper.selectList(selectPaperWrapper);
        List<ExamItemInfoDTO> exams = PaperConvert.INSTANCE.convert(quizPapers);
        examinationVO.setExams(exams);
        examinationVO.setTitles(titles);
        return examinationVO;
    }
}
