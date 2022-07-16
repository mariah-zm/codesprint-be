package com.inquizit.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizInfoInput {

    private String name;
    private String slug;
    private String description;
    private int passingScore;
    private boolean showCorrect;
    private String msgSuccess;
    private String msgFailure;

}
