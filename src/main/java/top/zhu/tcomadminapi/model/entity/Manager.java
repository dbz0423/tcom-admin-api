package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@TableName("manager")  // 表明对应的数据库表名
public class Manager {

    /**
     * 主键ID
     */
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    /**
     * 账号
     */
    @TableField("account")
    private String account;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 盐值
     */
    @TableField("salt")
    private String salt;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 是否启用  0：否   1：是
     */
    @TableField("is_enabled")
    private Integer isEnabled;

    /**
     * 等级
     */
    @TableField("level")
    private String level;

    /**
     * 代码（标识）
     */
    @TableField("code")
    private Integer code;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 禁止类型
     */
    @TableField("prohibit_type")
    private Integer prohibitType;

    /**
     * 逻辑删除标识 0：正常 1：已删除
     */
    @TableField(value = "delete_flag", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;

}
