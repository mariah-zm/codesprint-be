package com.inquizit.service;

import com.inquizit.model.input.QuizInput;
import com.inquizit.model.output.QuizInfoResponse;
import com.inquizit.model.output.QuizResponse;

import java.util.List;

public interface QuizService {

    QuizResponse getQuiz(String id);

    List<QuizInfoResponse> getAllQuizzes();

    void addNewQuiz(String userId, QuizInput quiz);

}
