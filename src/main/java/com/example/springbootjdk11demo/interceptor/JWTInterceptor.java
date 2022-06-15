package com.example.springbootjdk11demo.interceptor;

import com.example.springbootjdk11demo.annoation.NoToken;
import com.example.springbootjdk11demo.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author fox
 */
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(method.isAnnotationPresent(NoToken.class)){
            return true;
        }
        log.debug("【jwt验证】 开启" );
        if(StringUtils.isEmpty(token)){
            throw new RuntimeException("token为空");
        }
        String userId = JWTUtil.getAudience(token);

        //判断用户id是否存在

        JWTUtil.verifyToken(token,userId);
        String userName = JWTUtil.getClaimByName(token,"userName").asString();
        String realName = JWTUtil.getClaimByName(token,"realName").asString();
        request.setAttribute("userName",userName);
        request.setAttribute("realName",realName);
        return true;
    }

}
