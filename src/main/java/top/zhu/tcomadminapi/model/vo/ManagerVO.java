package top.zhu.tcomadminapi.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ManagerVO {

    private Integer pkId;
    private String account;
    private String password;
    private String salt;
    private String nickname;
    private String avatar;
    private Integer isEnabled;
    private String level;
    private Integer code;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer prohibitType;
    private Integer deleteFlag;

}
