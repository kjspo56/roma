package com.board.roma.handler;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtHandler {

    private String type = "Bearer ";

    public String createToken(String encodedKey, String subject, long maxAgeSeconds) {
        Date now = new Date();
        return type + Jwts.builder() //jwt 빌드 시작
                .setSubject(subject) //토큰에 저장될 데이터 지정(이 프로젝트에서는 Member의 id값을 넣어준다)
                .setIssuedAt(now) //토큰 발급일 지정. createToken은 초단위로 입력받지만 Date는 ms 단위이기떄문에 x 1000 해줌
                .setExpiration(new Date(now.getTime() + maxAgeSeconds * 1000L)) //토큰 만료일자 지정
                .signWith(SignatureAlgorithm.HS256, encodedKey) //파라미터로 받은 key로 SHA-256 알고리즘 사용하여 서명
                .compact(); //주어진 정보로 토큰정보 생성
    }

    public String extractSubject(String encodedKey, String token) {
        return parse(encodedKey, token).getBody().getSubject();
    }

    public boolean validate(String encodedKey, String token) {
        try {
            parse(encodedKey, token);
            return true;
        } catch (JwtException e) {
            return false;   //예외가 발생됬다면, 유효하지 않은 토큰으로 판단
        }
    }

    private Jws<Claims> parse(String key, String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(untype(token));
    }

    private String untype(String token) {
        return token.substring(type.length());
    }

}
