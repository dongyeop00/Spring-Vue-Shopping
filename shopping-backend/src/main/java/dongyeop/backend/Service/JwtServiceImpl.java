package dongyeop.backend.Service;

import io.jsonwebtoken.*;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public class JwtServiceImpl implements JwtService {

    private Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Override
    public String getToken(String key, Object value) {

        Date expTime = new Date();
        expTime.setTime(expTime.getTime() + 1000 * 60 * 5);

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("typ", "JWT");
        headerMap.put("alg", "HS256");

        Map<String, Object> map = new HashMap<>();
        map.put(key, value);

        JwtBuilder builder = Jwts.builder()
                .setHeader(headerMap)
                .setClaims(map)
                .setExpiration(expTime)
                .signWith(secretKey);

        return builder.compact();
    }

    @Override
    public Claims getClaims(String token) {
        return null;
    }
}

