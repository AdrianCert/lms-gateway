package lms.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


@Component
public class JwtProvider {
    
    @Value("$(jwt.secret)")
    private String secret;

    public Integer getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Integer.valueOf(claims.getSubject());
    }
}
