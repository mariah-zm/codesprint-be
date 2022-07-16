package com.inquizit.repository;

import com.inquizit.model.entities.QuizQuestionEntity;
import com.inquizit.model.entities.QuizQuestionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestionEntity, QuizQuestionId> {
}
