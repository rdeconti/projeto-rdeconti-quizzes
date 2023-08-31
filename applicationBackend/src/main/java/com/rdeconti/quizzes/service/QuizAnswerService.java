package com.rdeconti.quizzes.service;

import com.rdeconti.quizzes.exception.InvalidInputException;
import com.rdeconti.quizzes.model.QuizAnswerModel;
import com.rdeconti.quizzes.repository.QuizAnswerRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizAnswerService {

	@Autowired
	private final QuizAnswerRepository quizAnswerRepository;

	public QuizAnswerService(QuizAnswerRepository quizAnswerRepository) {
		this.quizAnswerRepository = quizAnswerRepository;
	}

    /*
    FIELD       DESCRIPTION
    id	        The unique id to identify the quiz answer.
    QuizService id	    The quiz id to identify the parent test/quiz.
    Question id	The question id to identify the parent question.
    Active	    Flag to identify whether the answer is active.
    Correct	    Flag to identify whether the answer is correct.
    Created At	It stores the date and time at which the answer is created.
    Updated At	It stores the date and time at which the answer is updated.
    Content	    The column used to store the answer.
    */

	public QuizAnswerModel createQuizAnswer(@NotNull QuizAnswerModel quizAnswerModel ) {
		quizAnswerModel.setId(quizAnswerModel.getId());
		quizAnswerModel.setQuizId(quizAnswerModel.getQuizId());
		quizAnswerModel.setQuestionId(quizAnswerModel.getQuestionId());
		quizAnswerModel.setActive(quizAnswerModel.getActive());
		quizAnswerModel.setCorrect(quizAnswerModel.getCorrect());
		quizAnswerModel.setCreatedAt(quizAnswerModel.getCreatedAt());
		quizAnswerModel.setUpdatedAt(quizAnswerModel.getUpdatedAt());
		quizAnswerModel.setContent(quizAnswerModel.getContent());
		return this.quizAnswerRepository.save( quizAnswerModel );
	}

	public List<QuizAnswerModel> findAllQuizAnswers( ) {
		return (List<QuizAnswerModel>) quizAnswerRepository.findAll( );
	}

	public QuizAnswerModel getQuizAnswerById(Integer id ) {
		return quizAnswerRepository.findById( id )
						 .orElseThrow();
	}

	public void deleteQuizAnswer( Integer id ) {
		quizAnswerRepository.deleteById( id );
	}

	public QuizAnswerModel updateQuizAnswer(@NotNull QuizAnswerModel quizAnswerModel) {
		if ( quizAnswerModel.getId( ) == null ) {
			throw new InvalidInputException( "QuizAnswer not found with ID" );
		}
		return quizAnswerRepository.save(quizAnswerModel);
	}

}
