package com.masf.example.service;

import com.masf.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> allUser() {
        List<User> userList = new ArrayList<>();
        return userList;
    }

    public User getUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName(id + "");
        return user;
    }
}
