package com.inquizit.model.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizAnswer {

    private String answer;
    private int score;
    private boolean isCorrect;

}
