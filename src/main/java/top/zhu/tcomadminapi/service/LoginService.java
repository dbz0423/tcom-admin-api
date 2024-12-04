package top.zhu.tcomadminapi.service;

import top.zhu.tcomadminapi.model.vo.LoginTokenVO;
import top.zhu.tcomadminapi.model.vo.LoginVO;

public interface LoginService {

    /**
     * 使用账号密码登录
     * @param params
     * @return
     */
    LoginTokenVO loginByAccount(LoginVO params);
}
