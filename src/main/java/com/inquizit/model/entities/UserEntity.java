package com.inquizit.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="user", schema = "public")
public class UserEntity {

    @Id
    private String email;
    private String name;
    private int type;

}
