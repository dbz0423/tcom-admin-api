package top.zhu.tcomadminapi.model.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class QuestionSearch {
    private int page;
    private int size;
    @Schema(description = "题目类型（0: 单选，1: 多选，2: 填空）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Integer optionType;
    @Schema(description = "题目关键词，支持模糊查询", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String keyword;
}
