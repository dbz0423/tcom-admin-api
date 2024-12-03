package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;


@Data
@TableName("t_index_category")
public class IndexCategory {

    private Long pkId;         // pk_id
    private String name;       // name
    private Long parentId;     // parent_id
    private Integer level;     // level
    private Integer isShow;    // is_show
    private Integer sort;      // sort
    private Integer type;      // type
    private Timestamp createTime;  // create_time
    private Timestamp updateTime;  // update_time

}
