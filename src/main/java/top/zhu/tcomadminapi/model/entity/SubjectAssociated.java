package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_subject_associated")
public class SubjectAssociated {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Long pkId;           // 唯一标识
    private Long subjectId;      // 专题id
    private Long contentId;      // 关联的内容id（如课程、书籍等）
    private Integer type;        // 关联类型：0课程 1书本 2考卷 3资讯 4播客
    private Long labelId;        // 关联标签id
    private Timestamp createTime; // 创建时间
    private Timestamp updateTime; // 更新时间
}

