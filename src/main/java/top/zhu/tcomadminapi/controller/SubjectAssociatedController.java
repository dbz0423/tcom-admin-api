package top.zhu.tcomadminapi.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.model.entity.SubjectAssociated;
import top.zhu.tcomadminapi.service.SubjectAssociatedService;

import java.util.List;


/**
 * 控制器：处理与专题和标签关联相关的 HTTP 请求
 */
@RestController
@RequestMapping("/api/subject-associated")
public class SubjectAssociatedController {

    private final SubjectAssociatedService subjectAssociatedService;

    /**
     * 构造函数注入 Service 层
     *
     * @param subjectAssociatedService 处理业务逻辑的 Service 类
     */
    public SubjectAssociatedController(SubjectAssociatedService subjectAssociatedService) {
        this.subjectAssociatedService = subjectAssociatedService;
    }

    /**
     * 关联专题和标签
     *
     * @param subjectId 专题的 ID
     * @param labelId 标签的 ID
     * @return 返回 201 Created 状态
     */
    @Operation(summary = "关联专题与标签", description = "将标签与专题进行关联")
    @PostMapping("/associate")
    public ResponseEntity<Void> associateLabelWithSubject(
            @Parameter(description = "专题 ID") @RequestParam Long subjectId,
            @Parameter(description = "标签 ID") @RequestParam Long labelId) {
        subjectAssociatedService.associateLabelWithSubject(subjectId, labelId);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 返回 201 状态码
    }

    /**
     * 移除专题和标签的关联
     *
     * @param subjectId 专题的 ID
     * @param labelId 标签的 ID
     * @return 返回 204 No Content 状态
     */
    @Operation(summary = "移除专题和标签的关联", description = "根据专题 ID 和标签 ID 移除它们之间的关联")
    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeAssociation(
            @Parameter(description = "专题 ID") @RequestParam Long subjectId,
            @Parameter(description = "标签 ID") @RequestParam Long labelId) {
        subjectAssociatedService.removeAssociation(subjectId, labelId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 返回 204 状态码
    }

    /**
     * 获取指定专题的所有标签关联
     *
     * @param subjectId 专题的 ID
     * @return 返回该专题的所有标签关联
     */
    @Operation(summary = "获取专题的所有标签关联", description = "根据专题 ID 获取该专题与所有标签的关联信息")
    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<SubjectAssociated>> getAssociationsBySubjectId(
            @Parameter(description = "专题 ID") @PathVariable Long subjectId) {
        List<SubjectAssociated> associations = subjectAssociatedService.getAssociationsBySubjectId(subjectId);
        return ResponseEntity.ok(associations); // 返回 200 状态码，并携带标签关联列表
    }

    /**
     * 获取指定标签的所有专题关联
     *
     * @param labelId 标签的 ID
     * @return 返回该标签的所有专题关联
     */
    @Operation(summary = "获取标签的所有专题关联", description = "根据标签 ID 获取该标签与所有专题的关联信息")
    @GetMapping("/label/{labelId}")
    public ResponseEntity<List<SubjectAssociated>> getAssociationsByLabelId(
            @Parameter(description = "标签 ID") @PathVariable Long labelId) {
        List<SubjectAssociated> associations = subjectAssociatedService.getAssociationsByLabelId(labelId);
        return ResponseEntity.ok(associations); // 返回 200 状态码，并携带专题关联列表
    }
}

