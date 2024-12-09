package top.zhu.tcomadminapi.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "账号登录")
public class LoginVO {

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;
}
