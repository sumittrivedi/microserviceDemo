package com.example.demo.services;

import java.util.List;

import com.example.demo.models.UserRequestModel;
import com.example.demo.models.UserResponseModel;

public interface UserService {
	List<UserResponseModel> getAllUsers();

	UserResponseModel getUserById(int userId);

	UserResponseModel createUser(UserRequestModel userRequestModel);

	void deleteUser(int userId);

	UserResponseModel updateUser(int userId, UserRequestModel userRequestModel);
}
