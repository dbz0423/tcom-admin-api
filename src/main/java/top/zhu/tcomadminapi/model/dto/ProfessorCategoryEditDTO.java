package top.zhu.tcomadminapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "ProfessorCategoryEditDTO", description = "专家分类编辑DTO")
public class ProfessorCategoryEditDTO {
    private Integer pkId;
    private String name;
    private String cover;
    private Integer parentId;
    private Integer sort;
}
