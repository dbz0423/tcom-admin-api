package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 专家分类表实体类
 */
@Data
@TableName("t_professor_category")
public class ProfessorCategory {

    @TableId
    private Integer pkId;        // 主键ID

    private String name;          // 分类名称

    private String cover;         // 封面

    private Timestamp createTime; // 创建时间

    private Timestamp updateTime; // 更新时间

    private Integer level;        // 分类级别

    private Integer parentId;     // 上级分类ID

    private Integer sort;         // 排序值
}
