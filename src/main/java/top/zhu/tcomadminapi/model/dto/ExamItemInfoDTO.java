package top.zhu.tcomadminapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "ExamItemInfoDTO", description = "每张考卷的信息")
public class ExamItemInfoDTO {

    @Schema(description = "试卷类型(A卷...")
    private String title;

    @Schema(description = "单选数量")
    private Integer simpleTotal;

    @Schema(description = "单选分值")
    private Integer simpleScore;

    @Schema(description = "多选数量")
    private Integer multipleTotal;

    @Schema(description = "多选分值")
    private Integer multipleScore;

    @Schema(description = "填空数量")
    private Integer blankTotal;

    @Schema(description = "填空分值")
    private Integer blankScore;
}
