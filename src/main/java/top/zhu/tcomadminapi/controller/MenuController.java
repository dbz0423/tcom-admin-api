package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.vo.MenuVO;
import top.zhu.tcomadminapi.security.user.ManagerDetail;
import top.zhu.tcomadminapi.security.user.SecurityUser;
import top.zhu.tcomadminapi.service.MenuService;

import java.util.List;

@Tag(name = "菜单管理")
@RestController
@RequestMapping("/v1/menu")
@AllArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("nav")
    @Operation(summary = "管理员菜单管理")
    public Result<List<MenuVO>> nav() {
        ManagerDetail manager = SecurityUser.getManager();
        return Result.ok(menuService.getManagerMenuList(manager));
    }
}
