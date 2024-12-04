package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_professor")
public class Professor {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Long pkId;             // 唯一标识

    private Integer categoryId;     // 分类id (此字段为关联字段，根据实际情况可以调整)

    private String hospital;        // 医院名称

    private String name;            // 专家姓名

    private String title;           // 专家职称

    private String profession;      // 专业

    private String majorField;      // 主要领域

    private Integer sex;            // 性别 (1 男, 2 女)

    private String brith;           // 出生日期

    private String phone;           // 手机号码

    private String avatar;          // 头像

    private String brief;           // 简介

    private String experience;      // 经验 (可能是详细的文字说明)

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;   // 创建时间

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;   // 更新时间
}
