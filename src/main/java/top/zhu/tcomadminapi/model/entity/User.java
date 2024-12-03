package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@TableName("user")  // 表名
public class User {

    /**
     * 主键id
     */
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

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
     * 个性签名
     */
    @TableField("slogan")
    private String slogan;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * OpenID
     */
    @TableField("open_id")
    private String openId;

    /**
     * UnionID
     */
    @TableField("union_id")
    private String unionId;

    /**
     * 是否启用：0：禁用，1：启用
     */
    @TableField("is_enable")
    private Integer isEnable;

    /**
     * 角色：具体角色含义需要根据需求定义
     */
    @TableField("role")
    private Integer role;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 省份ID
     */
    @TableField("province")
    private Integer province;

    /**
     * 城市ID
     */
    @TableField("city")
    private Integer city;

    /**
     * 区域ID
     */
    @TableField("area")
    private Integer area;

    /**
     * 医院ID
     */
    @TableField("hospital")
    private Integer hospital;

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
}
