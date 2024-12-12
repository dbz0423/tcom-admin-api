package top.zhu.tcomadminapi.controller;

import cn.hutool.core.util.StrUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.query.ManagerQuery;
import top.zhu.tcomadminapi.model.vo.ManagerVO;
import top.zhu.tcomadminapi.security.user.ManagerDetail;
import top.zhu.tcomadminapi.security.user.SecurityUser;
import top.zhu.tcomadminapi.service.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/v1/manager")
@Tag(name = "管理员管理")
@AllArgsConstructor
public class ManagerController {

    private ManagerService managerService;

    @PostMapping("/getManagerInfo")
    @Operation(summary = "获取管理员详细信息")
    public Result<ManagerVO> managerInfo() {
        ManagerDetail manager = SecurityUser.getManager();
        return Result.ok(managerService.getManagerInfo(manager));
    }

    @PostMapping("/page")
    @Operation(summary = "获取管理员信息分页")
    public Result<PageResult<ManagerVO>> page(@RequestBody @Valid ManagerQuery query) {
        PageResult<ManagerVO> page = managerService.page(query);
        return Result.ok(page);
    }
//
//    @PostMapping("/add")
//    @Operation(summary = "保存")
//    public Result<String> save(@RequestBody @Valid SysManagerVO vo) {
//        // 新增密码不能为空
//        if (StrUtil.isBlank(vo.getPassword())) {
//            Result.error("密码不能为空");
//        }
//        // 密码加密
//        vo.setPassword(passwordEncoder.encode(vo.getPassword()));
//        // 保存
//        sysManagerService.save(vo);
//
//        return Result.ok();
//    }

}
