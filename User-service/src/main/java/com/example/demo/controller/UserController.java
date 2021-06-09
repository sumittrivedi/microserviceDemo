package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UserRequestModel;
import com.example.demo.models.UserResponseModel;
import com.example.demo.models.UserUpdateRequestModel;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserResponseModel>> getAllUsers() {
		List<UserResponseModel> userModels = userService.getAllUsers();
		return new ResponseEntity<List<UserResponseModel>>(userModels, HttpStatus.OK);
	}

	@GetMapping(value = "{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponseModel> getUserByUserId(@PathVariable int user_id) {
		UserResponseModel userModel = userService.getUserDetails(user_id);
		return new ResponseEntity<UserResponseModel>(userModel, HttpStatus.OK);
	}

	@PostMapping(value = "")
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel) {
		UserResponseModel userResponseModel = userService.createUser(userRequestModel);
		return new ResponseEntity<UserResponseModel>(userResponseModel, HttpStatus.OK);
	}

	@DeleteMapping(value = "{user_id}")
	public void removeUser(@PathVariable int user_id) {
		userService.deleteUser(user_id);
	}
	
	@PutMapping(value = "{user_id}")
	public ResponseEntity<UserResponseModel> updateUser(@PathVariable int user_id, @RequestBody UserUpdateRequestModel userUpdateRequestModel) {
		UserResponseModel userResponseModel = userService.updateUser(user_id, userUpdateRequestModel);
		return new ResponseEntity<UserResponseModel>(userResponseModel, HttpStatus.OK);
	} 
}
