package top.zhu.tcomadminapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.vo.ExaminationVO;
import top.zhu.tcomadminapi.model.vo.ExamineesVO;
import top.zhu.tcomadminapi.service.ScreenService;

import java.util.List;

@RestController
@RequestMapping("/v1/data")
@AllArgsConstructor
public class ScreenController {

    private ScreenService screenService;

    @PostMapping("/examination")
    public Result<ExaminationVO> examinationInfo(@RequestParam Integer id) {
        ExaminationVO examinationVO = screenService.getExamination(id);
        return Result.ok(examinationVO);
    }

    @PostMapping("/examinees")
    public Result<List<ExamineesVO>> examinees(@RequestParam Integer id) {
        List<ExamineesVO> examineesVOList = screenService.getExaminees(id);
        return Result.ok(examineesVOList);
    }
}
