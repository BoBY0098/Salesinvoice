package com.amirhossein.salesinvoice.configuration;

import com.amirhossein.salesinvoice.components.CustomAuthenticationEntryPoint;
import com.amirhossein.salesinvoice.filters.JwtFilter;
import com.amirhossein.salesinvoice.services.UserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

    private final UserDetailService userDetailService;
    private final JwtFilter jwtFilter;
    private final String[] openRoutes = new String[]{
            "/files/**",
            "/v2/api-docs/**",
            "/swagger.json",
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/webjars/**",

            "/**/login",
            "/**/register",
            "/**/otpCode",
            "/**/refreshtoken",


    };
    private final String[] lockedRoutes = new String[]{
            /* "/" + PANEL + "/admins",
             "/" + PANEL + "/checkField",
             "/" + PANEL + "/coupon",
             "/" + PANEL + "/docreserve/transaction",*/
    };
    @Autowired
    private final Environment env;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.cors().and().csrf().disable()
                    .authorizeRequests()
                    .antMatchers(lockedRoutes).authenticated()
                    .antMatchers(openRoutes).permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers(
                    // HttpMethod.GET,
                    openRoutes
            );
        }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
    }

}
