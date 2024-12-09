package top.zhu.tcomadminapi.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.zhu.tcomadminapi.model.dto.CityExamineesInfoDTO;

import java.util.List;

@Data
@Schema(name = "ExamineesVO", description = "动态考生信息")
public class ExamineesVO {

    @Schema(description = "唯一标识")
    private Long pkId;

    @Schema(description = "考生总人数")
    private Integer examineesTotal;

    @Schema(description = "实际参加考试人数")
    private Integer actualExamineesTotal;

    @Schema(description = "交卷人数")
    private Integer completeTotal;

    @Schema(description = "合格人数")
    private Integer passTotal;

    @Schema(description = "每个城市的考生信息")
    private List<CityExamineesInfoDTO> examineesList;
}
