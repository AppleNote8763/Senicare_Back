package com.korit.senicare.provider;

import java.util.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import java.security.Key;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

// class: JWT 생성 및 검증 기능 제공자
// - JWT 암호화 알고리즘 HS256
// - 비밀키 환경변수에 있는 jwt.secret
// - JWT 만료기간 10시간

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secretkey;

    // JWT 생성 메서드
    public String create(String userId) {

        // 만료시간 = 현재시간 + 10시간
        Date expiredDate = Date.from(Instant.now().plus(10, ChronoUnit.HOURS));

        String jwt = null;

        try {

            // JWT 암호화에 사용할 key 생성
            Key key = Keys.hmacShaKeyFor(secretkey.getBytes(StandardCharsets.UTF_8));

            // JWT 생성
            jwt = Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(expiredDate)
                .compact();

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return jwt;

    }

    // 검증 메서드
    public String validate(String jwt) {

        String userId = null;

        try {

            // JWT 암호화에 사용할 key 생성
            Key key = Keys.hmacShaKeyFor(secretkey.getBytes(StandardCharsets.UTF_8));

            // jwt 검증 및 payload의 subject 값 추출
            userId = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody()
                .getSubject();

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return userId;

    }

}
