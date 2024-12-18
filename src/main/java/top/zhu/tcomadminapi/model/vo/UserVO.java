package top.zhu.tcomadminapi.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Schema(name = "UserVO", description = "用户视图对象")
public class UserVO {

    @Schema(description = "主键 ID", example = "2")
    private Integer pkId;

    @Schema(description = "用户昵称", example = "张三")
    private String nickname;

    @Schema(description = "用户头像 URL", example = "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTInP3TEZOq5NTZYf9ed7kibkNiazvMYyod6n6XdnLlOEZdticYbh4kic8Rg1emPN0vsjT1ScwDELgTMicQ/132")
    private String avatar;

    @Schema(description = "用户标语", example = "让我们一起学习!")
    private String slogan;

    @Schema(description = "用户电话", example = "13800138000")
    private String phone;

    @Schema(description = "是否启用（1：启用，0：禁用）", example = "1")
    private Integer isEnable;

    @Schema(description = "用户角色（0：普通，1：学员，2：专家）", example = "1")
    private Integer role;

}


