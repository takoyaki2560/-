package com.group5.demo.utils;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
        static final long EXPIRATIONTIME = 432_000_000;     // 5天
        public static final String SECRET = "group5";            // JWT密码
        public static final String TOKEN_PREFIX = "Bearer";        // Token前缀
        public static final String HEADER_STRING = "Authorization";// 存放Token的Header Key

    // JWT生成方法
        public static void addAuthentication(HttpServletRequest request,HttpServletResponse response, Authentication auth) {


            String Jti = UUID.randomUUID().toString();
            // 生成JWT
            String JWT = Jwts.builder()
                    // 保存权限（角色）
                    .setId(Jti)
                    .claim("authorities", auth.getAuthorities())
                    // 用户名写入标题
                    .setSubject(auth.getName())
                    // 有效期设置
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                    // 签名设置
                    .signWith(SignatureAlgorithm.HS512, SECRET)
                    .compact();
            // 将 JWT 写入 body
            try {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_OK);
                response.getOutputStream().println(JSONResult.fillResultString(0, "", JWT));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // JWT验证方法
        public static Authentication getAuthentication(HttpServletRequest request) {

            // 从Header中拿到token
            String token = request.getHeader(HEADER_STRING);
            if (token != null) {
                // 解析 Token
                try{
                    Claims claims = Jwts.parser()
                            // 验签
                            .setSigningKey(SECRET)
                            // 去掉 Bearer
                            .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                            .getBody();
                    String user = claims.getSubject();
                    // 得到 权限（角色）
                    List<?> authorities = (List<?>) claims.get("authorities");
                    List<GrantedAuthority> grantedAuthorities = authorities.stream()
                            .map(authority -> new SimpleGrantedAuthority((String)((Map)authority).get("authority")))
                            .collect(Collectors.toList());
                    // 返回验证令牌
                    return user != null ?
                            new UsernamePasswordAuthenticationToken(user, null, grantedAuthorities) :
                            null;
                }catch (Exception err){
                    return null;
                }

                // 拿用户名

            }
            return null;
        }
    }