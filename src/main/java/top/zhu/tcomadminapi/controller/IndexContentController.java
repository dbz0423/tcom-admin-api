package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.model.entity.IndexContent;
import top.zhu.tcomadminapi.model.query.IndexContentQuery;
import top.zhu.tcomadminapi.model.vo.IndexContentVO;
import top.zhu.tcomadminapi.service.IndexContentService;


import java.util.List;

/**
 * 首页内容管理
 */
@RestController
@RequestMapping("/v1/index-content")
public class IndexContentController {

    @Autowired
    private IndexContentService indexContentService;

    /**
     * 分页查询首页内容
     */
    @Operation(summary = "分页查询首页内容", description = "根据查询条件分页获取首页内容列表")
    @PostMapping("/page")
    public ResponseEntity<PageResult<IndexContentVO>> getIndexContentPage(
            @RequestBody @Valid IndexContentQuery indexContentQuery) {
        // 调用服务层的分页查询方法
        PageResult<IndexContentVO> pageResult = indexContentService.page(indexContentQuery);

        // 返回分页结果
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 添加首页内容
     */
    @Operation(summary = "添加首页内容", description = "根据提供的首页内容信息，添加一条新的首页内容")
    @PostMapping("/add")
    public ResponseEntity<Boolean> addIndexContent(@RequestBody @Valid IndexContent indexContent) {
        boolean result = indexContentService.addIndexContent(indexContent);
        return ResponseEntity.ok(result);
    }

    /**
     * 获取所有首页内容
     */
    @Operation(summary = "获取所有首页内容", description = "获取系统中所有的首页内容列表")
    @GetMapping("/all")
    public ResponseEntity<List<IndexContent>> getAllIndexContents() {
        List<IndexContent> indexContents = indexContentService.getAllIndexContents();
        return ResponseEntity.ok(indexContents);
    }

    /**
     * 根据ID查询首页内容
     */
    @Operation(summary = "根据ID查询首页内容", description = "根据首页内容的唯一标识（ID）获取首页内容信息")
    @GetMapping("/{id}")
    public IndexContentVO getIndexContentById(@PathVariable Long id) {
        return indexContentService.getIndexContentById(id);
    }

    /**
     * 删除首页内容
     */
    @Operation(summary = "删除首页内容", description = "根据ID删除指定的首页内容")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIndexContent(@PathVariable("id") Long pkId) {
        boolean result = indexContentService.deleteIndexContent(pkId);
        if (result) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



