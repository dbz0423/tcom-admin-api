package top.zhu.tcomadminapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.common.exception.ServerException;
import top.zhu.tcomadminapi.model.vo.LoginTokenVO;
import top.zhu.tcomadminapi.model.vo.LoginVO;
import top.zhu.tcomadminapi.security.cache.TokenStoreCache;
import top.zhu.tcomadminapi.security.user.ManagerDetail;
import top.zhu.tcomadminapi.security.utils.TokenUtils;
import top.zhu.tcomadminapi.service.LoginService;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final TokenStoreCache tokenStoreCache;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginTokenVO loginByAccount(LoginVO params) {
        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(params.getUsername(), params.getPassword()));
        } catch (DisabledException e) {
            throw new ServerException("该账号已被禁用");
        } catch (BadCredentialsException e) {
            throw new ServerException("用户名或密码错误");
        }
        // 用户信息
        ManagerDetail user = (ManagerDetail) authentication.getPrincipal();
        // 生成 accessToken
        String accessToken = TokenUtils.generator();
        // 保存用户信息到缓存
        tokenStoreCache.saveUser(accessToken, user);

        return new LoginTokenVO(accessToken);
    }
}
