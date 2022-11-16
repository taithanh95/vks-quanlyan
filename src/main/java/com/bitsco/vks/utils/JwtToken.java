package com.bitsco.vks.utils;

import com.bitsco.vks.entity.AdmUsers;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

//@Component
//public class JwtToken implements Serializable {
//
//    private static final long serialVersionUID = -2550185165626007488L;
//
//    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Autowired
//    public  JwtToken(){}
//
//    private static String getAuthorizationHeader() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        return request.getHeader("Authorization");
//    }
//
//    private static String getToken() {
//        return getAuthorizationHeader().split(" ")[1];
//    }
//
////    public String getUsername()
////    {
////        String username = getUsernameFromToken(getToken());
////        return username;
////    }
//    public String getFullname()
//    {
//        String username = getFullNameFromToken(getToken());
//        return username;
//    }
//    public Claims getClaims(){
//        return getAllClaimsFromToken(getToken());
//    }
//
//    public String getUsernameFromToken(String token) {
//
//        return getClaimFromToken(token, Claims::getSubject);
//
//    }
//
//    public String getFullNameFromToken(String token) {
//
//        Claims cls = getAllClaimsFromToken((token));
//        return cls.get("fullName", String.class);
//
//    }
//
//
//    public Date getExpirationDateFromToken(String token) {
//
//        return getClaimFromToken(token, Claims::getExpiration);
//
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//
//        final Claims claims = getAllClaimsFromToken(token);
//
//        return claimsResolver.apply(claims);
//
//    }
//
//
//    private Claims getAllClaimsFromToken(String token) {
//
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//
//    }
//
//
//    private Boolean isTokenExpired(String token) {
//
//        final Date expiration = getExpirationDateFromToken(token);
//
//        return expiration.before(new Date());
//
//    }
//
//
//    public String generateToken(UserDetails userDetails) {
//
//        Map<String, Object> claims = new HashMap<>();
//
//        return doGenerateToken(claims, userDetails.getUsername());
//
//    }
//
//    public String generateToken(AdmUsers userDetails) {
//
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("userId", userDetails.getUserid());
//        //claims.put("fullName", userDetails.getFullname());
//        return doGenerateToken(claims, userDetails.getUserid());
//
//    }
//
//
//    private String doGenerateToken(Map<String, Object> claims, String subject) {
//
//        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//
//                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//
//                .signWith(SignatureAlgorithm.HS512, secret).compact();
//
//    }
//
//
//    public Boolean validateToken(String token) {
//
//        return !isTokenExpired(token);
//
////        final String username = getUsernameFromToken(token);
////
////        return (username.equals(userDetails.getUserid()) && !isTokenExpired(token));
//
//    }
//
//}
