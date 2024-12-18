package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user_examination")
public class UserExamination {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private Integer examinationId;

    private Integer userId;

    private Integer isFinish;

    private Integer score;

    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;

    private Integer trialNum;

    private Integer passNum;

    private Integer failNum;
}

