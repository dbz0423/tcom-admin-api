package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_quiz_item_exam_student")
public class QuizItemExamStudent {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    //子项考试表id
    private Integer quizExamId;

    //学员id
    private Integer studentId;

    //考核学员表id
    private Integer quizStudentId;

    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
