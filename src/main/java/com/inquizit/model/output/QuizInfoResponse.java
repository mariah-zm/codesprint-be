package com.inquizit.model.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizInfoResponse {

    private String name;
    private String slug;
    private String description;
    private int amountQuestions;

}
