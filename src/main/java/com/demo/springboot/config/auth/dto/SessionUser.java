package com.demo.springboot.config.auth.dto;

import com.demo.springboot.domain.posts.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
// Serializable을 사용하는 이유는 SessionUser을 따로 만드는 이유와 비슷한데,
// 만약 User을 그대로 사용하고 Serialize를 넣는다면 User가 Entity여서 다른 것들과 관계를 가질 때 부작용이 일어날 수 있다. (성능 이슈등)
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
//    TODO: p.190
}
