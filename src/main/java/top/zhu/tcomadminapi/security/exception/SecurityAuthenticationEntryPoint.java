package top.zhu.tcomadminapi.security.exception;

import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import top.zhu.tcomadminapi.common.exception.ErrorCode;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.utils.HttpContextUtils;

import java.io.IOException;

public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());
        response.getWriter().print(JSONObject.toJSONString(Result.error(ErrorCode.UNAUTHORIZED)));
    }
}
