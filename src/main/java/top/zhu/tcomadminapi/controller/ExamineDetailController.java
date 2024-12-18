package top.zhu.tcomadminapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.service.ExamineDetailService;

@RestController
@RequestMapping("v1/api/examine-details")
public class ExamineDetailController {

    private static final Logger logger = LoggerFactory.getLogger(ExamineDetailController.class);

    private final ExamineDetailService examineDetailService;

    @Autowired
    public ExamineDetailController(ExamineDetailService examineDetailService) {
        this.examineDetailService = examineDetailService;
    }

    @PostMapping("/add")
    public Result<?> addExamineDetail(@RequestParam Integer contentId, @RequestParam Integer questionId) {
        logger.info("接收到添加练习详情的请求，contentId: {}, questionId: {}", contentId, questionId);

        if (contentId == null || questionId == null) {
            logger.warn("contentId 或 questionId 为空");
            return Result.error("contentId 和 questionId 不能为空");
        }

        boolean success = examineDetailService.addExamineDetail(contentId, questionId);
        if (success) {
            logger.info("成功插入练习详情记录，contentId: {}, questionId: {}", contentId, questionId);
            return Result.ok("练习详情已成功添加");
        } else {
            logger.error("插入练习详情记录失败，contentId: {}, questionId: {}", contentId, questionId);
            return Result.error("插入练习详情记录失败");
        }
    }
}
