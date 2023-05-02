package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    //# CORS (Cross - Origin Resource Sharing) 정책 
    //? 다른 출저의 자원을 공유할 수 있도록 설정하는 권한 정책
    //? ex) front: 3000 포트 back: 4040 포트라서 연결할 수 없으니 CORS를 사용하여 연결
    // 리소스에 대한 접근을 관리할 때
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
                    // 모든 백엔드의 경로 허용
        corsRegistry.addMapping("/**")
                    // 모든 출처에 대해 허용
                    .allowedOrigins("*")
                    // 모든 메소드에 대해 허용
                    .allowedMethods("*");
    }

}
