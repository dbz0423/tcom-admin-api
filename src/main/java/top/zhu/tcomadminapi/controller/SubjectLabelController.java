package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.model.entity.SubjectLabel;
import top.zhu.tcomadminapi.service.SubjectLabelService;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.List;



import java.util.List;

/**
 * 控制器：处理与专题标签相关的 HTTP 请求
 */
@RestController
@RequestMapping("/api/subject-label")
public class SubjectLabelController {

    private final SubjectLabelService subjectLabelService;

    /**
     * 构造函数注入 Service 层
     *
     * @param subjectLabelService 处理业务逻辑的 Service 类
     */
    public SubjectLabelController(SubjectLabelService subjectLabelService) {
        this.subjectLabelService = subjectLabelService;
    }

    /**
     * 添加新的专题标签
     *
     * @param subjectLabel 新的专题标签信息
     * @return 返回 201 Created 状态
     */
    @Operation(summary = "添加新的专题标签", description = "创建一个新的专题标签")
    @PostMapping
    public ResponseEntity<Void> addSubjectLabel(
            @RequestBody @Parameter(description = "专题标签信息") SubjectLabel subjectLabel) {
        subjectLabelService.addSubjectLabel(subjectLabel);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 返回 201 状态码
    }


    /**
     * 更新专题标签信息
     *
     * @param subjectLabel 更新后的专题标签信息
     * @return 返回 200 OK 状态
     */
    @Operation(summary = "更新专题标签", description = "根据 ID 更新专题标签信息")
    @PutMapping
    public ResponseEntity<Void> updateSubjectLabel(
            @RequestBody @Parameter(description = "更新后的专题标签信息") SubjectLabel subjectLabel) {
        subjectLabelService.updateSubjectLabel(subjectLabel);
        return ResponseEntity.status(HttpStatus.OK).build(); // 返回 200 状态码
    }

    /**
     * 删除专题标签
     *
     * @param id 专题标签的 ID
     * @return 返回 204 No Content 状态
     */
    @Operation(summary = "删除专题标签", description = "根据 ID 删除专题标签")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubjectLabel(
            @Parameter(description = "专题标签 ID") @PathVariable Long id) {
        subjectLabelService.deleteSubjectLabel(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 返回 204 状态码
    }

    /**
     * 获取所有专题标签
     *
     * @return 返回包含所有专题标签的列表
     */
    @Operation(summary = "获取所有专题标签", description = "获取所有的专题标签")
    @GetMapping
    public ResponseEntity<List<SubjectLabel>> getAllSubjectLabels() {
        List<SubjectLabel> labels = subjectLabelService.getAllSubjectLabels();
        return ResponseEntity.ok(labels); // 返回 200 状态码，并携带标签列表
    }
}
