package com.hp.client;

import com.hp.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements  UserClient {
    @Override
    public User queryById(Long id) {
        User user=new User();
        user.setName("用户查询出现异常");
        return user;
    }
}
