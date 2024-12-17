package top.zhu.tcomadminapi.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Schema(name = "UserVO", description = "用户视图对象")
public class UserVO {

    @TableId
    @Schema(description = "主键 ID", example = "2")
    private Long pkId; // 主键 ID

    @Schema(description = "用户昵称", example = "张三")
    private String nickname;   // 昵称

    @Schema(description = "用户头像 URL", example = "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTInP3TEZOq5NTZYf9ed7kibkNiazvMYyod6n6XdnLlOEZdticYbh4kic8Rg1emPN0vsjT1ScwDELgTMicQ/132")
    private String avatar;     // 头像

    @Schema(description = "用户标语", example = "让我们一起学习!")
    private String slogan;     // 标语

    @Schema(description = "用户电话", example = "13800138000")
    private String phone;      // 电话

    @Schema(description = "是否启用（1：启用，0：禁用）", example = "1")
    private Integer isEnable;  // 是否启用（1：启用，0：禁用）

    @Schema(description = "用户角色（0：普通，1：学员，2：专家）", example = "1")
    private Integer role;      // 角色

}
