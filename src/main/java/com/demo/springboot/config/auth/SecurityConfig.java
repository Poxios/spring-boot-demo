package com.demo.springboot.config.auth;

import com.demo.springboot.domain.posts.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해서 옵션 disable 해줌.
                .and()
                .authorizeRequests() // url별 권한 관리를 설정하는 곳.
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated() // 나머지 anyRequest들은 authenticated, 즉 로그인한 사용자들에게만 허용한다.
                .and()
                .logout()
                .logoutSuccessUrl("/") // 로그아웃 성공시 / 주소로 이동한다는 뜻.
                .and()
                .oauth2Login()// 오어스 설정의 진입점
                .userInfoEndpoint()
                .userService(customOAuth2UserService); // 오어스 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체 등록
    }
}