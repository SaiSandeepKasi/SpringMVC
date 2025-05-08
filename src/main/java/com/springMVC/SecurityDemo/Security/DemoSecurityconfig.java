package com.springMVC.SecurityDemo.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityconfig {
    private static final Logger log = LoggerFactory.getLogger(DemoSecurityconfig.class);

    //add support for jdbc


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//define query to retrive a user by username
        theUserDetailsManager
                .setUsersByUsernameQuery("select user-id,pw,active from members where user_id=?");
//definr query to retrive the authorities/roles by username
        theUserDetailsManager
                .setAuthoritiesByUsernameQuery("select user-id,role from roles where user_id=?");
        return theUserDetailsManager;
    }


@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/").hasRole("Employee")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        )
                        .formLogin(form ->
                                form
                                        .loginPage("/showLoginPage")
                                        .loginProcessingUrl("/authenticateTheUser")
                                        .permitAll()
                        )
                .logout(logout -> logout.permitAll()
                        )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );

        return http.build();
    }
    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManagerger(){
        UserDetails john= User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("Employee")
                .build();
        UserDetails mary= User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("Employee","Manager")
                .build();
        UserDetails jeevan= User.builder()
                .username("jeevan")
                .password("{noop}test123")
                .roles("Employee","Manager","Admin")
                .build();
        return new InMemoryUserDetailsManager(john, mary, jeevan);
    }

 */
}
