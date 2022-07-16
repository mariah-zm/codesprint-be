package com.inquizit.service;

import com.inquizit.model.domain.QuizAnswer;

import java.util.List;

public interface QuizAnswerService {

    List<QuizAnswer> getQuestionAnswers(String quizId, Integer quesNum);

}
