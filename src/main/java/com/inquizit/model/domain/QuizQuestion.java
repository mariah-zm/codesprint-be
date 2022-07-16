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
public class QuizQuestion {

    private String question;
    private int type;
    private List<QuizAnswer> answers;

}
