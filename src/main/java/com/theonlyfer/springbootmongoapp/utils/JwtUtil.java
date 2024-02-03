package com.theonlyfer.springbootmongoapp.utils;

import com.theonlyfer.springbootmongoapp.configuration.SecretKeyConfiguration;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    @Autowired
    private SecretKeyConfiguration secretKeyConfiguration;

    public String generateToken(String user) {
        int timeInHours = 2;
        return Jwts.builder()
                .setSubject(user)//hours*minutes*seconds*milliseconds
                .setExpiration(new Date(System.currentTimeMillis() + (long) timeInHours * 60* 60* 1000))
                .signWith(Keys.hmacShaKeyFor(secretKeyConfiguration.getSecretKey().getBytes()))
                .compact();
    }

    public boolean validateToken(String bearerToken) {
        boolean validateToken = false;
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(secretKeyConfiguration.getSecretKey().getBytes())
                    .build()
                    .parseClaimsJws(bearerToken);
            return  !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            //token expired
            return validateToken;
        }
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKeyConfiguration.getSecretKey().getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
