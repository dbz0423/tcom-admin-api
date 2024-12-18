package top.zhu.tcomadminapi.model.entity;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.sql.Timestamp;
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
    @TableField("option_type")
    private Integer optionType;

    // 题目内容
    @Schema(description = "题目内容")
    @TableField("question")
    private String question;

    // 答案
    @Schema(description = "答案")
    @TableField("answer")
    private String answer;

    // 字数限制（用于填空题的空格计算）
    @JsonIgnore  // 忽略前端传入的 word_limit 字段
    @Schema(description = "字数限制")
    @TableField("word_limit")
    private Integer wordLimit;

    // 创建时间
    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    // 更新时间
    @Schema(description = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;

    @TableField(exist = false)  // 确保它不参与数据库操作
    @Schema(description = "选项")
    private List<QuestionBankOption> options;
}
