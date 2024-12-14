package top.zhu.tcomadminapi.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import top.zhu.tcomadminapi.common.model.TreeNode;
import top.zhu.tcomadminapi.utils.DateUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class IndexCategoryVO extends TreeNode<IndexCategoryVO> {


    private Integer pkId;         // pk_id

    private String name;       // name

    private Integer parentId;     // 父级分类ID

    private Integer level;     // 层级

    private Integer isShow;    // 是否显示

    private Integer sort;      // 排序

    private Integer type;      // 类型

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Timestamp createTime;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Timestamp updateTime;

}
