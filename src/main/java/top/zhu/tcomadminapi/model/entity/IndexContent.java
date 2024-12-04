package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_index_content")
public class IndexContent {

    private Long pkId;         // pk_id

    private Long categoryId;   // 分类id

    private Long contentId;    // 关联id

    private String title;      // title

    private Integer type;      // type

    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime;  // create_time

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;  // update_time

}
