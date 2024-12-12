package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;


@Data
@TableName("t_subject_label")
public class SubjectLabel {

    @TableId(value = "pk_id", type=IdType.AUTO)
    private Long pkId;            // 唯一标识

    private Long subjectId;       // 专题id (外键关联到TSubject)

    private String title;         // 标签标题

    private String brief;         // 标签描述

    private String cover;         // 标签封面

    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime; // 创建时间

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime; // 更新时间
}
