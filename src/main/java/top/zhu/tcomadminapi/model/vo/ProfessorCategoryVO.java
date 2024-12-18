package top.zhu.tcomadminapi.model.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import top.zhu.tcomadminapi.common.model.TreeNode;
import top.zhu.tcomadminapi.utils.DateUtils;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Schema(name = "ProfessorCategoryVO", description = "专家分类VO")
public class ProfessorCategoryVO extends TreeNode<ProfessorCategoryVO> {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;        // 主键ID

    private String name;          // 分类名称

    private String cover;         // 封面

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime updateTime;

    private Integer level;        // 分类级别

    private Integer parentId;     // 上级分类ID

    private Integer sort;         // 排序值
}
