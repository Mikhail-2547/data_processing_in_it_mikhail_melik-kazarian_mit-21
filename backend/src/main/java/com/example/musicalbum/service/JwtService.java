package com.example.musicalbum.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    // Token's expiration time
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    // Secret key for encryption (256-bit) (Symmetric key)
    private static final String SECRET_KEY = "3f431d2a6a8c4a66b9e5b5cf59b98e2f3f431d2a6a8c4a66b9e5b5cf59b98e2f";

    // Generating token via username
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Receive username via token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Is token valid?
    public boolean isTokenValid(String token, String userLogin) {
        final String username = extractUsername(token);
        return (username.equals(userLogin) && !isTokenExpired(token));
    }

    // Is token expired?
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Receive ANY data from token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Token parsing
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Receive Secret key in an Object view
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
