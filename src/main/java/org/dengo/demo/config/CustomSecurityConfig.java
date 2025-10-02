package org.dengo.demo.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dengo.demo.security.filter.JWTCheckFilter;
import org.dengo.demo.security.handler.APILoginFailHandler;
import org.dengo.demo.security.handler.APILoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@Log4j2
@RequiredArgsConstructor
@EnableMethodSecurity
public class CustomSecurityConfig {
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    log.info("----------------security config--------------");
    
    http.cors(httpSecurityCorsConfigurer -> {
      httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource());
    });
    
    //세션 생성을 안하게
    http.sessionManagement(sessionManagementConfigurer -> {
      sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    });
    
    //csrf는 리퀘스트 위조방지
    http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());
    
    http.formLogin(config -> {
      config.loginPage("/api/member/login"); //로그인 페이지 설정
      config.successHandler(new APILoginSuccessHandler()); //로그인 성공하면 successHandler 동작
      config.failureHandler(new APILoginFailHandler()); //로그인 실패할 때 200으로 전달되지만 로그인에 실패.
    });
    
    //
    http.addFilterBefore(new JWTCheckFilter(), UsernamePasswordAuthenticationFilter.class);
    
    
    
    return http.build();
  }
  
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
    configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
    configuration.setAllowCredentials(true);
    
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    
    return source;
    
  }
}

