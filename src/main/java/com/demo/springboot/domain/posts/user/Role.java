package com.demo.springboot.domain.posts.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
//    스프링 시큐리티에는 권한 코드에 항상 ROLE_이 앞에 있어야한다.
    GUEST("ROLE_GUEST", "Guest"),
    USER("ROLE_USER", "User");

    private final String key;
    private final String title;
}