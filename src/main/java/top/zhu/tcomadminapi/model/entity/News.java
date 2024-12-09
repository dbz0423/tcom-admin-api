package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 资讯表实体类
 */
@Data
@TableName("t_news")
public class News {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;            // 资讯ID

    private String title;            // 标题

    private String cover;            // 封面

    private String source;           // 来源

    private String label;            // 标签

    private Integer browseNum;       // 浏览量

    private Integer maxStudyTime;    // 最大学习时长

    private String content;          // 内容

    private Integer starNum;         // 星级评分

    private Integer state;           // 状态 (0-未发布, 1-已发布)

    private Integer managerId;       // 管理员ID

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;    // 创建时间

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;    // 更新时间
}
