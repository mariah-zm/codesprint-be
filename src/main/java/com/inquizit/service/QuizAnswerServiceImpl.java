package com.inquizit.service;

import com.inquizit.converter.EntityToDomain;
import com.inquizit.model.domain.QuizAnswer;
import com.inquizit.model.entities.QuizAnswerEntity;
import com.inquizit.repository.QuizAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizAnswerServiceImpl implements QuizAnswerService {

    public final QuizAnswerRepository quizAnswerRepository;

    public QuizAnswerServiceImpl(QuizAnswerRepository quizAnswerRepository) {
        this.quizAnswerRepository = quizAnswerRepository;
    }

    @Override
    public List<QuizAnswer> getQuestionAnswers(String quizId, Integer quesNum) {
        List<QuizAnswerEntity> answers = quizAnswerRepository.findAllByQuizIdAndQuesNumber(quizId, quesNum);
        List<QuizAnswer> domainAnswers = new ArrayList<>();

        for (QuizAnswerEntity answer: answers) {
            QuizAnswer domainAnswer = EntityToDomain.convert(answer);
            domainAnswers.add(domainAnswer);
        }

        return domainAnswers;
    }

    @Override
    public void addAnswers(String quizId, int quesNum, List<QuizAnswer> answers) {
        for (int idx = 0; idx < answers.size(); ++idx) {
            QuizAnswer answer = answers.get(idx);

            QuizAnswerEntity entity = new QuizAnswerEntity();
            entity.getAnswerId().setQuizId(quizId);
            entity.getAnswerId().setQuesNumber(quesNum);
            entity.getAnswerId().setAnsNumber(idx);
            entity.setAnswer(answer.getAnswer());
            entity.setScore(answer.getScore());
            entity.setIsCorrect(answer.isCorrect());

            quizAnswerRepository.save(entity);
        }
    }

}
