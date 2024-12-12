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
@TableName("t_quiz_item_exam")
public class QuizItemExam implements Serializable {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    //考核子项表id
    private Integer quizDetailId;

    //考试标题
    private String title;

    //简介
    private String brief;

    //封面
    private String cover;

    //开始时间
    private Date startTime;

    //结束时间
    private Date endTime;

    private Integer isStart;

    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;

    @TableField(value = "delete_flag", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;
}

