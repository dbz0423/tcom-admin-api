package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_book") // 指定数据库表名
public class Book {

    @TableId
    private Integer pkId; // 主键ID

    private Integer categoryId; // 分类ID

    private String title; // 书名

    private String cover; // 封面

    private String titleEn; // 英文书名

    private Integer state; // 状态

    private Integer managerId; // 管理员ID

    private Byte sort; // 排序字段

    private Integer totalPage; // 总页数

    @TableField(value = "create_time")
    private Timestamp createTime; // 创建时间

    @TableField(value = "update_time")
    private Timestamp updateTime; // 更新时间

    private Integer browseNum; // 浏览量
}
