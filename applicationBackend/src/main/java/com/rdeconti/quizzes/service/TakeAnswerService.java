package com.rdeconti.quizzes.service;

import com.rdeconti.quizzes.exception.InvalidInputException;
import com.rdeconti.quizzes.model.TakeAnswerModel;
import com.rdeconti.quizzes.repository.TakeAnswerRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakeAnswerService {

	@Autowired
	private final TakeAnswerRepository takeAnswerRepository;

	public TakeAnswerService(TakeAnswerRepository takeAnswerRepository) {
		this.takeAnswerRepository = takeAnswerRepository;
	}

    /*
    FIELD       DESCRIPTION
    id	        The unique id to identify the take answer.
    Take id	    The take id to identify the quiz attempt.
    Answer id	The answer id to identify the quiz answer.
    Active	    Flag to identify whether the answer is active.
    Created At	It stores the date and time at which the answer is created.
    Updated At	It stores the date and time at which the answer is updated.
    Content	    The column used to store the answer in case of input or textarea type of questions.
    */

	public TakeAnswerModel createTakeAnswer(@NotNull TakeAnswerModel takeAnswerModel ) {
		takeAnswerModel.setId(takeAnswerModel.getId());
		takeAnswerModel.setTakeId(takeAnswerModel.getTakeId());
		takeAnswerModel.setAnswerId(takeAnswerModel.getAnswerId());
		takeAnswerModel.setActive(takeAnswerModel.getActive());
		takeAnswerModel.setCreatedAt(takeAnswerModel.getCreatedAt());
		takeAnswerModel.setUpdatedAt(takeAnswerModel.getUpdatedAt());
		takeAnswerModel.setContent(takeAnswerModel.getContent());
		return this.takeAnswerRepository.save( takeAnswerModel );
	}

	public List<TakeAnswerModel> findAllTakeAnswers( ) {
		return (List<TakeAnswerModel>) takeAnswerRepository.findAll( );
	}

	public TakeAnswerModel getTakeAnswerById(Integer id ) {
		return takeAnswerRepository.findById( id )
						 .orElseThrow();
	}

	public void deleteTakeAnswer( Integer id ) {
		takeAnswerRepository.deleteById( id );
	}

	public TakeAnswerModel updateTakeAnswer(@NotNull TakeAnswerModel takeAnswerModel) {
		if ( takeAnswerModel.getId( ) == null ) {
			throw new InvalidInputException( "TakeAnswer not found with ID" );
		}
		return takeAnswerRepository.save(takeAnswerModel);
	}

}
