package top.zhu.tcomadminapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Schema(description = "资源分类修改")
public class UpdateResourceCategoryDTO {
    private Integer pkId;
    private String title;
    private Integer sort;
    // 添加 parent_id 字段
    private Integer parentId;
}
