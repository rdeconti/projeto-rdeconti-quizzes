package com.rdeconti.quizzes.repository;

import com.rdeconti.quizzes.model.QuizMetaModel;
import com.rdeconti.quizzes.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizMetaRepository extends JpaRepository<QuizMetaModel, Integer> {
}
