package io.rr.hyperskill.h2;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "user")
public class User {
    @Id
    @Column
    private long userId;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean enabled;
}
