package com.inquizit.model.output;

import com.inquizit.model.domain.QuizQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponse {

    private String name;
    private List<QuizQuestion> questions;
    private int passingScore;
    private String msgSuccess;
    private String msgFail;
    private boolean showCorrect;

}
