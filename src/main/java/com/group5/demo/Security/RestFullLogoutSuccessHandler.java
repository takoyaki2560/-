package com.group5.demo.Security;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.group5.demo.utils.JwtUtil.*;

public class RestFullLogoutSuccessHandler implements LogoutSuccessHandler {
    private final String LOGGED_IN = "logged_in";
    private final String USER_TYPE = "user_type";
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map<String, String> result = new HashMap<>();
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // 解析 Token
            Claims claims = Jwts.parser()
                    // 验签
                    .setSigningKey(SECRET)
                    // 去掉 Bearer
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();

            // 拿用户名
            String user = claims.getSubject();
            result.put("logout", "suscess");
        }else{
            result.put("logout", "no token");
        }
        PrintWriter out = response.getWriter();
        ObjectMapper om = new ObjectMapper();
        out.write(om.writeValueAsString(result));
        addSameSiteCookieAttribute(response);
        out.flush();
        out.close();
    }

    private void addSameSiteCookieAttribute(HttpServletResponse response) {
        Collection<String> headers = response.getHeaders(HttpHeaders.SET_COOKIE);
        boolean firstHeader = true;
        for (String header : headers) {
            System.out.println(header);
            if (firstHeader) {
                response.setHeader(HttpHeaders.SET_COOKIE,
                        String.format("%s; %s", header, "SameSite=none; Secure"));
                firstHeader = false;
                continue;
            }
            response.addHeader(HttpHeaders.SET_COOKIE,
                    String.format("%s; %s", header, "SameSite=none; Secure"));
        }
    }
}
