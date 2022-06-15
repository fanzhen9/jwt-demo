package com.example.springbootjdk11demo.web;

import com.example.springbootjdk11demo.annoation.NoToken;
import com.example.springbootjdk11demo.response.LoginResponse;
import com.example.springbootjdk11demo.utils.JWTUtil;
import com.example.springbootjdk11demo.vo.ResponseVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @PostMapping("/login")
    @NoToken
    public ResponseVO login(String userName, String passWord){
        LoginResponse response = new LoginResponse();
        String token = JWTUtil.createToken("10001","老六",userName);
        response.setToken(token);
        ResponseVO<LoginResponse> responseResponseVO = new ResponseVO<>();
        responseResponseVO.setCode(0);
        responseResponseVO.setMessage("登录成功");
        responseResponseVO.setData(response);
        return responseResponseVO;
    }
}
