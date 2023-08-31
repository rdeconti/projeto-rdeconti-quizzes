package com.rdeconti.quizzes.repository;

import com.rdeconti.quizzes.model.TakeAnswerModel;
import com.rdeconti.quizzes.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakeAnswerRepository extends JpaRepository<TakeAnswerModel, Integer> {
}
