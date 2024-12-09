package top.zhu.tcomadminapi.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "ExaminationVO", description = "静态考核信息")
public class ExaminationVO {

    @Schema(description = "唯一标识")
    private Long pkId;

    @Schema(description = "考核时长，通过计算得出")
    private Integer time;

    @Schema(description = "考试类型")
    private String title;

    @Schema(description = "单选数量")
    private Integer simpleCount;

    @Schema(description = "单选分值")
    private Integer simpleScore;

    @Schema(description = "多选数量")
    private Integer multipleCount;

    @Schema(description = "多选分值")
    private Integer multipleScore;

    @Schema(description = "填空数量")
    private Integer blankCount;

    @Schema(description = "填空分值")
    private Integer blankScore;
}
