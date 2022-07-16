package com.inquizit.service;

import com.inquizit.model.domain.User;
import com.inquizit.model.enums.RoleType;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean doesUserExist(String email) {
        return true;
    }

    @Override
    public void addUser(String email, String name) {

    }

    @Override
    public void updateUserRole(String email, RoleType type) {

    }

    @Override
    public User getUserData(String email) {
        return new User("mariah.zammit", "Mariah Zammit", RoleType.TEACHER);
    }
}
