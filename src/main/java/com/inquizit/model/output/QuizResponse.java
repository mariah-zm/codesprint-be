package com.inquizit.model.output;

import com.inquizit.model.domain.QuizQuestion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuizResponse {

    private String name;
    private List<QuizQuestion> questions;
    private int passingScore;
    private String msgSuccess;
    private String msgFail;
    private boolean showCorrect;

}
