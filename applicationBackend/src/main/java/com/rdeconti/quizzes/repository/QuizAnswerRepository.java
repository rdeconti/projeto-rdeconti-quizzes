package com.rdeconti.quizzes.repository;

import com.rdeconti.quizzes.model.QuizAnswerModel;
import com.rdeconti.quizzes.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizAnswerRepository extends JpaRepository<QuizAnswerModel, Integer> {
}
