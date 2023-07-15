package com.amirhossein.salesinvoice.utils;



import com.amirhossein.salesinvoice.exceptions.BadRequestException;
import com.amirhossein.salesinvoice.exceptions.NotFoundException;
import com.amirhossein.salesinvoice.exceptions.UnAuthException;
import com.amirhossein.salesinvoice.models.user.User;
import com.amirhossein.salesinvoice.repositories.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;
import java.util.function.Function;

import static com.amirhossein.salesinvoice.filters.JwtFilter.*;

@Component
@AllArgsConstructor
public class JwtUtility implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;
    private static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60; //24 hour
    private static final long JWT_REFRESH_TOKEN_VALIDITY = 2 * 24 * 60 * 60; // 2 days
    private static final String JWT_SECRET = "Sale_inVoice_Dev4jWtSecret&tOkens";

    private final UserRepository userRepository;


    //retrieve username from jwt token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //for retrieving any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
    }

    public Claims getClaimsFromToken(String token)  {
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //generate token for user
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    //generate token for user
    public String generateToken(UserDetails userDetails, Map<String, Object> inputClaims) {
        Map<String, Object> claims = new HashMap<>();
        if (inputClaims != null && !inputClaims.isEmpty())
            claims = inputClaims;
        return doGenerateToken(claims, userDetails.getUsername());
    }

    public String generateRefreshToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateRefreshToken(claims, userDetails.getUsername());
    }

    public String generateRefreshToken(UserDetails userDetails, Map<String, Object> inputClaims) {
        Map<String, Object> claims = new HashMap<>();
        if (inputClaims != null && !inputClaims.isEmpty())
            claims = inputClaims;
        return doGenerateRefreshToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        claims.put(TOKEN_TYPE, ORIGINAL_TOKEN);//set token type
        return makeToken(claims,subject);
    }

    private String doGenerateRefreshToken(Map<String, Object> claims, String subject) {
        claims.put(TOKEN_TYPE, REFRESH_TOKEN);//set token type
        return makeToken(claims,subject);
    }

    private String makeToken(Map<String, Object> claims, String subject){

        Date expiration = new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000);


        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setId(UUID.randomUUID().toString())
                .setNotBefore(new Date(System.currentTimeMillis()))//cant be used before this date
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .compressWith(CompressionCodecs.GZIP )
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
    }


    //validate token
    public Boolean validateToken(String token, UserDetails userDetails) throws BadRequestException, UnAuthException {
        String username = getUsernameFromToken(token);
        Map<String, Object> claims = getAllClaimsFromToken(token);
        if (claims.containsKey(TOKEN_TYPE) && !claims.get(TOKEN_TYPE).toString().equalsIgnoreCase(ORIGINAL_TOKEN))
            throw new BadRequestException("token type is incorrect");


        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    //validate refresh token
    public Boolean validateRefreshToken(String token, UserDetails userDetails) throws BadRequestException, UnAuthException {
        String username = getUsernameFromToken(token);
        Map<String, Object> claims = getAllClaimsFromToken(token);
        if (claims.containsKey(TOKEN_TYPE) && !claims.get(TOKEN_TYPE).toString().equalsIgnoreCase(REFRESH_TOKEN))
            throw new BadRequestException("token type is incorrect");

        return (username.equalsIgnoreCase(userDetails.getUsername()) && !isTokenExpired(token));
    }


}