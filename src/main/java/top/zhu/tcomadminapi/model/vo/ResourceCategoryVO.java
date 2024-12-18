package top.zhu.tcomadminapi.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import top.zhu.tcomadminapi.common.model.TreeNode;
import top.zhu.tcomadminapi.utils.DateUtils;

import java.sql.Timestamp;

@Data
@Getter
@Setter
public class ResourceCategoryVO extends TreeNode<ResourceCategoryVO> {

    // pk_id
    private Integer pkId;

    // title
    private String title;

    // 父级分类ID
    private Integer parentId;

    // 排序
    private Integer sort;

    // 类型
    private Integer type;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Timestamp createTime;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Timestamp updateTime;

}
