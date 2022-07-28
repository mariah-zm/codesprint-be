package com.inquizit.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="quiz", schema = "public")
public class QuizEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private Integer passingScore;
    private Boolean showCorrect;
    private String msgSuccess;
    private String msgFailure;

}
