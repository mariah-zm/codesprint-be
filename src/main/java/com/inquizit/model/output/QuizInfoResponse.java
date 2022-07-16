package com.inquizit.model.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizInfoResponse {

    private String name;
    private String slug;
    private String description;
    private int amountQuestions;

}
