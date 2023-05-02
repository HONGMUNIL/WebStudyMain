package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.filter.JwtAuthenticationFilter;

// 설정파일을 만들기 위한 annotation
// Bean을 등록하기 위한 annotation
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired JwtAuthenticationFilter authenticationFilter;
    
    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            // cors 정책 (현재 Application에서 작업을 해뒀기 때문에 기본 설정 사용)
            .cors().and()
            // csrf 대책 (CSRF에 대한 대책을 비활성화)
            .csrf().disable()
            // Basic 인증 사용 여부 (Bearer Token 인증 방법을 사용 중이기 때문에 비활성화)
            .httpBasic().disable()
            // session 기반 인증 사용 여부 (비활성화)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            // '/' "/api/auth/**" 모듈에 대해서 모두 허용 (인증을 하지 않고 사용 가능)
            .authorizeRequests().antMatchers("/", "/auth/**", "/api/**","/api/board/search-tag/**").permitAll()
            // 나머지 요청에 대해서는 모두 인증된 사용자만 사용 가능
            .anyRequest().authenticated();

        httpSecurity.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
    
}
