package com.theonlyfer.springbootmongoapp.configuration;

import com.theonlyfer.springbootmongoapp.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try{
            String header = request.getHeader("Authorization");
            List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            if (!request.getRequestURI().matches("^/mongo-app/login($|/.*)")
                    && !request.getRequestURI().matches("^/mongo-app/document/hello")){
                if (header != null && header.startsWith("Bearer ")) {
                    String token = header.substring(7);
                    if (jwtUtil.validateToken(token)) {
                        UsernamePasswordAuthenticationToken authenticationToken =
                                new UsernamePasswordAuthenticationToken(jwtUtil.extractUsername(token), null, authorities);
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                        filterChain.doFilter(request, response);
                    } else {
                        filterChain.doFilter(request, response);
                    }
                } else {
                    filterChain.doFilter(request, response);
                }
            } else {
                filterChain.doFilter(request, response);
            }
        }  finally {
            SecurityContextHolder.clearContext();
        }
    }

}
