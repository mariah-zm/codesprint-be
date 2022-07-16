package com.inquizit.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizInfo {

    private String id;
    private String name;
    private String description;
    private int amountQuestions;

}
