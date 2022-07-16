package com.inquizit.model.domain;

import com.inquizit.model.enums.RoleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String email;
    private String name;
    private RoleType type;

}
