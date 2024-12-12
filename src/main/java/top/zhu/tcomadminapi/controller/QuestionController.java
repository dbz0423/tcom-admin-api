package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.dto.DeleteQuestionpkIdDTO;
import top.zhu.tcomadminapi.model.entity.QuestionBank;
import top.zhu.tcomadminapi.model.vo.QuestionSearch;
import top.zhu.tcomadminapi.model.vo.DeleteQuestionRequest;
import top.zhu.tcomadminapi.model.vo.UpdateQuestionRequest;
import top.zhu.tcomadminapi.service.QuestionService;
import top.zhu.tcomadminapi.model.vo.QuestionVO;
import top.zhu.tcomadminapi.common.result.QuestionPageResult;
import top.zhu.tcomadminapi.common.result.OperationResult;

import java.util.List;
import java.util.Map;


/**
 *  题库管理
 */
@RestController
@RequestMapping("/v1/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    // 使用构造器注入
    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

//    @GetMapping
//    @Operation(summary = "获取所有题目", description = "获取所有题目和选项，适用于题库浏览")
//    public List<QuestionVO> getAllQuestions() {
//        // 调用 Service 层获取题目并返回 VO 数据
//        return questionService.getQuestions();
//    }
//
//    @GetMapping("/page")
//    @Operation(summary = "获取题目分页", description = "根据页码和每页条数获取分页后的题目列表")
//    public QuestionPageResult<QuestionVO> getQuestionsPage(
//            @RequestParam int page,     // 页码，第一页是1
//            @RequestParam int size)     // 每页显示的条数
//    {
//        return questionService.getQuestionsPage(page, size);
//    }


    //条件查询，请求体QuestionSearch，返回体QuestionPageResult<QuestionVO>
    @PostMapping("/search")
    @Operation(summary = "按条件查询题目", description = "根据题目类型和题干内容进行条件查询，支持分页")
    public QuestionPageResult<QuestionVO> searchQuestions(@Valid @RequestBody QuestionSearch questionSearch) {
        // 传递 questionSearch 参数到服务层
        return questionService.getQuestionsByCriteria(questionSearch);
    }


    @PostMapping
    @Operation(summary = "新增题目", description = "新增题目及其选项")
    public OperationResult addQuestion(@Valid @RequestBody QuestionBank questionBank) {
        return questionService.addQuestion(questionBank);
    }

    @DeleteMapping("/delete")
    public OperationResult deleteQuestion(@RequestBody DeleteQuestionpkIdDTO request) {
        Integer pkId = request.getPkId();
        if (pkId == null) {
            throw new IllegalArgumentException("pkId不能为空");
        }
        return questionService.deleteQuestion(pkId);
    }

    @PutMapping
    @Operation(summary = "更新题目", description = "根据题目ID更新题目及其选项")
    public OperationResult updateQuestion(@Valid @RequestBody UpdateQuestionRequest updateRequest) {
        return questionService.updateQuestion(updateRequest);
    }
}
