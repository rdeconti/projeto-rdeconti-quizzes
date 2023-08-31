package com.rdeconti.quizzes.service;

import com.rdeconti.quizzes.exception.InvalidInputException;
import com.rdeconti.quizzes.model.QuizModel;
import com.rdeconti.quizzes.repository.QuizRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

	@Autowired
	private final QuizRepository quizServiceRepository;

	public QuizService(QuizRepository quizServiceRepository) {
		this.quizServiceRepository = quizServiceRepository;
	}

    /*
    FIELD           DESCRIPTION
    id	            The unique id to identify the quiz.
    Host id	        The host id to identify the quiz host.
    Title	        The quiz title to be displayed on the QuizService Page and the lists.
    Meta Title	    The meta title to be used for browser title and SEO.
    Slug	        The slug to form the URL.
    Summary	        The summary to mention the key highlights.
    Type	        The type to distinguish between the test and the quiz.
    Score	        The total score of the quiz.
    Published	    It can be used to identify whether the test/quiz is publicly available.
    Created At	    It stores the date and time at which the test/quiz is created.
    Updated At	    It stores the date and time at which the test/quiz is updated.
    Published At	It stores the date and time at which the test/quiz is published.
    Starts At	    It stores the date and time at which the test/quiz starts and opens up for takes.
    Ends At	        It stores the date and time at which the test/quiz closes for takes.
    Content	        The column used to store the test/quiz data.
    */

	public QuizModel createQuiz(@NotNull QuizModel quizServiceModel ) {
		quizServiceModel.setId(quizServiceModel.getId());
		quizServiceModel.setHostId(quizServiceModel.getHostId());
		quizServiceModel.setMetaTitle(quizServiceModel.getMetaTitle());
		quizServiceModel.setSlug(quizServiceModel.getSlug());
		quizServiceModel.setSummary(quizServiceModel.getSummary());
		quizServiceModel.setType(quizServiceModel.getType());
		quizServiceModel.setScore(quizServiceModel.getScore());
		quizServiceModel.setPublished(quizServiceModel.getPublished());
		quizServiceModel.setCreatedAt(quizServiceModel.getCreatedAt());
		quizServiceModel.setUpdatedAt(quizServiceModel.getUpdatedAt());
		quizServiceModel.setPublishedAt(quizServiceModel.getPublishedAt());
		quizServiceModel.setStartsAt(quizServiceModel.getStartsAt());
		quizServiceModel.setEndsAt(quizServiceModel.getEndsAt());
		quizServiceModel.setContent(quizServiceModel.getContent());
		return this.quizServiceRepository.save( quizServiceModel );
	}

	public List<QuizModel> findAllQuizs( ) {
		return (List<QuizModel>) quizServiceRepository.findAll( );
	}

	public QuizModel getQuizById(Integer id ) {
		return quizServiceRepository.findById( id )
						 .orElseThrow();
	}

	public void deleteQuiz( Integer id ) {
		quizServiceRepository.deleteById( id );
	}

	public QuizModel updateQuiz(@NotNull QuizModel quizServiceModel) {
		if ( quizServiceModel.getId( ) == null ) {
			throw new InvalidInputException( "Quiz not found with ID" );
		}
		return quizServiceRepository.save(quizServiceModel);
	}

}
