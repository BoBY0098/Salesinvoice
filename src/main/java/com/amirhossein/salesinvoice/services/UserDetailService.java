package com.amirhossein.salesinvoice.services;

import com.amirhossein.salesinvoice.components.Generator;
import com.amirhossein.salesinvoice.configuration.WebSecurityConfig;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Amin Ne'mati
 * Project: mom_life
 * @version 0.0.1
 * @since ۲۰۲۱/09/12
 */
@Service
@AllArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final Generator generator=new Generator();
    private final WebSecurityConfig webSecurityConfig=new WebSecurityConfig();


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        String generatedString=generator.alphaNumericString(36);
        String randomPass = webSecurityConfig.encoder().encode(generatedString).replace("{SSHA-512}","");
        return new User(userName, randomPass, new ArrayList<>());
    }
}
