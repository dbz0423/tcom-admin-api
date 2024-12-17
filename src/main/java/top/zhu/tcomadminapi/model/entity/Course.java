package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_course")
public class Course {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;            // 课程唯一标识

    private String title;            // 课程标题

    private Integer sort;            // 排序值

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String cover = "cover/GXxZezMGQ8.png";            // 封面

    private String brief;            // 课程简介

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String authorAvatar = "avatar/QGM3tAcXYN.png";     // 作者头像

    private String authorBrief;      // 作者简介

    private String authorProfession; // 作者职业

    private String label;            // 标签

    private String author;           // 作者名称

    private Integer maxStudyTime;    // 最大学习时间（单位：分钟）

    private Integer browseNum;       // 浏览次数

    private Integer starNum;         // 星级评分

    private Integer state;           // 状态（0：未发布，1：已发布）

    private Integer managerId;       // 管理员ID

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;    // 创建时间

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;    // 更新时间

    private Integer categoryId;      // 分类ID
}
