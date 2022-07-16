package com.inquizit.service;

import com.inquizit.converter.EntityToDomain;
import com.inquizit.model.domain.User;
import com.inquizit.model.entities.UserEntity;
import com.inquizit.model.enums.RoleType;
import com.inquizit.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean doesUserExist(String email) {
        Optional<UserEntity> optional = userRepository.findById(email);
        return optional.isPresent();
    }

    @Override
    public void addUser(String email, String name) {
        UserEntity user = new UserEntity(email, name, RoleType.NONE.getValue());
        userRepository.save(user);
    }

    @Override
    public void updateUserRole(String email, RoleType type) {
        Optional<UserEntity> optional = userRepository.findById(email);

        if (optional.isPresent()) {
            UserEntity entity = optional.get();
            entity.setType(type.getValue());
            userRepository.save(entity);
        }
    }

    @Override
    public User getUserData(String email) {
        Optional<UserEntity> optional = userRepository.findById(email);

        if (optional.isPresent()) {
            UserEntity entity = optional.get();
            return EntityToDomain.convert(entity);
        }

        return null;
    }
}
