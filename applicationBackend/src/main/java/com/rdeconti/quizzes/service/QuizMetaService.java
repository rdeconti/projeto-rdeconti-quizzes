package com.rdeconti.quizzes.service;

import com.rdeconti.quizzes.exception.InvalidInputException;
import com.rdeconti.quizzes.model.QuizMetaModel;
import com.rdeconti.quizzes.repository.QuizMetaRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizMetaService {

	@Autowired
	private final QuizMetaRepository quizMetaRepository;

	public QuizMetaService(QuizMetaRepository quizMetaRepository) {
		this.quizMetaRepository = quizMetaRepository;
	}

    /*
    FIELD       DESCRIPTION
    id	        The unique id to identify the quiz meta.
    QuizService id	    The quiz id to identify the parent test/quiz.
    Key	        The key identifying the meta.
    Content	    The column used to store the quiz metadata.
    */

	public QuizMetaModel createQuizMeta(@NotNull QuizMetaModel quizMetaModel ) {
		quizMetaModel.setId(quizMetaModel.getId());
		quizMetaModel.setQuizId(quizMetaModel.getQuizId());
		quizMetaModel.setKey(quizMetaModel.getKey());
		quizMetaModel.setContent(quizMetaModel.getContent());
		return this.quizMetaRepository.save( quizMetaModel );
	}

	public List<QuizMetaModel> findAllQuizMetas( ) {
		return (List<QuizMetaModel>) quizMetaRepository.findAll( );
	}

	public QuizMetaModel getQuizMetaById(Integer id ) {
		return quizMetaRepository.findById( id )
						 .orElseThrow();
	}

	public void deleteQuizMeta( Integer id ) {
		quizMetaRepository.deleteById( id );
	}

	public QuizMetaModel updateQuizMeta(@NotNull QuizMetaModel quizMetaModel) {
		if ( quizMetaModel.getId( ) == null ) {
			throw new InvalidInputException( "QuizMeta not found with ID" );
		}
		return quizMetaRepository.save(quizMetaModel);
	}

}
