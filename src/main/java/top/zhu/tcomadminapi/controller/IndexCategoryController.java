package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.common.result.Result;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.convert.MenuConvert;
import top.zhu.tcomadminapi.model.dto.UpdateIndexCategoryDTO;
import top.zhu.tcomadminapi.model.entity.IndexCategory;
import top.zhu.tcomadminapi.model.vo.IndexCategoryVO;
import top.zhu.tcomadminapi.service.IndexCategoryService;
import top.zhu.tcomadminapi.utils.TreeUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 首页分类管理
 */
@RestController
@RequestMapping("/v1/indexCategory")
public class IndexCategoryController {

    @Autowired
    private IndexCategoryService indexCategoryService;

    /**
     * 获取所有首页分类
     *
     * @return 返回包含所有首页分类的列表
     */
    @Operation(summary = "获取首页分类列表", description = "获取所有首页分类的信息")
    @GetMapping("/list")
    public Result<PageResult<IndexCategoryVO>> getIndexCategories() {
        List<IndexCategoryVO> list = indexCategoryService.getIndexCategories();
        PageResult<IndexCategoryVO> page = new PageResult<>(list, list.size());
        return Result.ok(page);
    }

    /**
     * 新增首页分类
     *
     * @param indexCategoryVO 新的首页分类信息
     * @return 返回 200 OK 或 500 Internal Server Error 状态码
     */
    @Operation(summary = "新增首页分类", description = "创建一个新的首页分类")
    @PostMapping("/add")
    public Result<String> addIndexCategory(@RequestBody IndexCategoryVO indexCategoryVO) {
        System.out.println("接收到的数据: " + indexCategoryVO); // 调试打印

        indexCategoryVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
        indexCategoryVO.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        boolean success = indexCategoryService.addIndexCategory(indexCategoryVO);
        return success ? Result.ok("分类添加成功") : Result.error("分类添加失败");
    }


    /**
     * 修改首页分类
     *
     * @param request 包含更新信息的 DTO（名称、显示状态、排序值）
     * @return 返回 200 OK 或 404 Not Found 状态码
     */
    @Operation(summary = "修改首页分类", description = "根据 ID 更新首页分类的信息")
    @PutMapping("/update")
    public Result<String> updateIndexCategory(
            @RequestBody UpdateIndexCategoryDTO request
    ) {
        boolean success = indexCategoryService.updateIndexCategory(
                request.getPkId(),
                request.getName(),
                request.getIsShow(),
                request.getSort(),
                request.getParentId() // 传递 parent_id
        );
        return success ? Result.ok("分类修改成功") : Result.error("分类不存在");
    }


    /**
     * 删除首页分类
     *
     * @param pkId 分类的 ID
     * @return 返回 200 OK 或 404 Not Found 状态码
     */
    @Operation(summary = "删除首页分类", description = "根据 ID 删除首页分类")
    @DeleteMapping("/delete/{pkId}")
    public Result<String> deleteIndexCategory(@PathVariable Long pkId) {
        boolean success = indexCategoryService.deleteIndexCategory(pkId);
        return success ? Result.ok("分类删除成功") : Result.error("分类不存在");
    }

}
