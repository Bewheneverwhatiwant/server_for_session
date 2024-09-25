package com.session.front.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateUserPasswordReqDto {
    private Long id;
    private String password;
}
