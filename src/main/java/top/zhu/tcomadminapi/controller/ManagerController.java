package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.entity.Manager;
import top.zhu.tcomadminapi.service.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/manager")
@Tag(name = "管理员接口")
@AllArgsConstructor
public class ManagerController {

    private ManagerService managerService;

    @GetMapping("/managerInfo")
    public Result<List<Manager>> managerInfo() {
        return Result.ok(managerService.getManagerInfo());
    }

}
