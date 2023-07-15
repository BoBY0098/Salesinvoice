package com.amirhossein.salesinvoice.components;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author Amin Ne'mati
 * Project: mom_life
 * @version 0.0.1
 * @since ۲۰۲۱/12/21
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {

        String jsonString = "no message";
        int status= HttpStatus.UNAUTHORIZED.value();
        try {
            jsonString = new JSONObject()
                    .put("uri", req.getRequestURI())
                    .put("message", "Unauthorized request , please send or check your token")
                    .put("status", status)
                    .put("exception", authException.getMessage())
                    .put("date", Calendar.getInstance().getTime())
                    //.put("Authorization Header",(req.getHeader("Authorization")!=null)?req.getHeader("Authorization"):"no Auth Header Found")
                    .toString();
        } catch (JSONException e) {

        }
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(status);
        res.getWriter().write(jsonString);
    }
}