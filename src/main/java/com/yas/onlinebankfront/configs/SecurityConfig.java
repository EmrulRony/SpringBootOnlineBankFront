package com.yas.onlinebankfront.configs;

import com.yas.onlinebankfront.service.UserSecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserSecurityService userSecurityService;

    private static final String[] PUBLIC_MATCHER = {
                                                        "/webjars/**",
                                                        "/css/**",
                                                        "/fonts/**",
                                                        "/bootstrap/**",
                                                        "/js/**",
                                                        "/images/**",
                                                        "/",
                                                        "/about/**",
                                                        "/contact/**",
                                                        "/error/**/*",
                                                        "/console/**",
                                                        "/common/**",
                                                        "/signup"
                                                     };

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(PUBLIC_MATCHER)
            .permitAll().anyRequest().authenticated()
            .and()
            .csrf().disable().cors().disable()
            .formLogin().loginPage("/index").failureUrl("/index?error").defaultSuccessUrl("/test").permitAll()
            .and()
            .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index?logout").deleteCookies("remember-me").permitAll()
            .and()
            .rememberMe();
    }
}