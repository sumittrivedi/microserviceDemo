package com.example.demo.services;

import java.util.List;

import com.example.demo.models.UserRequestModel;
import com.example.demo.models.UserResponseModel;

public interface UserService {
	List<UserResponseModel> getAllUsers();

	UserResponseModel getUserDetails(int userId);

	UserResponseModel createUser(UserRequestModel userRequestModel);

	void deleteUser(int userId);

	UserResponseModel updateUser(int user_id, UserRequestModel userRequestModel);
}
