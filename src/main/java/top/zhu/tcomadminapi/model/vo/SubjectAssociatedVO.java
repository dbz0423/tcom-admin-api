package top.zhu.tcomadminapi.model.vo;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

import java.sql.Timestamp;

@Data
@Schema(name = "SubjectAssociatedVO", description = "专题与标签关联视图对象")
public class SubjectAssociatedVO {

    @Schema(description = "唯一标识")
    private Long pkId;

    @Schema(description = "专题ID")
    private Long subjectId;

    @Schema(description = "标签ID")
    private Long labelId;

    @Schema(description = "关联类型")
    private Integer type;

    @Schema(description = "创建时间")
    private Timestamp createTime;

    @Schema(description = "更新时间")
    private Timestamp updateTime;
}
