package com.wwy.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class MultiHttpSecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        // ensure the passwords are encoded properly
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
        return manager;
    }

//    @Configuration
//    @Order(1)
//    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                .antMatcher("/api/**")
//                .authorizeRequests(authorize -> authorize
//                    .anyRequest().hasRole("ADMIN")
//                )
//                .httpBasic(withDefaults());
//        }
//    }
//
//    @Configuration
//    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                .authorizeRequests(authorize -> authorize
//                    .anyRequest().authenticated()
//                )
//                .formLogin(withDefaults());
//        }
//    }
}