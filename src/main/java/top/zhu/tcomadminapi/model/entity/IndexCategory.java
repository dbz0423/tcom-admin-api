package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import top.zhu.tcomadminapi.common.model.TreeNode;
import top.zhu.tcomadminapi.model.vo.MenuVO;

import java.sql.Timestamp;


@Data
@TableName("t_index_category")
public class IndexCategory{


    @TableId(type = IdType.AUTO)
    private Integer pkId;         // pk_id

    private String name;       // name

    @TableField("parent_id")
    private Integer parentId;     // 父级分类ID

    private Integer level;     // 层级

    private Integer isShow;    // 是否显示

    private Integer sort;      // 排序

    private Integer type;      // 类型

    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime;  // create_time

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;  // update_time

}
