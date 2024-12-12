package top.zhu.tcomadminapi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import top.zhu.tcomadminapi.common.result.Result;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.model.entity.Podcast;
import top.zhu.tcomadminapi.service.PodcastService;

import java.util.List;

/**
 * 播客管理
 */

@RestController
@RequestMapping("/v1/podcast")
public class PodcastController {

    @Autowired
    private PodcastService podcastService;

    /**
     * 新增播客
     *
     * @param podcast 播客信息
     * @return 返回新增成功或失败的状态码和消息
     */
    @Operation(summary = "新增播客", description = "新增一条播客信息")
    @PostMapping
    public Result<?> addPodcast(@RequestBody Podcast podcast) {
        boolean success = podcastService.save(podcast);
        return success ? Result.ok("播客新增成功") : Result.error("播客新增失败");
    }

    /**
     * 删除播客
     *
     * @param pkId 播客的 ID
     * @return 返回 200 OK 或 404 Not Found 状态码
     */
    @Operation(summary = "删除播客", description = "根据 ID 删除播客")
    @DeleteMapping("/{id}")
    public Result<?> deletePodcast(@PathVariable("id") Integer pkId) {
        boolean success = podcastService.removeById(pkId);
        return success ? Result.ok("播客删除成功") : Result.error("播客删除失败");
    }

    /**
     * 批量删除播客
     *
     * @param pkIds 播客的 ID 列表
     * @return 返回 200 OK 或 400 Bad Request 状态码
     */
    @Operation(summary = "批量删除播客", description = "根据 ID 列表批量删除播客")
    @DeleteMapping("/batch")
    public Result<?> deletePodcasts(@RequestBody List<Integer> pkIds) {
        boolean success = podcastService.deletePodcasts(pkIds);
        return success ? Result.ok("批量播客删除成功") : Result.error("批量播客删除失败");
    }

    /**
     * 更新播客
     *
     * @param podcast 更新后的播客信息
     * @return 返回 200 OK 或 400 Bad Request 状态码
     */
    @Operation(summary = "更新播客", description = "更新播客信息")
    @PutMapping
    public Result<?> updatePodcast(@RequestBody Podcast podcast) {
        boolean success = podcastService.updateById(podcast);
        return success ? Result.ok("播客更新成功") : Result.error("播客更新失败");
    }

    /**
     * 根据 ID 查询播客
     *
     * @param pkId 播客的 ID
     * @return 返回播客信息或 404 Not Found 状态码
     */
    @Operation(summary = "根据 ID 查询播客", description = "根据播客 ID 查询详细播客信息")
    @GetMapping("/{id}")
    public Result<?> getPodcastById(@PathVariable("id") Integer pkId) {
        Podcast podcast = podcastService.getById(pkId);
        return podcast != null ? Result.ok(podcast) : Result.error("播客未找到");
    }

    /**
     * 查询所有播客
     *
     * @return 返回所有播客的列表
     */
    @Operation(summary = "查询所有播客", description = "查询所有播客信息")
    @GetMapping("/all")
    public Result<?> getAllPodcasts() {
        List<Podcast> podcasts = podcastService.list();
        return Result.ok(podcasts);
    }

    /**
     * 分页查询播客
     *
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 返回分页后的播客列表
     */
    @Operation(summary = "分页查询播客", description = "根据页码和每页大小分页查询播客")
    @GetMapping("/page")
    public Result<Page<Podcast>> getPodcastPage(
            @RequestParam int pageNum,
            @RequestParam int pageSize) {

        Page<Podcast> page = new Page<>(pageNum, pageSize);
        podcastService.page(page); // 调用 MyBatis-Plus 提供的分页查询方法

        return Result.ok(page);
    }
}
