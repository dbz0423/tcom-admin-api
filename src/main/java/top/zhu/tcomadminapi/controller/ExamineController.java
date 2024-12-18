package top.zhu.tcomadminapi.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.entity.Examine;
import top.zhu.tcomadminapi.model.entity.QuestionBank;
import top.zhu.tcomadminapi.service.ExamineService;

import java.util.List;

@RestController
@RequestMapping("v1/api/examine")
public class ExamineController {

    private static final Logger logger = LoggerFactory.getLogger(ExamineController.class);

    private final ExamineService examineService;

    @Autowired
    public ExamineController(ExamineService examineService) {
        this.examineService = examineService;
    }

    @GetMapping("/all")
    @Operation(summary = "返回所有考核信息，分页前端负责。")
    public List<Examine> getAllExamine() {
        return examineService.getAllExamine();
    }

    @GetMapping("/questions/{examinationId}")
    public List<QuestionBank> getQuestionsByExaminationId(@PathVariable("examinationId") Integer examinationId) {
        return examineService.getQuestionsByExaminationId(examinationId);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除练习详情记录", description = "根据题库表主键（questionId）删除练习详情记录")
    public Result<?> deleteExamineDetail(@RequestParam Integer questionId) {
        if (questionId == null) {
            return Result.error("题库表主键不能为空");
        }

        boolean success = examineService.deleteExamineDetailByQuestionId(questionId);
        if (success) {
            return Result.ok("练习详情已成功删除");
        } else {
            return Result.error("删除失败，记录可能不存在");
        }
    }

}