package top.zhu.tcomadminapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * 题目选项 DTO
 */
@Data
@Schema(description = "题目选项 DTO")
public class QuestionBankOptionDTO {

    @Schema(description = "选项主键 ID（新增时可为空）", example = "101")
    private Integer pkId;

    @Schema(description = "选项内容", required = true, example = "选项1")
    @NotEmpty(message = "选项内容不能为空")
    private String content;
}
