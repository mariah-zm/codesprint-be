package com.inquizit.model.entities;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name="quiz_answer", schema = "public")
public class QuizAnswerEntity {

    @EmbeddedId
    private QuizAnswerId answerId;
    private String answer;
    private Integer score;
    private Boolean isCorrect;

    @MapsId("quesNum")
    @ManyToOne
    private QuizQuestionEntity question;

}
