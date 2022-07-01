package com.demo.springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
//TODO: p.111 보면서 마무리 해야함.
}
