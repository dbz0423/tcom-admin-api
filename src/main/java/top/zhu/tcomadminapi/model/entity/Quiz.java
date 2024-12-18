package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_quiz")
@Schema(description = "考核概览")
public class Quiz {

    // 主键字段
    @Schema(description = "主键唯一字段")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    // 考核标题
    @Schema(description = "考核人标题")
    @TableField("title")
    private String title;

    // 考核简介
    @Schema(description = "考核简介")
    @TableField("brief")
    private String brief;

    // 考核封面
    @Schema(description = "考核封面")
    @TableField("cover")
    private String cover;

    // 状态
    @Schema(description = "0 未开始 1进行中 2已结束")
    @TableField("state")
    private Integer state;

    // 证书背景
    @Schema(description = "证书背景")
    @TableField("certificate_url")
    private String certificateUrl;

    // 创建时间
    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    // 更新时间
    @Schema(description = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
