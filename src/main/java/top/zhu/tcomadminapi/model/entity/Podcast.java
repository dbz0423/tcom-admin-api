package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_podcast") // 指定数据库表名
public class Podcast {

    @TableId
    private Integer pkId; // 主键ID

    private String title; // 播客标题

    private String cover; // 播客封面

    private String brief; // 播客简介

    private String author; // 作者

    private String authorAvatar; // 作者头像

    private String authorProfession; // 作者职业

    private String authorBrief; // 作者简介

    private String label; // 标签

    private Integer browseNum; // 浏览量

    private Integer starNum; // 星标数

    private Integer state; // 状态

    private Integer managerId; // 管理员ID

    @TableField(value = "create_time")
    private Timestamp createTime; // 创建时间

    @TableField(value = "update_time")
    private Timestamp updateTime; // 更新时间

    private Integer categoryId; // 分类ID

    private Integer sort; // 排序字段
}
