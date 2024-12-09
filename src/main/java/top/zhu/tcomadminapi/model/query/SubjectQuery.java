package top.zhu.tcomadminapi.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.zhu.tcomadminapi.common.model.Query;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name = "SubjectQuery", description = "专题查询参数")
public class SubjectQuery extends Query {

    @Schema(description = "专题标题")
    private String title;  // 专题标题

    @Schema(description = "专题类型")
    private Integer type;  // 专题类型：0-公共专题，1-专属专题

    @Schema(description = "专题状态")
    private Integer state;  // 状态：0-编辑中，1-审核中，2-审核不通过，3-未发布，4-已发布

    @Schema(description = "管理员ID")
    private Long managerId;  // 专题管理者ID

    @Schema(description = "考核开始时间")
    private Timestamp startTime;  // 考核开始时间

    @Schema(description = "考核结束时间")
    private Timestamp endTime;  // 考核结束时间

    @Schema(description = "是否考核")
    private Integer isExam;  // 是否考核：0-是，1-否

    @Schema(description = "创建时间")
    private Timestamp createTime;  // 创建时间

    @Schema(description = "更新时间")
    private Timestamp updateTime;  // 更新时间
}
