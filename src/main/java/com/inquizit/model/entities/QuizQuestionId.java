package com.inquizit.model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@Embeddable
@EqualsAndHashCode
public class QuizQuestionId implements Serializable {

    private String quizId;
    private int quesNumber;

}
