package com.inquizit.service;

import com.inquizit.model.domain.QuizAnswer;
import com.inquizit.model.domain.QuizQuestion;
import com.inquizit.model.entities.QuizQuestionEntity;
import com.inquizit.repository.QuizQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizQuestionServiceImpl implements QuizQuestionService {

    public final QuizQuestionRepository quizQuestionRepository;

    public final QuizAnswerService quizAnswerService;

    public QuizQuestionServiceImpl(QuizQuestionRepository quizQuestionRepository, QuizAnswerService quizAnswerService) {
        this.quizQuestionRepository = quizQuestionRepository;
        this.quizAnswerService = quizAnswerService;
    }

    @Override
    public List<QuizQuestion> getQuizQuestions(String quizId) {
        List<QuizQuestionEntity> questions = quizQuestionRepository.findAllByQuizId(quizId);
        List<QuizQuestion> domainQuestions = new ArrayList<>();

        for (QuizQuestionEntity question: questions) {
            List<QuizAnswer> answers = quizAnswerService.getQuestionAnswers(quizId, question.getQuesId().getQuesNumber());
            QuizQuestion domain = new QuizQuestion(question.getQuestion(), question.getQuesType(), answers);
            domainQuestions.add(domain);
        }

        return domainQuestions;
    }

    @Override
    public int getNumQuestionsInQuiz(String quizId) {
        List<QuizQuestionEntity> questions = quizQuestionRepository.findAllByQuizId(quizId);
        return questions.size();
    }

}
