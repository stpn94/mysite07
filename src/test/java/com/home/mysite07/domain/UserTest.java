package com.home.mysite07.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTest {
    @Test
    void userEntityTest() {
        User user = new User();
        user.setName("종윤");
        user.setEmail("stpn94@gmail.com");
        System.out.println("[Entity] : " + user);
    }
}