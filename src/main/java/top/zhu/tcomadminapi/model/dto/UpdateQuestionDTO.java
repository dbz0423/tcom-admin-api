package top.zhu.tcomadminapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 题目更新请求 DTO
 */
@Data
@Schema(description = "题目更新请求 DTO")
public class UpdateQuestionDTO {

    @Schema(description = "题目主键 ID", required = true, example = "7")
    @NotNull(message = "题目 ID 不能为空")
    private Integer pkId;

    @Schema(description = "题目内容", required = true, example = "更新后的题目内容")
    @NotEmpty(message = "题目内容不能为空")
    private String question;

    @Schema(description = "正确答案", required = true, example = "A")
    @NotEmpty(message = "答案不能为空")
    private String answer;

    @Schema(description = "题目类型", required = true, allowableValues = {"0", "1", "2"}, example = "1")
    @NotNull(message = "题型不能为空")
    private Integer optionType;

    @Schema(description = "选项列表", example = "[{\"content\": \"选项1\"}, {\"content\": \"选项2\"}]")
    private List<QuestionBankOptionDTO> options;
}