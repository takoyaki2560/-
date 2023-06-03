package com.group5.demo.utils;

import com.group5.demo.entity.User;
import com.group5.demo.entity.auth;
import com.group5.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    final PasswordEncoder passwordEncoder;
    final UserService service;

    public CustomAuthenticationProvider(UserService service,PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.service = service;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = service.findOne(name);

        // 认证逻辑
        if (user != null) {
            if (user.password.equals(passwordEncoder.encode(password))) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add( new auth("ROLE_"+user.role) );
                // 生成令牌
                Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
                return auth;
            }else {
                throw new BadCredentialsException("wrong password");
            }
        }else{
            throw new BadCredentialsException("user not found");
        }
    }

    // 是否可以提供输入类型的认证服务
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
