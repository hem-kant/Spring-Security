package com.hemkant.SpringSecurity.InMemAuth.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ApplicationSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/myaccount","/myAccountBalance","/myCards","/myLoansDetails").authenticated()
                .antMatchers("/notices","/contact").permitAll()
                .and().formLogin()
                .and().httpBasic();
        /**http.authorizeRequests().anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();*/
        return http.build();
    }

    /**This approach  "InMem" is not recommended for PROD.*/

   /** @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails admin= User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123456")
                .authorities("admin")
                .build();

        UserDetails read= User.withDefaultPasswordEncoder()
                .username("user1")
                .password("123456")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(admin,read);
    }*/

   /** new method using jdbc which will get the user from mySQL for auth. */
   @Bean
   public UserDetailsService userDetailsService(DataSource dataSource){
       return new JdbcUserDetailsManager(dataSource);
   }

   /** password will be treated as a plain text*/
   @Bean
    public PasswordEncoder passwordEncoder(){
       return NoOpPasswordEncoder.getInstance();
   }
}
