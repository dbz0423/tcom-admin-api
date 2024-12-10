package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_user")  // 映射到 t_user 表
public class User {

    @TableId
    private Long pkId; // 主键 ID

    private String nickname;   // 昵称
    private String avatar;     // 头像
    private String slogan;     // 标语
    private String phone;      // 电话
    private String openId;     // openId
    private String unionId;    // unionId
    private Integer isEnable;  // 是否启用（0：禁用，1：启用）
    private Integer role;      // 角色
    private Integer roleId;    // 角色ID
    private Integer province;  // 省
    private Integer city;      // 市
    private Integer area;      // 区
    private Integer hospital;  // 医院

    @TableField(fill = FieldFill.INSERT)
    private Timestamp createTime;  // 创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;  // 更新时间
}
