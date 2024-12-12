package top.zhu.tcomadminapi.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.zhu.tcomadminapi.common.model.Query;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "管理员查询")
public class ManagerQuery extends Query {
    @Schema(description = "用户名")
    private String username;

    @Schema(description = "昵称")
    private String nickname;

}
