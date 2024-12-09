package top.zhu.tcomadminapi.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.zhu.tcomadminapi.common.model.Query;


import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name = "SubjectLabelQuery", description = "标签查询参数")
public class SubjectLabelQuery extends Query {

    @Schema(description = "专题ID")
    private Long subjectId; // 专题ID，用于查询某个专题下的标签

    @Schema(description = "标签标题")
    private String title; // 标签标题，用于模糊查询标签的标题

    @Schema(description = "标签状态")
    private Integer state; // 标签状态：0-未发布，1-已发布

    @Schema(description = "标签创建时间")
    private Timestamp createTime; // 标签创建时间，用于按时间筛选

    @Schema(description = "标签更新时间")
    private Timestamp updateTime; // 标签更新时间，用于按时间筛选
}
