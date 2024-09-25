package com.session.front.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userId;
    @Setter
    private String password;
    @Setter
    private String email;

    public User(String userId, String password, String email) {
        this.userId = userId;
        this.password = password;
        this.email = email;
    }
}
