package top.zhu.tcomadminapi.model.entity;


import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_examination_detail")
@Schema(description = "练习详情")
public class ExamineDetail {
    // 主键字段
    @Schema(description = "主键唯一字段")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    // 关联 ID
    @Schema(description = "等于考试表的主键id")
    @TableField("content_id")
    private Integer contentId;

    // 题目概览id
    @Schema(description = "对应题库表的主键")
    @TableField("question_id")
    private Integer questionId;

    // 创建时间
    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    // 更新时间
    @Schema(description = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
