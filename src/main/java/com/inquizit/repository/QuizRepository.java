package com.inquizit.repository;

import com.inquizit.model.entities.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<String, QuizEntity> {
}
