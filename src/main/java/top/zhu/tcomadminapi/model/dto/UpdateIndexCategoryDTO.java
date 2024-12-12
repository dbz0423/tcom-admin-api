package top.zhu.tcomadminapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Schema(description = "首页分类修改")
public class UpdateIndexCategoryDTO {
    private String name;
    private Integer isShow;
    private Integer sort;
    private Long parentId; // 添加 parent_id 字段

    // Getters and Setters...
}

