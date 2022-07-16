package com.inquizit.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {

    private String id;
    private String name;
    private String description;
    private int passingScore;
    private boolean showCorrect;
    private String msgSuccess;
    private String msgFailure;

    private List<QuizQuestion> questions;

}
