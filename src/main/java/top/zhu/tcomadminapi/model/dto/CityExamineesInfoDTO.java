package top.zhu.tcomadminapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Schema(name = "CityExamineesInfoDTO", description = "每个城市的考生信息传输对象")
public class CityExamineesInfoDTO {

    @Schema(description = "城市名称")
    private String cityName;

    @Schema(description = "考生总人数")
    private Integer examineesNum;

    @Schema(description = "实际参加考试人数")
    private Integer actualExamineesNum;

    @Schema(description = "交卷人数")
    private Integer completeNum;

    @Schema(description = "合格人数")
    private Integer passNum;
}
