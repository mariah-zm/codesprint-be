package com.inquizit.service;

import com.inquizit.exceptions.QuizNotFoundException;
import com.inquizit.model.domain.Quiz;
import com.inquizit.model.domain.QuizInfo;
import com.inquizit.model.domain.QuizQuestion;
import com.inquizit.model.entities.QuizEntity;
import com.inquizit.model.input.QuizInput;
import com.inquizit.repository.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class QuizServiceImpl implements QuizService {

    public final QuizRepository quizRepository;

    public final QuizQuestionService quizQuestionService;

    public QuizServiceImpl(QuizRepository quizRepository, QuizQuestionService quizQuestionService) {
        this.quizRepository = quizRepository;
        this.quizQuestionService = quizQuestionService;
    }

    @Override
    public Quiz getQuiz(String id) throws QuizNotFoundException {
        Optional<QuizEntity> optional = this.quizRepository.findById(id);

        if (optional.isPresent()) {
            QuizEntity quizEntity = optional.get();
            List<QuizQuestion> quizQuestions = quizQuestionService.getQuizQuestions(id);

            return new Quiz(
                    quizEntity.getId(),
                    quizEntity.getName(),
                    quizEntity.getDescription(),
                    quizEntity.getPassingScore(),
                    quizEntity.getShowCorrect(),
                    quizEntity.getMsgSuccess(),
                    quizEntity.getMsgFailure(),
                    quizQuestions
            );
        }

        log.error("The quiz with Id {} does not exist", id);
        throw new QuizNotFoundException();
    }

    @Override
    public List<QuizInfo> getAllQuizzes() {
        List<String> quizIds = quizRepository.getAllIds();
        List<QuizInfo> infoList = new ArrayList<>();

        for (String id: quizIds) {
            try {
                QuizInfo info = this.getQuizInfo(id);
                infoList.add(info);
            } catch (QuizNotFoundException ex) {
                log.error("The quiz with Id {} does not exist", id);
            }
        }

        return infoList;
    }

    @Override
    public void addNewQuiz(String userId, QuizInput quiz) {

    }

    private QuizInfo getQuizInfo(String id) throws QuizNotFoundException {
        Optional<QuizEntity> optional = this.quizRepository.findById(id);

        if (optional.isPresent()) {
            QuizEntity quizEntity = optional.get();
            int numQues = this.quizQuestionService.getNumQuestionsInQuiz(id);

            return new QuizInfo(
                    quizEntity.getId(),
                    quizEntity.getName(),
                    quizEntity.getDescription(),
                    numQues
            );
        }
        throw new QuizNotFoundException();
    }

}
