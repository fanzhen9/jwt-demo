package com.example.springbootjdk11demo.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

@Slf4j
public class JWTUtil {

    private static final String TOKEN_SECRET = "springboot";


    /**
     *
     * @param userId 用户id
     * @param realName 这个人的昵称
     * @param userName 这个人的名字
     * 加密密钥：这个人的id加上一串字符串
     * @return
     */
    public static String createToken(String userId,String realName,String userName){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE,30);
        Date date = now.getTime();
        return JWT.create().withAudience(userId)
                .withIssuedAt(new Date())
                .withExpiresAt(date)
                .withClaim("userName",userName)
                .withClaim("realName",realName)
                .sign(Algorithm.HMAC256(userId+TOKEN_SECRET));
    }

    /**
     * 验证合法性
     * @param token
     * @param userId
     */
    public static void verifyToken(String token,String userId){
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(userId+TOKEN_SECRET)).build();
            jwt = verifier.verify(token);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("验证失败");
        }
    }

    /**
     * 获取签发对象
     * @param token
     * @return
     */
    public static String getAudience(String token){
        String userId = null;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("解析失败");
        }
        return userId;
    }

    /**
     * 通过载荷名字获取载荷的值
     * @param token
     * @param name
     * @return
     */
    public static Claim getClaimByName(String token,String name){
        return JWT.decode(token).getClaim(name);
    }

    public static void main(String[] args) {
        System.out.println(createToken("10001","老六","王强"));
    }
}
