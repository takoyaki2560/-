package com.group5.demo.service;

import com.group5.demo.entity.User;
import com.group5.demo.entity.auth;
import com.group5.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper mapper;

    public User findOne(String userName){
        return mapper.findUerByName(userName);
    }

    public Integer insert(User user){
        return  mapper.insert(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.findOne(username);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("User unfined");
        }else {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add( new auth("ROLE_"+user.role) );
            return new org.springframework.security.core.userdetails.User(username,user.password, authorities);
        }
    }
}
