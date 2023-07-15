package com.amirhossein.salesinvoice.configuration;

import com.amirhossein.salesinvoice.components.Hmac512PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Amin Ne'mati
 * Project: mom_life
 * @version 0.0.1
 * @since ۲۰۲۱/12/20
 */
@Component
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder encoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("SSHA-512", new Hmac512PasswordEncoder("salt"));
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        return new DelegatingPasswordEncoder("SSHA-512", encoders);
    }

}
