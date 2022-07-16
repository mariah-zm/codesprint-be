package com.inquizit.controller;

import com.inquizit.converter.DomainToOutput;
import com.inquizit.exceptions.QuizNotFoundException;
import com.inquizit.model.domain.Quiz;
import com.inquizit.model.domain.QuizInfo;
import com.inquizit.model.input.QuizInput;
import com.inquizit.model.output.QuizInfoResponse;
import com.inquizit.model.output.QuizResponse;
import com.inquizit.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/{quizId}")
    public @ResponseBody QuizResponse getQuiz(@PathVariable String quizId) throws QuizNotFoundException {
        Quiz quiz = quizService.getQuiz(quizId);
        return DomainToOutput.convert(quiz);
    }

    @GetMapping("")
    public @ResponseBody List<QuizInfoResponse> getAllQuizzes() {
        List<QuizInfo> infoList = this.quizService.getAllQuizzes();
        return DomainToOutput.convert(infoList);
    }

    @PostMapping("/{userId}/new/")
    public @ResponseBody void addNewQuiz(@RequestBody QuizInput quizInput, @PathVariable String userId) {
        quizService.addNewQuiz(userId, quizInput);
    }

}
