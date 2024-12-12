package top.zhu.tcomadminapi.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.zhu.tcomadminapi.model.entity.QuestionBankOption;

import java.util.List;

/**
 * 更新题目请求类
 */
@Data
public class UpdateQuestionRequest {
    @Schema(description = "题目ID", example = "1")
    private Integer id;

    @Schema(description = "题目类型, 0单选 1多选 2填空", example = "0")
    private Integer type;

    @Schema(description = "内容ID", example = "100")
    private Integer contentId;

    @Schema(description = "选项类型, 0单选 1多选 2填空", example = "0")
    private Integer optionType;

    @Schema(description = "题目内容", example = "What is 2 + 2?")
    private String question;

    @Schema(description = "答案", example = "4")
    private String answer;

    @Schema(description = "字数限制")
    private Integer wordLimit;

    @Schema(description = "选项列表")
    private List<QuestionBankOption> options;
}
