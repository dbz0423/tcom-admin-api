package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.entity.Menu;
import top.zhu.tcomadminapi.model.vo.MenuVO;
import top.zhu.tcomadminapi.security.user.ManagerDetail;
import top.zhu.tcomadminapi.security.user.SecurityUser;
import top.zhu.tcomadminapi.service.MenuService;

import java.util.List;

/**
 * 菜单管理
 */
@Tag(name = "菜单管理")
@RestController
@RequestMapping("/v1/menu")
@AllArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/nav")
    @Operation(summary = "获取所有菜单")
    public Result<List<MenuVO>> nav() {
        return Result.ok(menuService.getMenus());
    }

    @PostMapping("/navManager")
    @Operation(summary = "获取管理员菜单")
    public Result<List<MenuVO>> navManager() {
        ManagerDetail manager = SecurityUser.getManager();
        return Result.ok(menuService.getManagerMenuList(manager));
    }

    @PostMapping
    @Operation(summary = "新增菜单项")
    public Result<Menu> createMenu(@RequestBody MenuVO menuVO) {
        return Result.ok(menuService.saveMenu(menuVO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新菜单项")
    public Result<Menu> updateMenu(@PathVariable Integer id, @RequestBody MenuVO menuVO) {
        menuVO.setPkId(id);
        return Result.ok(menuService.update(menuVO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除菜单项")
    public Result<String> deleteMenu(@PathVariable Integer id) {
        menuService.delete(id);
        return Result.ok("删除成功");
    }

}
