package com.inquizit.model.entities;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="quiz_question", schema = "public")
public class QuizQuestionEntity {

    @EmbeddedId
    private QuizQuestionId quesId;
    private String question;
    private Integer quesType;

}
