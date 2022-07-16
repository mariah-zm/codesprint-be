package com.inquizit.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
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
    private Integer numQuestions;

    @OneToMany(mappedBy = "quiz_question", cascade = CascadeType.ALL)
    private List<QuizQuestionEntity> questions;

}