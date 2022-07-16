package com.inquizit.repository;

import com.inquizit.model.entities.QuizQuestionEntity;
import com.inquizit.model.entities.QuizQuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestionEntity, QuizQuestionId> {

    @Query("SELECT q FROM QuizQuestionEntity q WHERE q.quesId.quizId = :quizId")
    List<QuizQuestionEntity> findAllByQuizId(String quizId);

}
