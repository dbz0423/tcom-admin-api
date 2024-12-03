package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.service.QuestionService;
import top.zhu.tcomadminapi.model.vo.QuestionVO;
import top.zhu.tcomadminapi.common.result.PageResult;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    // 使用构造器注入
    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    @Operation(summary = "获取所有题目", description = "获取所有题目和选项，适用于题库浏览")
    public List<QuestionVO> getAllQuestions() {
        // 调用 Service 层获取题目并返回 VO 数据
        return questionService.getQuestions();
    }

    @GetMapping("/page")
    @Operation(summary = "获取题目分页", description = "根据页码和每页条数获取分页后的题目列表")
    public PageResult<QuestionVO> getQuestionsPage(
            @RequestParam int page,     // 页码，第一页是1
            @RequestParam int size)     // 每页显示的条数
    {
        return questionService.getQuestionsPage(page, size);
    }

    @GetMapping("/search")
    @Operation(summary = "按条件查询题目", description = "根据题目类型和题干内容进行条件查询，支持分页")
    public PageResult<QuestionVO> searchQuestions(
            @RequestParam int page,         // 当前页码
            @RequestParam int size,         // 每页条数
            @RequestParam(required = false) Integer optionType,   // 题目类型，默认为null
            @RequestParam(required = false) String keyword) {      // 题干关键字，默认为null

        return questionService.getQuestionsByCriteria(page, size, optionType, keyword);

}
}
