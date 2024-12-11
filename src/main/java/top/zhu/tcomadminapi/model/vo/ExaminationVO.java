package top.zhu.tcomadminapi.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.zhu.tcomadminapi.model.dto.ExamItemInfoDTO;

import java.util.List;

@Data
@Schema(name = "ExaminationVO", description = "静态考核信息")
public class ExaminationVO {

    @Schema(description = "考核时长，通过计算得出")
    private Integer time;

    @Schema(description = "考试标题")
    private List<String> titles;

    @Schema(description = "考卷列表")
    private List<ExamItemInfoDTO> exams;
}
