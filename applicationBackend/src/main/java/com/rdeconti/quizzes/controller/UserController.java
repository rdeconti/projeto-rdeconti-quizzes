package com.rdeconti.quizzes.controller;

import com.rdeconti.quizzes.model.UserModel;
import com.rdeconti.quizzes.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/user" )
@Api( value = "USERS API REST" )
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping( "/users/get" )
	@ApiOperation( "FIND ALL USERS" )
	public ResponseEntity< List<UserModel> > findAllUsers( ) {
		return new ResponseEntity<>( userService.findAllUsers( ), HttpStatus.OK );
	}

	@PostMapping( "/users/post" )
	@ApiOperation( "CREATE USER" )
	public ResponseEntity< UserModel > createUser( @RequestBody UserModel UserModel ) {
		return new ResponseEntity<>( userService.createUser( UserModel ), HttpStatus.CREATED );
	}

	@DeleteMapping( "/users/delete/{id}" )
	@ApiOperation( "DELETE USER" )
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable int id) {
		this.userService.deleteUser(id);
	}

	@GetMapping( "/users/get/{id}" )
	@ApiOperation( "FIND USER BY ID" )
	public ResponseEntity< UserModel > getUserById( @PathVariable( value = "id" ) Integer UserId ) {
		return new ResponseEntity<>( userService.getUserById( UserId ), HttpStatus.OK );
	}

	@PutMapping( "/users/put/{id}" )
	@ApiOperation( "UPDATE USER" )
	@ResponseStatus(value = HttpStatus.OK)
	public UserModel updateUser(@PathVariable int id, @RequestBody UserModel UserModel) {
		return this.userService.updateUser(UserModel);
	}

}
