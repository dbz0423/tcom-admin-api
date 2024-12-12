package top.zhu.tcomadminapi.service;

import top.zhu.tcomadminapi.model.vo.ExaminationVO;

public interface ScreenService {

    ExaminationVO getExamination(Integer examId);
}
