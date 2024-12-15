package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_resource_category")
public class ResourceCategory {

    // pk_id
    @TableId(type = IdType.AUTO)
    private Integer pkId;

    // title
    private String title;

    // 父级分类ID
    @TableField("parent_id")
    private Integer parentId;

    // 排序
    private Integer sort;

    // 类型
    private Integer type;

    // create_time
    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime;

    // update_time
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
