package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.dto.UpdateResourceCategoryDTO;
import top.zhu.tcomadminapi.model.vo.ResourceCategoryVO;
import top.zhu.tcomadminapi.service.ResourceCategoryService;

import java.sql.Timestamp;
import java.util.List;


@RestController
@RequestMapping("v1/resourceCategory")
public class ResourceController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    /**
     * 获取所有资源分类
     *
     * @return 返回包含所有资源分类的列表
     */
    @Operation(summary = "获取资源分类列表", description = "获取所有资源分类的信息")
    @GetMapping("/list")
    public Result<PageResult<ResourceCategoryVO>> getIndexCategories() {
        List<ResourceCategoryVO> list = resourceCategoryService.getResourceCategories();
        PageResult<ResourceCategoryVO> page = new PageResult<>(list, list.size());
        return Result.ok(page);
    }

    /**
     * 新增资源分类
     *
     * @param resourceCategoryVO 新的资源分类信息
     * @return 返回 200 OK 或 500 Internal Server Error 状态码
     */
    @Operation(summary = "新增资源分类", description = "创建一个新的资源分类")
    @PostMapping("/add")
    public Result<String> addResourceCategory(@RequestBody ResourceCategoryVO resourceCategoryVO) {
        // 调试打印
        System.out.println("接收到的数据: " + resourceCategoryVO);

        resourceCategoryVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
        resourceCategoryVO.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        boolean success = resourceCategoryService.addResourceCategory(resourceCategoryVO);
        return success ? Result.ok("分类添加成功") : Result.error("分类添加失败");
    }


    /**
     * 修改资源分类
     *
     * @param request 包含更新信息的 DTO（名称、显示状态、排序值）
     * @return 返回 200 OK 或 404 Not Found 状态码
     */
    @Operation(summary = "修改资源分类", description = "根据 ID 更新资源分类的信息")
    @PutMapping("/update")
    public Result<String> updateResourceCategory(
            @RequestBody UpdateResourceCategoryDTO request
    ) {
        boolean success = resourceCategoryService.updateResourceCategory(
                request.getPkId(),
                request.getTitle(),
                request.getSort(),
                // 传递 parent_id
                request.getParentId()
        );
        return success ? Result.ok("分类修改成功") : Result.error("分类不存在");
    }


    /**
     * 删除资源分类
     *
     * @param pkId 分类的 ID
     * @return 返回 200 OK 或 404 Not Found 状态码
     */
    @Operation(summary = "删除资源分类", description = "根据 ID 删除资源分类")
    @DeleteMapping("/delete/{pkId}")
    public Result<String> deleteResourceCategory(@PathVariable Long pkId) {
        boolean success = resourceCategoryService.deleteResourceCategory(pkId);
        return success ? Result.ok("分类删除成功") : Result.error("分类不存在");
    }


}
