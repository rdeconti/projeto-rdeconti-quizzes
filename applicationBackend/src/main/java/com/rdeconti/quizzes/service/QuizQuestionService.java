package com.rdeconti.quizzes.service;

import com.rdeconti.quizzes.exception.InvalidInputException;
import com.rdeconti.quizzes.model.QuizQuestionModel;
import com.rdeconti.quizzes.repository.QuizQuestionRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizQuestionService {

	@Autowired
	private final QuizQuestionRepository quizQuestionRepository;

	public QuizQuestionService(QuizQuestionRepository quizQuestionRepository) {
		this.quizQuestionRepository = quizQuestionRepository;
	}

    /*
    FIELD       DESCRIPTION
    id	        The unique id to identify the quiz question.
    QuizService id  	The quiz id to identify the parent test/quiz.
    Type	    The type of question. The type can be a single choice(Yes/No), multiple-choice or select. We can also have type as input and textarea in case the quiz result need manual checks.
    Active	    Flag to identify whether the question is active. A quiz can have several questions, but only selective questions remain active at a time.
    Level	    The level of the question to identify whether it's easy, medium, or difficult.
    Score	    The score of an individual question. We should make sure that only selective questions are active at a time and the total score of the active questions is equal to the quiz score before publishing the quiz.
    Created At	It stores the date and time at which the question is created.
    Updated At	It stores the date and time at which the question is updated.
    Content	    The column used to store the question.
    */

	public QuizQuestionModel createQuizQuestion(@NotNull QuizQuestionModel quizQuestionModel ) {
		quizQuestionModel.setId(quizQuestionModel.getId());
		quizQuestionModel.setQuizId(quizQuestionModel.getQuizId());
		quizQuestionModel.setType(quizQuestionModel.getType());
		quizQuestionModel.setActive(quizQuestionModel.getActive());
		quizQuestionModel.setLevel(quizQuestionModel.getLevel());
		quizQuestionModel.setScore(quizQuestionModel.getScore());
		quizQuestionModel.setCreatedAt(quizQuestionModel.getCreatedAt());
		quizQuestionModel.setUpdatedAt(quizQuestionModel.getUpdatedAt());
		quizQuestionModel.setContent(quizQuestionModel.getContent());
		return this.quizQuestionRepository.save( quizQuestionModel );
	}

	public List<QuizQuestionModel> findAllQuizQuestions( ) {
		return (List<QuizQuestionModel>) quizQuestionRepository.findAll( );
	}

	public QuizQuestionModel getQuizQuestionById(Integer id ) {
		return quizQuestionRepository.findById( id )
						 .orElseThrow();
	}

	public void deleteQuizQuestion( Integer id ) {
		quizQuestionRepository.deleteById( id );
	}

	public QuizQuestionModel updateQuizQuestion(@NotNull QuizQuestionModel quizQuestionModel) {
		if ( quizQuestionModel.getId( ) == null ) {
			throw new InvalidInputException( "QuizQuestion not found with ID" );
		}
		return quizQuestionRepository.save(quizQuestionModel);
	}

}
