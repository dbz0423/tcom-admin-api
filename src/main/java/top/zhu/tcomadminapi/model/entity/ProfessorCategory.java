package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 专家分类表实体类
 */
@Data
@TableName("t_professor_category")
public class ProfessorCategory {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;        // 主键ID

    private String name;          // 分类名称

    private String cover;         // 封面

    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime;  // create_time

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;  // update_time

    private Integer level;        // 分类级别

    private Integer parentId;     // 上级分类ID

    private Integer sort;         // 排序值
}
