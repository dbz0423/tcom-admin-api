package top.zhu.tcomadminapi.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import top.zhu.tcomadminapi.utils.DateUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "角色")
public class SysRoleVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "pkId")
    private Integer pkId;

    @Schema(description = "角色名称")
    @NotBlank(message = "角色名称不能为空")
    private String name;

    @Schema(description = "角色描述")
    @NotBlank(message = "角色描述不能为空")
    private String des;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime updateTime;
}