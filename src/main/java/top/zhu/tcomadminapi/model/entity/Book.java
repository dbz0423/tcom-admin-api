package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_book") // 指定数据库表名
public class Book {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId; // 主键ID

    private Integer categoryId; // 分类ID

    private String title; // 书名

    @TableField(fill = FieldFill.INSERT)
    private String cover = "cover/saJjxTjc8w.png"; // 封面

    private String titleEn; // 英文书名

    private Integer state; // 状态

    private Integer managerId; // 管理员ID

    private Byte sort; // 排序字段

    private Integer totalPage; // 总页数

    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime;  // create_time

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;  // update_time

    private Integer browseNum; // 浏览量
}
