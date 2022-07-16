package com.inquizit.repository;

import com.inquizit.model.entities.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepository extends JpaRepository<QuizEntity, String> {

    @Query("SELECT q.id FROM QuizEntity q")
    List<String> getAllIds();

}
