package com.inquizit.service;

import com.inquizit.model.domain.QuizQuestion;

import java.util.List;

public interface QuizQuestionService {

    List<QuizQuestion> getQuizQuestions(String quizId);

    int getNumQuestionsInQuiz(String quizId);

}
