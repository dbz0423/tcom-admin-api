package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import top.zhu.tcomadminapi.common.result.Result;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.model.query.SubjectQuery;
import top.zhu.tcomadminapi.model.vo.SubjectVO;
import top.zhu.tcomadminapi.service.SubjectService;

import java.util.List;


/**
 * 专题管理
 */
@RestController
@RequestMapping("/v1/subject")
@AllArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    /**
     * 分页查询专题
     */
    @Operation(summary = "分页查询专题", description = "根据查询条件分页获取专题列表")
    @PostMapping("/page")
    public Result<PageResult<SubjectVO>> getSubjectPage(
            @RequestBody @Valid SubjectQuery subjectQuery) {
        // 调用 service 层分页查询方法
        PageResult<SubjectVO> pageResult = subjectService.page(subjectQuery);
        return Result.ok(pageResult);
    }

    /**
     * 根据 ID 查询专题
     */
    @Operation(summary = "根据 ID 查询专题", description = "根据专题 ID 获取专题信息")
    @GetMapping("/{id}")
    public Result<SubjectVO> getSubjectById(
            @Parameter(description = "专题 ID") @PathVariable Long id) {
        SubjectVO subjectVO = subjectService.getSubjectById(id);
        return subjectVO != null ? Result.ok(subjectVO) : Result.error(404, "专题未找到");
    }

    /**
     * 添加新的专题
     */
    @Operation(summary = "添加新的专题", description = "创建一个新的专题")
    @PostMapping("/add")
    public Result<String> addSubject(
            @RequestBody @Valid SubjectVO subjectVO) {
        subjectService.addSubject(subjectVO);
        return Result.ok("专题添加成功"); // 返回消息内容，类型为 String
    }

    /**
     * 更新专题信息
     */
    @Operation(summary = "更新专题", description = "根据 ID 更新专题信息")
    @PutMapping("/update/{id}")
    public Result<String> updateSubject(@RequestBody @Valid SubjectVO subjectVO) {
        subjectVO.setPkId(subjectVO.getPkId()); // 确保更新的 SubjectVO 有正确的 ID
        subjectService.updateSubject(subjectVO);
        return Result.ok("专题更新成功");
    }

    /**
     * 删除专题
     */
    @Operation(summary = "删除专题", description = "根据 ID 删除专题")
    @DeleteMapping("/delete/{id}")
    public Result<String> deleteSubject(
            @Parameter(description = "专题 ID") @PathVariable Long id) {
        subjectService.deleteSubject(id);
        return Result.ok("专题删除成功");
    }

    /**
     * 查询所有专题
     */
    @Operation(summary = "查询所有专题", description = "查询系统中所有专题信息")
    @GetMapping("/all")
    public Result<List<SubjectVO>> getAllSubjects() {
        List<SubjectVO> subjects = subjectService.getAllSubjects();
        return Result.ok(subjects);
    }
}


