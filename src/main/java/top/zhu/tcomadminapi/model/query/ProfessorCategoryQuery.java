package top.zhu.tcomadminapi.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.zhu.tcomadminapi.common.model.Query;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "ProfessorCategoryQuery", description = "专家分类查询参数")
public class ProfessorCategoryQuery extends Query {

    @Schema(description = "专家分类名称")
    private String name;
}
