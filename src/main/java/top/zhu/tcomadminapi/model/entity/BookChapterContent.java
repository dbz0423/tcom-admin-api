package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_book_chapter_content")
public class BookChapterContent {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId; // 主键ID

    private Integer chapterId; // 分类ID

    private String content;

    @TableField(value="create_time",fill= FieldFill.INSERT)
    private Timestamp createTime;  // create_time

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;  // update_time

}
