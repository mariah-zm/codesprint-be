package com.inquizit.repository;

import com.inquizit.model.entities.QuizAnswerEntity;
import com.inquizit.model.entities.QuizAnswerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizAnswerRepository extends JpaRepository<QuizAnswerId, QuizAnswerEntity> {
}
