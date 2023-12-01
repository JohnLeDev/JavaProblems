package com.lean.demoSpringSecurity.AppConfig;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

	@Value("${app.jwt-secret}")
	private String jwtSecret;

	@Value("${app-jwt-expiration-milliseconds}")
	private long jwtExpirationDate;

	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date currentDate = new Date();

		Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);
		Key dada = key();
		String token = Jwts.builder().subject(username).issuedAt(new Date()).expiration(expireDate).signWith(key())
				.compact();
		return token;
	}
	
	private Key key() {
		
		SecretKey secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode( jwtSecret));
		return secret;
	}

	// get username from Jwt token
	public String getUsername(String token) {

		Claims claims = Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(token).getPayload();
		String username = claims.getSubject();
		return username;
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().verifyWith((SecretKey) key()).build().parse(token);

			return true;
		} catch (MalformedJwtException e) {
			e.printStackTrace();
//            logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return false;
	}

}
