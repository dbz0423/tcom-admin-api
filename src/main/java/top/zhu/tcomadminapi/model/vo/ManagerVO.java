package top.zhu.tcomadminapi.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import top.zhu.tcomadminapi.utils.DateUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Schema(description = "管理员")
public class ManagerVO implements Serializable {


    private static final long serialVersionUID = 1L;

    @Schema(description = "pk_id")
    private Integer pkId;

    @Schema(description = "用户名", required = true)
    @NotBlank(message = "用户名不能为空")
    private String account;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "昵称", required = true)
    @NotBlank(message = "昵称不能为空")
    private String nickname;

    @Schema(description = "角色", required = true)
    @NotBlank(message = "角色不能为空")
    private String name;

    @Schema(description = "状态 0：启用    1：禁用", required = true)
    @Range(min = 0, max = 1, message = "用户状态不正确")
    private Integer isEnabled;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime createTime;

}
