package com.rdeconti.quizzes.repository;

import com.rdeconti.quizzes.model.TakeModel;
import com.rdeconti.quizzes.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakeRepository extends JpaRepository<TakeModel, Integer> {
}
