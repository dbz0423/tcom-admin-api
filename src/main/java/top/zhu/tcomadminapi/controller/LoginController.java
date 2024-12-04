package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.vo.LoginTokenVO;
import top.zhu.tcomadminapi.model.vo.LoginVO;
import top.zhu.tcomadminapi.service.LoginService;

@Tag(name = "登录管理")
@RestController
@AllArgsConstructor
@CrossOrigin
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    @Operation(summary = "账号密码登录")
    public Result<LoginTokenVO> login(@RequestBody LoginVO login) {
        return Result.ok(loginService.loginByAccount(login));
    }

}
