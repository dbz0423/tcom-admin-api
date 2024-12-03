package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 题库实体类
 */

@Data
@TableName("t_question_bank")
@Schema(description = "题干对象")
public class QuestionBank {

    // 主键字段
    @Schema(description = "主键唯一字段")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    // 题目类型
    @Schema(description = "题目类型")
    @TableField("type")
    private Integer type;

    // 内容 ID
    @Schema(description = "内容ID")
    @TableField("content_id")
    private Integer contentId;

    // 选项类型
    @Schema(description = "选项类型,0单选 1多选 2填空")
    @TableField("option_Type")
    private Integer optionType;

    // 题目内容
    @Schema(description = "题目内容")
    @TableField("question")
    private String question;

    // 答案
    @Schema(description = "答案")
    @TableField("answer")
    private String answer;

    // 字数限制
    @Schema(description = "字数限制")
    @TableField("word_limit")
    private Integer wordLimit;

    // 创建时间
    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 更新时间
    @Schema(description = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(exist = false)  // 确保它不参与数据库操作
    @Schema(description = "选项")
    private List<QuestionBankOption> options;
}
