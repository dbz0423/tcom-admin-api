package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;


@Data
@TableName("t_subject_label")
public class SubjectLabel {

    @TableId(value = "pk_id", type = com.baomidou.mybatisplus.annotation.IdType.AUTO)
    private Long pkId;            // 唯一标识

    private Long subjectId;       // 专题id (外键关联到TSubject)

    private String title;         // 标签标题

    private String brief;         // 标签描述

    private String cover;         // 标签封面

    private Timestamp createTime; // 创建时间

    private Timestamp updateTime; // 更新时间
}
