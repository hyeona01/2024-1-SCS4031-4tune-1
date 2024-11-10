package com.fortune.eyesee.utils;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    @Value("${jwt.refreshExpiration}")
    private long refreshExpiration;

    @Value("${jwt.studentExpiration}")
    private long studentExpiration;

    // Access Token 생성
    public String generateToken(Integer adminId) {
        return Jwts.builder()
                .setSubject(adminId.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    // Refresh Token 생성
    public String generateRefreshToken(Integer adminId) {
        return Jwts.builder()
                .setSubject(adminId.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpiration))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    // Session Token 생성 (Student용) Refresh 토큰은 없음.
    public String generateSessionToken(Integer sessionId, Integer userNum) {
        return Jwts.builder()
                .setSubject("session:" + sessionId + ":" + userNum)  // 세션 ID와 학생 번호로 subject 설정
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + studentExpiration))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    // 토큰에서 AdminId 추출
    public Integer getAdminIdFromToken(String token) {
        String subject = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return Integer.parseInt(subject);
    }

    // 토큰에서 Session ID와 UserNum 추출
    public Integer[] getSessionInfoFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        String subject = claims.getSubject();

        if (subject.startsWith("session:")) {
            String[] parts = subject.split(":");
            Integer sessionId = Integer.parseInt(parts[1]);
            Integer userNum = Integer.parseInt(parts[2]);
            return new Integer[]{sessionId, userNum};
        }

        throw new JwtException("Invalid session token");
    }

    // 토큰 유효성 검증
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}