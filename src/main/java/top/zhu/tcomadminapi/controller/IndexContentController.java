package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.model.entity.IndexContent;
import top.zhu.tcomadminapi.service.IndexContentService;


import java.util.List;


/**
 * 控制器：处理与首页内容相关的 HTTP 请求
 */
@RestController
@RequestMapping("/indexContent")
public class IndexContentController {

    @Autowired
    private IndexContentService indexContentService;

    /**
     * 获取所有首页内容
     *
     * @return 返回所有首页内容的列表，状态码 200 OK
     */
    @Operation(summary = "获取所有首页内容", description = "返回所有首页内容的列表")
    @GetMapping("/list")
    public ResponseEntity<List<IndexContent>> getAllIndexContents() {
        List<IndexContent> indexContents = indexContentService.getAllIndexContents();
        return ResponseEntity.ok(indexContents);
    }

    /**
     * 获取首页内容详情
     *
     * @param pkId 首页内容的唯一标识符
     * @return 返回指定首页内容的详情，若内容存在返回 200 OK，若内容不存在返回 404 Not Found
     */
    @Operation(summary = "获取首页内容详情", description = "根据首页内容的 ID 获取详细信息")
    @GetMapping("/detail/{pkId}")
    public ResponseEntity<IndexContent> getIndexContentDetail(@PathVariable Long pkId) {
        IndexContent indexContent = indexContentService.getIndexContentById(pkId);
        if (indexContent != null) {
            return ResponseEntity.ok(indexContent);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /**
     * 添加首页内容
     *
     * @param indexContent 新的首页内容信息
     * @return 返回 200 OK 或 500 Internal Server Error 状态码，成功或失败的信息
     */
    @Operation(summary = "添加首页内容", description = "创建一个新的首页内容")
    @PostMapping("/add")
    public ResponseEntity<String> addIndexContent(@RequestBody IndexContent indexContent) {
        boolean success = indexContentService.addIndexContent(indexContent);
        return success ? ResponseEntity.ok("首页内容添加成功") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("首页内容添加失败");
    }

    /**
     * 删除首页内容
     *
     * @param pkId 首页内容的唯一标识符
     * @return 返回 200 OK 或 404 Not Found 状态码，删除操作成功或失败的信息
     */
    @Operation(summary = "删除首页内容", description = "根据首页内容的 ID 删除内容")
    @DeleteMapping("/delete/{pkId}")
    public ResponseEntity<String> deleteIndexContent(@PathVariable Long pkId) {
        boolean success = indexContentService.deleteIndexContent(pkId);
        return success ? ResponseEntity.ok("首页内容删除成功") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("首页内容不存在");
    }
}


