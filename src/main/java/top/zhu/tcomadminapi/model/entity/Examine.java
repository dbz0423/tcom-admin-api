package top.zhu.tcomadminapi.model.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_examination")
@Schema(description = "练习概览")
public class Examine {

    // 主键字段
    @Schema(description = "主键唯一字段")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    // 关联 ID
    @Schema(description = "关联ID")
    @TableField("content_id")
    private Integer contentId;

    // 题目类型
    @Schema(description = "0视频 1书籍章节 2书籍（测试题）3专题 4播客 ")
    @TableField("type")
    private Integer type;

    // 答案
    @Schema(description = "标题")
    @TableField("title")
    private String title;

    // 时间限制
    @Schema(description = "时间限制")
    @TableField("time_limit")
    private Integer timeLimit;

    // 删除标识
    @Schema(description = "删除标识")
    @TableField("delete_flag")

    private Integer deleteFlag;
    // 创建时间
    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    // 更新时间
    @Schema(description = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;


}
