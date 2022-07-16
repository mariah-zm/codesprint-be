package com.inquizit.service;

import com.inquizit.exceptions.QuizNotFoundException;
import com.inquizit.model.domain.Quiz;
import com.inquizit.model.domain.QuizInfo;
import com.inquizit.model.input.QuizInput;

import java.util.List;

public interface QuizService {

    Quiz getQuiz(String id) throws QuizNotFoundException;

    List<QuizInfo> getAllQuizzes();

    void addNewQuiz(QuizInput quiz);

    boolean doesIdExist(String name);
}
