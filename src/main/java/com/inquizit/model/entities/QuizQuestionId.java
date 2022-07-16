package com.inquizit.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@Embeddable
public class QuizQuestionId implements Serializable {

    private String quizId;
    private Integer quesNum;

}
