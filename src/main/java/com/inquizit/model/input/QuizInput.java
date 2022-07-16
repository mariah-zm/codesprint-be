package com.inquizit.model.input;

import com.inquizit.model.domain.QuizQuestion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuizInput {

    private QuizInfoInput info;
    private List<QuizQuestion> questions;

}
