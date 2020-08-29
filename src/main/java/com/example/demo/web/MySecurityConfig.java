package com.example.demo.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author: zhh
 * @description: 安全配置
 * @data: 2020-08-29
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/static/**");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	http.csrf().disable().authorizeRequests()
    	.antMatchers("/").authenticated()
    	.antMatchers("/teacher/**").hasRole("TEACHER")
    	.antMatchers("/student/**").hasRole("STUDENT")
    	.antMatchers("/admin/**").hasRole("ADMIN")
    	.anyRequest().denyAll()
    	.and()
        .formLogin();

    }
}