package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.model.query.SubjectQuery;
import top.zhu.tcomadminapi.model.vo.SubjectVO;
import top.zhu.tcomadminapi.service.SubjectService;


/**
 * 专题管理
 */
@RestController
@RequestMapping("/v1/api/subject")
@AllArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    /**
     * 分页查询专题
     */
    @Operation(summary = "分页查询专题", description = "根据查询条件分页获取专题列表")
    @PostMapping("/page")
    public ResponseEntity<PageResult<SubjectVO>> getSubjectPage(
            @RequestBody @Valid SubjectQuery subjectQuery) {
        // 调用 service 层分页查询方法
        PageResult<SubjectVO> pageResult = subjectService.page(subjectQuery);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据 ID 查询专题
     */
    @Operation(summary = "根据 ID 查询专题", description = "根据专题 ID 获取专题信息")
    @GetMapping("/{id}")
    public ResponseEntity<SubjectVO> getSubjectById(
            @Parameter(description = "专题 ID") @PathVariable Long id) {
        SubjectVO subjectVO = subjectService.getSubjectById(id);
        if (subjectVO == null) {
            return ResponseEntity.notFound().build(); // 如果找不到，返回 404
        }
        return ResponseEntity.ok(subjectVO);
    }

    /**
     * 添加新的专题
     */
    @Operation(summary = "添加新的专题", description = "创建一个新的专题")
    @PostMapping
    public ResponseEntity<Void> addSubject(
            @RequestBody @Valid SubjectVO subjectVO) {
        subjectService.addSubject(subjectVO);
        return ResponseEntity.status(201).build(); // 返回 201 状态码
    }

    /**
     * 更新专题信息
     */
    @Operation(summary = "更新专题", description = "根据 ID 更新专题信息")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSubject(
            @Parameter(description = "专题 ID") @PathVariable Long id,
            @RequestBody @Valid SubjectVO subjectVO) {
        subjectVO.setPkId(id); // 确保更新的 SubjectVO 有正确的 ID
        subjectService.updateSubject(subjectVO);
        return ResponseEntity.ok().build(); // 返回 200 状态码
    }

    /**
     * 删除专题
     */
    @Operation(summary = "删除专题", description = "根据 ID 删除专题")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(
            @Parameter(description = "专题 ID") @PathVariable Long id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build(); // 返回 204 状态码
    }
}
