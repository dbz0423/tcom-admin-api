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
@TableName("t_quiz_paper")
public class QuizPaper implements Serializable {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    //子项考试表id
    private Integer quizExamId;

    //标题
    private String title;

    //考试限时
    private Integer timeLimit;

    //单选数量
    private Integer simpleTotal;

    //单选分值
    private Integer simpleScore;

    //多选
    private Integer multipleTotal;

    private Integer multipleScore;

    //填空
    private Integer blankTotal;

    private Integer blankScore;

    //合格分值
    private Integer score;

    @TableField(value = "delete_flag", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;

    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
