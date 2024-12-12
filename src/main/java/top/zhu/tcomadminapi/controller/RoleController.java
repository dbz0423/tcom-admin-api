package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.query.SysRoleQuery;
import top.zhu.tcomadminapi.model.vo.SysRoleVO;
import top.zhu.tcomadminapi.service.SysRoleService;

import java.util.List;

@Tag(name = "角色管理")
@AllArgsConstructor
@RestController
@RequestMapping("/v1/role")
public class RoleController {

    private final SysRoleService sysRoleService;

    @PostMapping("/page")
    @Operation(summary = "分页")
    public Result<PageResult<SysRoleVO>> page(@RequestBody @Valid SysRoleQuery query) {
        PageResult<SysRoleVO> page = sysRoleService.page(query);
        return Result.ok(page);
    }

    @PostMapping("/list")
    @Operation(summary = "列表")
    public Result<List<SysRoleVO>> list() {
        List<SysRoleVO> list = sysRoleService.getList(new SysRoleQuery());
        return Result.ok(list);
    }

    @PostMapping("/add")
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody @Valid SysRoleVO vo) {
        sysRoleService.save(vo);
        return Result.ok();
    }

    @PostMapping("/edit")
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid SysRoleVO vo) {
        sysRoleService.update(vo);
        return Result.ok();
    }

    @PostMapping("/remove")
    @Operation(summary = "删除")
    public Result<String> delete(@RequestBody List<Integer> idList) {
        sysRoleService.delete(idList);
        return Result.ok();
    }

}
