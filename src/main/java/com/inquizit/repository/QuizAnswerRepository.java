package com.inquizit.repository;

import com.inquizit.model.entities.QuizAnswerEntity;
import com.inquizit.model.entities.QuizAnswerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizAnswerRepository extends JpaRepository<QuizAnswerEntity, QuizAnswerId> {

    @Query("SELECT a FROM QuizAnswerEntity a WHERE a.answerId.quizId = :quizId AND a.answerId.quesNumber = :quesNum")
    List<QuizAnswerEntity> findAllByQuizIdAndQuesNumber(String quizId, Integer quesNum);

}
