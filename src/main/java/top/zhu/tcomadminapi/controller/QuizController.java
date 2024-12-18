package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.dto.QuizDTO;
import top.zhu.tcomadminapi.model.dto.QuizUpdateDTO;
import top.zhu.tcomadminapi.model.entity.Quiz;
import top.zhu.tcomadminapi.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("v1/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @GetMapping("/batch")
    @Operation(summary = "查询考核列表", description = "根据主键 ID 列表批量查询考核")
    public Result<List<QuizDTO>> getQuizListByIds() {
        return Result.ok(quizService.getQuizListByIds());
    }

    @PostMapping("/add")
    @Operation(summary = "新增考核")
    public Result<String> addQuiz(@RequestBody Quiz quiz) {
        // 调用服务层的新增方法
        boolean success = quizService.addQuiz(quiz);
        if (success) {
            return Result.ok("新增考核成功");
        } else {
            return Result.error("新增考核失败");
        }
    }

    @GetMapping("/search")
    @Operation(summary = "模糊查询考核，用到了batch接口")
    public Result<List<QuizDTO>> searchQuizzesByTitle(@RequestParam String title) {
        // 调用服务层模糊查询方法
        List<QuizDTO> quizDTOs = quizService.searchQuizDTOsByTitle(title);
        return Result.ok(quizDTOs);
    }

    @PostMapping("/update")
    @Operation(summary = "考核信息蟹盖接口，用到了pkid")
    public Result<String> updateQuiz(@RequestBody QuizUpdateDTO quizUpdateDTODTO) {
        if (quizService.updateQuiz(quizUpdateDTODTO)) {
            return Result.ok("修改成功");
        }
        return Result.error("修改失败");
    }
}

