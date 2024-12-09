package top.zhu.tcomadminapi.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Schema(description = "用户登录")
public class LoginTokenVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "access_token")
    private String access_token;
}
