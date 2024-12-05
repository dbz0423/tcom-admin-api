package top.zhu.tcomadminapi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.model.entity.SubjectLabel;
import top.zhu.tcomadminapi.service.SubjectLabelService;

import java.util.List;

/**
 * 标签管理
 */
@RestController
@RequestMapping("/subject-label")
public class SubjectLabelController {

    @Autowired
    private SubjectLabelService subjectLabelService;

    /**
     * 新增标签
     * @param subjectLabel 标签实体
     * @return 返回操作结果
     */
    @Operation(summary = "新增标签", description = "根据传入的标签实体新增标签")
    @PostMapping
    public ResponseEntity<?> addSubjectLabel(@RequestBody SubjectLabel subjectLabel) {
        boolean success = subjectLabelService.addSubjectLabel(subjectLabel);
        return success ? ResponseEntity.ok("标签新增成功") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("标签新增失败");
    }

    /**
     * 删除标签
     * @param pkId 标签ID
     * @return 返回操作结果
     */
    @Operation(summary = "删除标签", description = "根据标签ID删除标签")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubjectLabel(@PathVariable("id") Long pkId) {
        boolean success = subjectLabelService.deleteSubjectLabel(pkId);
        return success ? ResponseEntity.ok("标签删除成功") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("标签删除失败");
    }

    /**
     * 批量删除标签
     * @param pkIds 标签ID列表
     * @return 返回操作结果
     */
    @Operation(summary = "批量删除标签", description = "根据标签ID列表批量删除标签")
    @DeleteMapping("/batch")
    public ResponseEntity<?> deleteSubjectLabels(@RequestBody List<Long> pkIds) {
        boolean success = subjectLabelService.deleteSubjectLabels(pkIds);
        return success ? ResponseEntity.ok("批量标签删除成功") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("批量标签删除失败");
    }

    /**
     * 更新标签
     * @param subjectLabel 标签实体
     * @return 返回操作结果
     */
    @Operation(summary = "更新标签", description = "根据传入的标签实体更新标签")
    @PutMapping
    public ResponseEntity<?> updateSubjectLabel(@RequestBody SubjectLabel subjectLabel) {
        boolean success = subjectLabelService.updateSubjectLabel(subjectLabel);
        return success ? ResponseEntity.ok("标签更新成功") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("标签更新失败");
    }

    /**
     * 根据ID查询标签
     * @param pkId 标签ID
     * @return 返回标签信息
     */
    @Operation(summary = "根据ID查询标签", description = "根据标签ID查询标签详情")
    @GetMapping("/{id}")
    public ResponseEntity<?> getSubjectLabelById(@PathVariable("id") Long pkId) {
        SubjectLabel subjectLabel = subjectLabelService.getSubjectLabelById(pkId);
        return subjectLabel != null ? ResponseEntity.ok(subjectLabel) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("标签未找到");
    }

    /**
     * 查询所有标签
     * @return 返回所有标签的列表
     */
    @Operation(summary = "查询所有标签", description = "查询系统中所有标签信息")
    @GetMapping("/all")
    public ResponseEntity<?> getAllSubjectLabels() {
        List<SubjectLabel> subjectLabels = subjectLabelService.getAllSubjectLabels();
        return ResponseEntity.ok(subjectLabels);
    }

    /**
     * 根据专题ID查询标签
     * @param subjectId 专题ID
     * @return 返回该专题下的所有标签
     */
    @Operation(summary = "根据专题ID查询标签", description = "根据专题ID查询该专题下的所有标签")
    @GetMapping("/by-subject/{subjectId}")
    public ResponseEntity<?> getSubjectLabelsBySubjectId(@PathVariable("subjectId") Long subjectId) {
        List<SubjectLabel> subjectLabels = subjectLabelService.getSubjectLabelsBySubjectId(subjectId);
        return ResponseEntity.ok(subjectLabels);
    }

    /**
     * 分页查询标签
     * @param pageNum 页码
     * @param pageSize 每页记录数
     * @return 返回分页标签信息
     */
    @Operation(summary = "分页查询标签", description = "根据查询条件分页获取标签列表")
    @GetMapping("/page")
    public ResponseEntity<PageResult<SubjectLabel>> getSubjectLabelPage(
            @RequestParam int pageNum,
            @RequestParam int pageSize) {

        // 调用 Service 层进行分页查询
        PageResult<SubjectLabel> pageResult = subjectLabelService.getSubjectLabelPage(pageNum, pageSize);

        // 返回分页结果
        return ResponseEntity.ok(pageResult);
    }
}
