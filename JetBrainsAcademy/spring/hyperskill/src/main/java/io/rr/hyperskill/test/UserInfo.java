package io.rr.hyperskill.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInfo {
    private int id;
    private String name;
    private String phone;
    private boolean enabled;
}
