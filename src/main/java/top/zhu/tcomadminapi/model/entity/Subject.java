package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_subject")
public class Subject {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Long pkId;            // 唯一标识

    private Integer type;         // 类型: 0公共专题 1专属专题

    private String title;         // 标题

    private String brief;         // 简介

    private String author;         // 作者

    private String cover;         // 封面

    private String label;         // 标签，多个用“，”隔开

    private String claim;         // 学习要求

    private Integer maxStudyTime; // 最大学习时长（学时）

    private Integer browseNum;    // 浏览量

    private Integer starNum;      // 收藏量

    private Integer state;        // 状态：0编辑中 1审核中 2审核不通过 3未发布 4已发布

    private Long managerId;       // 管理员id

    private Timestamp startTime;  // 考核开始时间

    private Timestamp endTime;    // 考核结束时间

    private Integer isExam;       // 是否考核：0 是 1否

    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime; // 创建时间

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime; // 更新时间
}
