package com.hemkant.FarziBankSpringSecurityBackend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/myaccount","/myAccountBalance","/myCards","/myLoansDetails").authenticated()
                .antMatchers("/notices","/contact").permitAll()
                .and().formLogin()
                .and().httpBasic();
        /*http.authorizeRequests().anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();*/
        return http.build();
    }
}
