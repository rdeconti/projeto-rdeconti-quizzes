package com.rdeconti.quizzes.service;

import com.rdeconti.quizzes.exception.InvalidInputException;
import com.rdeconti.quizzes.model.TakeModel;
import com.rdeconti.quizzes.repository.TakeRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakeService {

	@Autowired
	private final TakeRepository takeRepository;

	public TakeService(TakeRepository takeRepository) {
		this.takeRepository = takeRepository;
	}

    /*
    FIELD       DESCRIPTION
    id	        The unique id to identify the take.
    User id	    The user id to identify the quiz taker.
    Quiz id	    The quiz id to identify the quiz.
    Status	    The status of the take. It can be enrolled, started, paused, finished, declared.
    Score	    The total score obtained by the user.
    Created At	It stores the date and time at which the take is created.
    Updated At	It stores the date and time at which the take is updated.
    Started At	It stores the date and time at which the take started.
    Finished At	It stores the date and time at which the take is finished.
    Content	    The column used to store the take remarks.
    */

	public TakeModel createTake(@NotNull TakeModel takeModel ) {
		takeModel.setId(takeModel.getId());
		takeModel.setUserId(takeModel.getUserId());
		takeModel.setQuizId(takeModel.getQuizId());
		takeModel.setStatus(takeModel.getStatus());
		takeModel.setScore(takeModel.getScore());
		takeModel.setCreatedAt(takeModel.getCreatedAt());
		takeModel.setUpdatedAt(takeModel.getUpdatedAt());
		takeModel.setStartedAt(takeModel.getStartedAt());
		takeModel.setFinishedAt(takeModel.getFinishedAt());
		takeModel.setContent(takeModel.getContent());
		return this.takeRepository.save( takeModel );
	}

	public List<TakeModel> findAllTakes( ) {
		return (List<TakeModel>) takeRepository.findAll( );
	}

	public TakeModel getTakeById(Integer id ) {
		return takeRepository.findById( id )
						 .orElseThrow();
	}

	public void deleteTake( Integer id ) {
		takeRepository.deleteById( id );
	}

	public TakeModel updateTake(@NotNull TakeModel takeModel) {
		if ( takeModel.getId( ) == null ) {
			throw new InvalidInputException( "Take not found with ID" );
		}
		return takeRepository.save(takeModel);
	}

}
