package com.inquizit.service;

import com.inquizit.model.common.QuizAnswer;
import com.inquizit.model.common.QuizQuestion;
import com.inquizit.model.enums.QuestionType;
import com.inquizit.model.input.QuizInput;
import com.inquizit.model.output.QuizInfoResponse;
import com.inquizit.model.output.QuizResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Override
    public QuizResponse getQuiz(String id) {
        QuizAnswer ans11 = new QuizAnswer("2", 1,true);
        QuizAnswer ans12 = new QuizAnswer("1", 0,false);
        QuizQuestion ques1 = new QuizQuestion(
                "What is 1 + 1?",
                QuestionType.SINGLE_ANSWER.getValue(),
                List.of(ans11, ans12));

        QuizAnswer ans21 = new QuizAnswer("2", 1,true);
        QuizAnswer ans22 = new QuizAnswer("1", 0,false);
        QuizAnswer ans23 = new QuizAnswer("4", 1,true);
        QuizQuestion ques2 = new QuizQuestion(
                "Which of these numbers are even?",
                QuestionType.MULTIPLE_ANSWERS.getValue(),
                List.of(ans21, ans22, ans23));

        QuizAnswer ans31 = new QuizAnswer("True", 1,true);
        QuizAnswer ans32 = new QuizAnswer("False", 0,false);
        QuizQuestion ques3 = new QuizQuestion(
                "A triangle has 3 sides.",
                QuestionType.TRUE_FALSE.getValue(),
                List.of(ans31, ans32));


        QuizResponse quiz = new QuizResponse();
        quiz.setName("Maths Quiz");
        quiz.setPassingScore(3);
        quiz.setShowCorrect(true);
        quiz.setMsgFail("Oh no! You did not pass.");
        quiz.setMsgSuccess("Yay! You passed the quiz.");
        quiz.setQuestions(List.of(ques1, ques2, ques3));

        return quiz;
    }

    @Override
    public List<QuizInfoResponse> getAllQuizzes() {
        QuizInfoResponse quiz1 = new QuizInfoResponse(
                "Maths Quiz",
                "math",
                "Quiz about numbers",
                5
        );

        QuizInfoResponse quiz2 = new QuizInfoResponse(
                "Space Quiz",
                "space",
                "Quiz about planets",
                6
        );

        return List.of(quiz1, quiz2);
    }

    @Override
    public void addNewQuiz(QuizInput quiz) {

    }

}
