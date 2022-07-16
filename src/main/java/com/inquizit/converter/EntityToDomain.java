package com.inquizit.converter;

import com.inquizit.model.domain.QuizAnswer;
import com.inquizit.model.domain.User;
import com.inquizit.model.entities.QuizAnswerEntity;
import com.inquizit.model.entities.UserEntity;
import com.inquizit.model.enums.RoleType;

public class EntityToDomain {

    public static QuizAnswer convert(QuizAnswerEntity entity) {
        return new QuizAnswer(entity.getAnswer(), entity.getScore(), entity.getIsCorrect());
    }

    public static User convert(UserEntity entity) {
        return new User(entity.getEmail(), entity.getName(), RoleType.getRoleType(entity.getType()));
    }

}
