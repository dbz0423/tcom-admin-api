package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_quiz_item")
public class QuizItem implements Serializable {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    //考核表id
    private Integer examineId;

    //类型(0线上 1线下 2学时)
    private Integer type;

    //成绩项名称(例如：理论考核成绩)
    private String name;

    //简介
    private String brief;

    @TableField(value = "delete_flag", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;

    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
