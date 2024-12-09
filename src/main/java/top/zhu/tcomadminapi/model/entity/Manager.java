package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_manager")
public class Manager implements Serializable {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private String account;

    private String password;

    private String salt;

    private String nickname;

    private String avatar;

    private Integer isEnabled;

    private String level;

    private Integer code;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private Integer prohibitType;
}