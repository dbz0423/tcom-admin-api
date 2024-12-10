package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 题库选项实体类
 */

@Data
@TableName("t_question_bank_option")
@Schema(description = "选项对象")
public class QuestionBankOption {

    // 主键字段
    @Schema(description = "主键字段")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    // 关联题库表的题目 ID
    @Schema(description = "关联题库表的题目 ID")
    @TableField("bank_id")
    private Integer bankId;

    // 选项内容
    @Schema(description = "选项内容")
    @TableField("`option`")
    private String option;

    // 选项详细描述
    @Schema(description = "选项详细描述")
    @TableField("content")
    private String content;

    // 创建时间
    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    // 更新时间
    @Schema(description = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;

}
