package top.zhu.tcomadminapi.service;

import top.zhu.tcomadminapi.model.vo.ExaminationVO;
import top.zhu.tcomadminapi.model.vo.ExamineesVO;

import java.util.List;

public interface ScreenService {

    ExaminationVO getExamination(Integer examId);

    List<ExamineesVO> getExaminees(Integer examId);
}
