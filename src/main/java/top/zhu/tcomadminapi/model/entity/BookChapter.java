package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_book_chapter")
public class BookChapter {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId; // 主键ID

    @TableField("start_page")
    private Integer startPage;

    @TableField("num")
    private Integer num;


}
