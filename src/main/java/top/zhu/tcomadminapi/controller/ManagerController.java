package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.entity.Manager;
import top.zhu.tcomadminapi.model.vo.ManagerVO;
import top.zhu.tcomadminapi.security.user.ManagerDetail;
import top.zhu.tcomadminapi.security.user.SecurityUser;
import top.zhu.tcomadminapi.service.ManagerService;

import java.util.List;


/**
 * 管理员管理
 */
@RestController
@RequestMapping("/v1/manager")
@Tag(name = "管理员管理")
@AllArgsConstructor
public class ManagerController {

    private ManagerService managerService;

    @PostMapping("/getManagerInfo")
    @Operation(summary = "获取管理员信息")
    public Result<ManagerVO> managerInfo() {
        ManagerDetail manager = SecurityUser.getManager();
        return Result.ok(managerService.getManagerInfo(manager));
    }

}
