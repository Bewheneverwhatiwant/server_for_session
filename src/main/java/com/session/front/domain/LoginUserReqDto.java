package com.session.front.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginUserReqDto {
    private String userId;
    private String password;
}
