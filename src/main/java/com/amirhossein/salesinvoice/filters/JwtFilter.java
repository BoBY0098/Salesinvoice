package com.amirhossein.salesinvoice.filters;

import com.amirhossein.salesinvoice.exceptions.BadRequestException;
import com.amirhossein.salesinvoice.exceptions.UnAuthException;
import com.amirhossein.salesinvoice.models.response.ExceptionResponse;
import com.amirhossein.salesinvoice.services.UserDetailService;
import com.amirhossein.salesinvoice.utils.JwtUtility;
import com.google.gson.Gson;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


/**
 * @author Amin Ne'mati
 * Project: Zar-backend
 * @version 0.0.1
 * @since ۲۰۲۱/09/12
 */

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtility jwtUtility;
    private final UserDetailService userDetailService;

    public static final String TOKEN_TYPE = "tokenType";
    public static final String ORIGINAL_TOKEN = "originalToken";
    public static final String REFRESH_TOKEN = "refreshToken";


    @Autowired
    public JwtFilter(JwtUtility jwtUtility, UserDetailService userDetailService) {
        this.jwtUtility = jwtUtility;
        this.userDetailService = userDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException,
            IOException , UnAuthException, ExpiredJwtException {

        try {
            final String authorizationHeader = request.getHeader("Authorization");

            String username = null;
            String jwtToken = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwtToken = authorizationHeader.substring(7);
                username = jwtUtility.getUsernameFromToken(jwtToken);
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
                Boolean isValid = null;

                Map<String, Object> claims = jwtUtility.getClaimsFromToken(jwtToken);
                if (claims.containsKey(TOKEN_TYPE) && claims.get(TOKEN_TYPE).toString().equalsIgnoreCase(ORIGINAL_TOKEN)) {
                    isValid = jwtUtility.validateToken(jwtToken, userDetails);
                } else if (claims.containsKey(TOKEN_TYPE) && claims.get(TOKEN_TYPE).toString().equalsIgnoreCase(REFRESH_TOKEN)) {
                    isValid = jwtUtility.validateRefreshToken(jwtToken, userDetails);
                } else {
                    setErrorResponse(HttpStatus.UNAUTHORIZED, response, new UnAuthException("no token type found"));
                    //throw new UnAuthException("no token type found");
                }

                if (isValid != null && isValid) {

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            filterChain.doFilter(request, response);
        } catch (UsernameNotFoundException | BadRequestException | UnAuthException | ServletException | JwtException | IOException e) {

            HttpStatus status = null;

            if (e instanceof UsernameNotFoundException) {
                status = HttpStatus.NOT_FOUND;
            } else if (e instanceof BadRequestException || e instanceof ServletException) {
                status = HttpStatus.BAD_REQUEST;
            } else if (e instanceof UnAuthException || e instanceof JwtException) {
                status = HttpStatus.UNAUTHORIZED;
            } else {
                status = HttpStatus.SERVICE_UNAVAILABLE;
            }

            setErrorResponse(status, response, e);
        }
    }


    public void setErrorResponse(HttpStatus status, HttpServletResponse response, Throwable ex) {
        response.setStatus(status.value());
        response.setContentType("application/json");

        try {
            Gson gson = new Gson();
            ExceptionResponse exceptionResponse = new ExceptionResponse(status.value(), ex.getMessage());
            response.getWriter().write(gson.toJson(exceptionResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
