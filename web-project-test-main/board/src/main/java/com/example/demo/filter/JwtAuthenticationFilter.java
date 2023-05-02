package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.provider.TokenProvider;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // Request가 들어왔을 때 Request Header의 Authorization 필드의 Bearer Token을 가져옴
    // 가져온 토큰을 검증하고 검증 결과를 SecurityContext에 추가

    @Autowired private TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

         try {
            String token = parseBearerToken(request);

            // 대소문자 구분없이 "null"이 아니라면
            if (token != null && !token.equalsIgnoreCase("null")) {
                // 토큰 검증에서 payload의 userEmail을 가져옴
                String userEmail = tokenProvider.vaildate(token);

                // SecurityContext에 추가할 객체
                AbstractAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userEmail, null, AuthorityUtils.NO_AUTHORITIES);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // SecurityContext에 AbstractAuthenticationToken 객체를 추가하여 
                // 해당 Thread가 지속적으로 인증 정보를 가질 수 있도록 해줌
                // SecurityContextHolder가 interface라서 .createEmptyContext()로 빈 context를 만든 후 사용
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                securityContext.setAuthentication(authenticationToken);
                SecurityContextHolder.setContext(securityContext);
            }    
         } catch (Exception exception) {
            exception.printStackTrace();
         }

         filterChain.doFilter(request, response);
        
    }

    // Request가 들어왔을 때 Request Header의 Authorization 필드의 Bearer Token을 가져오는 메서드
    // token 값이 String이기 때문
    // Request에 있는 Header를 들고 올것이기 때문에 HttpServletRequest
    private String parseBearerToken (HttpServletRequest request) {
        // header의 Autorization 필드를 가져옴
        String bearerToken = request.getHeader("Authorization");

        // bearerToken 값이 null이거나 빈값인지 체크
        // && 해당 String의 값이 "Bearer " 로 시작하는지
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        
        return null;
    }
    
}