package com.sykros.codebase.config.security.jwt;
import com.sykros.codebase.config.security.service.UserDetail;
import com.sykros.codebase.enums.message.configuration_log.JWT;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
public class JWTUtils {
    private static final Logger logger = LoggerFactory.getLogger(JWTUtils.class);

    @Value("${sykros.store.jwtSecret}")
    private String jwtSecret;

    public String generateJwtToken(Authentication authentication) {

        UserDetail userPrincipal = (UserDetail) authentication.getPrincipal();

        //    @Value("${bezkoder.app.jwtExpirationMs}")
        int jwtExpirationMs = 90000000;
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error(JWT.SignatureException.getExceptionLog(), e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error(JWT.MalformedJwtException.getExceptionLog(), e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error(JWT.ExpiredJwtException.getExceptionLog(), e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error(JWT.UnsupportedJwtException.getExceptionLog(), e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error(JWT.IllegalArgumentException.getExceptionLog(), e.getMessage());
        }

        return false;
    }
}
