package com.inquizit.model.common;

import com.inquizit.model.enums.QuestionType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuizQuestion {

    private String question;
    private QuestionType type;
    private List<QuizAnswer> answers;

}
