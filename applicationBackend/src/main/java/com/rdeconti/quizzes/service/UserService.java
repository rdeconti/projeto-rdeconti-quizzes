package com.rdeconti.quizzes.service;

import com.rdeconti.quizzes.exception.InvalidInputException;
import com.rdeconti.quizzes.model.UserModel;
import com.rdeconti.quizzes.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/*
	FIELD           DESCRIPTION
	id	            The unique id to identify the user.
	First Name	    The first name of the user.
	Middle Name	    The middle name of the user.
	Last Name	    The last name of the user.
	Mobile	        The mobile number of the user. It can be used for login and registration purposes.
	Email	        The email of the user. It can be used for login and registration purposes.
	Password        The password hash generated by the appropriate algorithm (Hash). We must avoid storing plain passwords.
	Host	        The flag to identify whether the user can host a quiz.
	Registered At	This column can be used to calculate the life of the user with the application.
	Last Login	    It can be used to identify the last login of the user.
	Intro	        The brief introduction of the Host User to be displayed on the Test or QuizService Page.
	Profile	        The owner details to be displayed on the Test or QuizService Page.
	*/

	public UserModel createUser(@NotNull UserModel userModel ) {
		userModel.setId(userModel.getId());
		userModel.setFirstName(userModel.getFirstName());
		userModel.setMiddleName(userModel.getMiddleName());
		userModel.setLastName(userModel.getLastName());
		userModel.setMobile(userModel.getMobile());
		userModel.setEmail(userModel.getEmail());
		userModel.setPassword(userModel.getPassword());
		userModel.setHost(userModel.getHost());
		userModel.setRegisteredAt(userModel.getRegisteredAt());
		userModel.setLastLogin(userModel.getLastLogin());
		userModel.setIntro(userModel.getIntro());
		userModel.setProfile(userModel.getProfile());
		return this.userRepository.save( userModel );
	}

	public List<UserModel> findAllUsers( ) {
		return (List<UserModel>) userRepository.findAll( );
	}

	public UserModel getUserById(Integer id ) {
		return userRepository.findById( id )
						 .orElseThrow();
	}

	public void deleteUser( Integer id ) {
		userRepository.deleteById( id );
	}

	public UserModel updateUser(@NotNull UserModel userModel) {
		if ( userModel.getId( ) == null ) {
			throw new InvalidInputException( "User not found with ID" );
		}
		return userRepository.save(userModel);
	}

}
