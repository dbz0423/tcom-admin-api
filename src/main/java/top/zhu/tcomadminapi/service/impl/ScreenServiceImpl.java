package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.common.config.RedisConfig;
import top.zhu.tcomadminapi.convert.PaperConvert;
import top.zhu.tcomadminapi.mapper.*;
import top.zhu.tcomadminapi.model.dto.CityExamineesInfoDTO;
import top.zhu.tcomadminapi.model.dto.ExamItemInfoDTO;
import top.zhu.tcomadminapi.model.entity.QuizItemExamStudent;
import top.zhu.tcomadminapi.model.entity.QuizItem;
import top.zhu.tcomadminapi.model.entity.QuizPaper;
import top.zhu.tcomadminapi.model.entity.UserExamination;
import top.zhu.tcomadminapi.model.vo.ExaminationVO;
import top.zhu.tcomadminapi.model.vo.ExamineesVO;
import top.zhu.tcomadminapi.service.ScreenService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private QuizPaperMapper quizPaperMapper;
    private QuizItemMapper quizItemMapper;
    private QuizItemExamMapper quizItemExamMapper;
    private QuizItemExamStudentMapper quizItemExamStudentMapper;
    private UserExaminationMapper userExaminationMapper;

    private RedisTemplate redisTemplate;

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
        List<QuizPaper> quizPapers;
        List<List<ExamItemInfoDTO>> exams = new ArrayList<>();
        for (Long id : paperIds) {
            selectPaperWrapper.eq("quiz_exam_id", id);
            quizPapers = quizPaperMapper.selectList(selectPaperWrapper);
            exams.add(PaperConvert.INSTANCE.convert(quizPapers));
            if (!quizPapers.isEmpty()) {
                examinationVO.setTime(quizPapers.get(0).getTimeLimit());
            }
            selectPaperWrapper.clear();
        }

        examinationVO.setExams(exams);
        examinationVO.setTitles(titles);
        return examinationVO;
    }

    @Override
    public List<ExamineesVO> getExaminees(Integer examId) {
        List<ExamineesVO> examineesVOList = new ArrayList<>();
//
//        QueryWrapper<QuizItem> selectExamsWrapper = new QueryWrapper<>();
//        selectExamsWrapper.eq("examine_id", examId)
//                .eq("type", 0);
//
//        List<QuizItem> quizItems = quizItemMapper.selectList(selectExamsWrapper);
//        Integer quizItemId = quizItems.get(0).getPkId();
//
//        List<Long> paperIds = quizItemExamMapper.selectPkIdByQuizDetailId(quizItemId);
//
//        QueryWrapper<QuizItemExamStudent> selectStudentWrapper = new QueryWrapper<>();
//        for (Long id : paperIds) {
//            selectStudentWrapper.eq("quiz_exam_id", id);
//            List<QuizItemExamStudent> students = quizItemExamStudentMapper.selectList(selectStudentWrapper);
//            ExamineesVO examineesVO = new ExamineesVO();
//            examineesVO.setExamineesTotal(students.size());
//
//            examineesVOList.add(examineesVO);
//            selectStudentWrapper.clear();
//        }
        int[] cities = {877, 890, 899, 919, 930, 948, 957, 968, 984, 992, 911, 940, 976};
        String[] citiesName = {"南京市", "无锡市", "徐州市", "苏州市", "南通市", "淮安市", "盐城市", "扬州市", "泰州市", "宿迁市", "常州市", "连云港市", "镇江市"};

        QueryWrapper<UserExamination> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("pk_id");
        List<UserExamination> userExaminations = userExaminationMapper.selectList(wrapper);
        ExamineesVO examineesVO = new ExamineesVO();
        examineesVO.setExamineesTotal(userExaminations.size());
        wrapper.eq("is_finish", 1);
        userExaminations = userExaminationMapper.selectList(wrapper);
        examineesVO.setCompleteTotal(userExaminations.size());
        wrapper.clear();
        wrapper.ge("score", 60);
        userExaminations = userExaminationMapper.selectList(wrapper);
        examineesVO.setPassTotal(userExaminations.size());
        examineesVO.setActualExamineesTotal(Integer.valueOf((String) Objects.requireNonNull(redisTemplate.opsForValue().get("exam:userNum"))));

        List<CityExamineesInfoDTO> cityExamineesInfoDTOList = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            CityExamineesInfoDTO cityExamineesInfoDTO = new CityExamineesInfoDTO();
            userExaminations = userExaminationMapper.selectExaminationFromCity(cities[i]);
            cityExamineesInfoDTO.setCityName(citiesName[i]);
            cityExamineesInfoDTO.setExamineesNum(userExaminations.size());
            cityExamineesInfoDTO.setActualExamineesNum(userExaminations.size());
            userExaminations = userExaminationMapper.selectExaminationFromCityAndFinish(cities[i]);
            cityExamineesInfoDTO.setCompleteNum(userExaminations.size());
            userExaminations = userExaminationMapper.selectExaminationFromCityAndPass(cities[i]);
            cityExamineesInfoDTO.setPassNum(userExaminations.size());
            cityExamineesInfoDTOList.add(cityExamineesInfoDTO);
        }

        examineesVO.setExamineesList(cityExamineesInfoDTOList);
        examineesVOList.add(examineesVO);
        return examineesVOList;
    }


}
