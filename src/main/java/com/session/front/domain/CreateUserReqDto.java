package com.session.front.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUserReqDto {
    private String userId;
    private String password;
    private String email;
}
