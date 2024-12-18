package top.zhu.tcomadminapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 题目新增请求 DTO
 */
@Data
@Schema(description = "题目新增请求 DTO")
public class QuestionBankDTO {

    @Schema(description = "题目内容", required = true, example = "这是一个测试题目")
    @NotEmpty(message = "题目内容不能为空")
    private String question;

    @Schema(description = "正确答案", required = true, example = "A")
    @NotEmpty(message = "答案不能为空")
    private String answer;

    @Schema(description = "题目类型", required = true, allowableValues = {"0", "1", "2"}, example = "0")
    @NotNull(message = "题型不能为空")
    private Integer optionType;

    @Schema(description = "选项列表", example = "[{\"content\": \"选项1\"}, {\"content\": \"选项2\"}]")
    private List<QuestionBankOptionDTO> options;
}
