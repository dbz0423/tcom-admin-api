package top.zhu.tcomadminapi.model.vo;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

import java.sql.Timestamp;
import java.util.List;

@Data
@Schema(name = "SubjectVO", description = "专题视图对象")
public class SubjectVO {

    @Schema(description = "唯一标识")
    private Long pkId;

    @Schema(description = "类型: 0公共专题 1专属专题")
    private Integer type;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "简介")
    private String brief;

    @Schema(description = "封面")
    private String cover;

    @Schema(description = "标签，多个用‘，’隔开")
    private List<String> labelList;

    @Schema(description = "学习要求")
    private String claim;

    @Schema(description = "最大学习时长（学时）")
    private Integer maxStudyTime;

    @Schema(description = "浏览量")
    private Integer browseNum;

    @Schema(description = "收藏量")
    private Integer starNum;

    @Schema(description = "状态：0编辑中 1审核中 2审核不通过 3未发布 4已发布")
    private Integer state;

    @Schema(description = "状态描述，方便前端展示")
    private String stateDesc;

    @Schema(description = "管理员id")
    private Long managerId;

    @Schema(description = "管理员名称")
    private String managerName;

    @Schema(description = "是否考核：0 是 1否")
    private Integer isExam;

    @Schema(description = "创建时间")
    private Timestamp createTime;

    @Schema(description = "更新时间")
    private Timestamp updateTime;
}
