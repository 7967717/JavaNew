package io.rr.hyperskill.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.rr.hyperskill.test.UserInfo;
import lombok.SneakyThrows;

public class Helper {
    @SneakyThrows
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName("One");
        userInfo.setPhone("123");
        userInfo.setEnabled(true);
        ObjectMapper om = new ObjectMapper();
        System.out.println(om.writeValueAsString(userInfo));
    }

}
