package com.inquizit.controller;

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
    public @ResponseBody QuizResponse getQuiz(@PathVariable String quizId) {
        return quizService.getQuiz(quizId);
    }

    @GetMapping("")
    public @ResponseBody List<QuizInfoResponse> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @PostMapping("/{userId}/new/")
    public @ResponseBody void addNewQuiz(@RequestBody QuizInput quizInput, @PathVariable String userId) {
        quizService.addNewQuiz(userId, quizInput);
    }

}
