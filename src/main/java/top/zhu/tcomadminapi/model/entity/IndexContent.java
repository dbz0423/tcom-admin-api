package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_index_content")
public class IndexContent {

    private Long pkId;         // pk_id
    private Long categoryId;   // category_id
    private Long contentId;    // content_id
    private String title;      // title
    private Integer type;      // type
    private Timestamp createTime;  // create_time
    private Timestamp updateTime;  // update_time

}
