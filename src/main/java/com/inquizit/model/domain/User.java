package com.inquizit.model.domain;

import com.inquizit.model.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String email;
    private String name;
    private RoleType type;

}
