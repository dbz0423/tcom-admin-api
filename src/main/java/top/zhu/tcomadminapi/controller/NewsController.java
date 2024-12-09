package top.zhu.tcomadminapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.model.entity.News;
import top.zhu.tcomadminapi.service.NewsService;

import java.util.List;

/**
 * 资讯管理
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * 新增资讯
     * @param news 资讯实体
     * @return 返回操作结果
     */
    @PostMapping
    public ResponseEntity<?> addNews(@RequestBody News news) {
        boolean success = newsService.addNews(news);
        return success ? ResponseEntity.ok("资讯新增成功") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("资讯新增失败");
    }

    /**
     * 更新资讯
     * @param news 资讯实体
     * @return 返回操作结果
     */
    @PutMapping
    public ResponseEntity<?> updateNews(@RequestBody News news) {
        boolean success = newsService.updateNews(news);
        return success ? ResponseEntity.ok("资讯更新成功") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("资讯更新失败");
    }

    /**
     * 删除资讯
     * @param pkId 资讯ID
     * @return 返回操作结果
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable("id") Integer pkId) {
        boolean success = newsService.deleteNews(pkId);
        return success ? ResponseEntity.ok("资讯删除成功") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("资讯删除失败");
    }

    /**
     * 批量删除资讯
     * @param pkIds 资讯ID列表
     * @return 返回操作结果
     */
    @DeleteMapping("/batch")
    public ResponseEntity<?> deleteNewsBatch(@RequestBody List<Integer> pkIds) {
        boolean success = newsService.deleteNewsBatch(pkIds);
        return success ? ResponseEntity.ok("批量资讯删除成功") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("批量资讯删除失败");
    }

    /**
     * 根据ID查询资讯
     * @param pkId 资讯ID
     * @return 返回资讯详情
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getNewsById(@PathVariable("id") Integer pkId) {
        News news = newsService.getNewsById(pkId);
        return news != null ? ResponseEntity.ok(news) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("资讯未找到");
    }

    /**
     * 查询所有资讯
     * @return 返回所有资讯
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllNews() {
        List<News> newsList = newsService.getAllNews();
        return ResponseEntity.ok(newsList);
    }
}
