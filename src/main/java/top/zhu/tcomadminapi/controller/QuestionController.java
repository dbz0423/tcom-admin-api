package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.exception.QuestionNotFoundException;
import top.zhu.tcomadminapi.model.entity.QuestionBank;
import top.zhu.tcomadminapi.service.QuestionService;
import top.zhu.tcomadminapi.model.vo.QuestionVO;
import top.zhu.tcomadminapi.common.result.PageResult;
import org.springframework.http.ResponseEntity;


import java.util.List;


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

    @PostMapping
    @Operation(summary = "新增题目", description = "新增题目及其选项")
    public ResponseEntity<Void> addQuestion(@Valid @RequestBody QuestionBank questionBank) {
        questionService.addQuestion(questionBank);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除题目", description = "根据题目ID删除题目及其选项")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Integer id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    @Operation(summary = "更新题目", description = "根据题目ID更新题目及其选项")
    public ResponseEntity<String> updateQuestion(
            @PathVariable Integer id,
            @Valid @RequestBody QuestionBank questionBank) {
        try {
            questionBank.setPkId(id); // 确保ID一致
            questionService.updateQuestion(questionBank);
            return ResponseEntity.ok("题目更新成功");
        } catch (QuestionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("题目更新失败: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("题目更新失败: " + e.getMessage());
        }
    }
}
