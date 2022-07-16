package com.inquizit.service;

import com.inquizit.model.domain.User;
import com.inquizit.model.enums.RoleType;

public interface UserService {

    boolean doesUserExist(String email);

    void addUser(String email, String name);

    void updateUserRole(String email, RoleType type);

    User getUserData(String email);

}
