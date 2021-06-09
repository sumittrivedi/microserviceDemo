package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;
import com.example.demo.models.UserRequestModel;
import com.example.demo.models.UserResponseModel;
import com.example.demo.models.UserUpdateRequestModel;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserResponseModel getUserDetails(int userId) {
		UserEntity userEntity = userRepository.findById(userId).orElse(null);
		UserResponseModel userResponseModel = new UserResponseModel();
		if (userEntity != null) {
			userResponseModel.setUserId(userEntity.getUserId());
			userResponseModel.setUserName(userEntity.getUserName());
			userResponseModel.setEmail(userEntity.getEmail());
			userResponseModel.setPhone(userEntity.getPhone());
			userResponseModel.setAddress(userEntity.getAddress());
		}
		return userResponseModel;
	}

	@Override
	public List<UserResponseModel> getAllUsers() {
		Iterable<UserEntity> usersEntityList = userRepository.findAll();
		List<UserResponseModel> userResponseModels = new ArrayList<>();
		if (usersEntityList != null) {
			for (UserEntity userEntity : usersEntityList) {
				UserResponseModel userResponseModel = new UserResponseModel();
				userResponseModel.setUserId(userEntity.getUserId());
				userResponseModel.setUserName(userEntity.getUserName());
				userResponseModel.setEmail(userEntity.getEmail());
				userResponseModel.setPhone(userEntity.getPhone());
				userResponseModel.setAddress(userEntity.getAddress());
				userResponseModels.add(userResponseModel);
			}
		}
		return userResponseModels;
	}

	@Override
	public UserResponseModel createUser(UserRequestModel userRequestModel) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userRequestModel.getUserId());
		userEntity.setUserName(userRequestModel.getUserName());
		userEntity.setEmail(userRequestModel.getEmail());
		userEntity.setAddress(userRequestModel.getAddress());
		userEntity.setPassword(userRequestModel.getPassword());
		userEntity.setPhone(userRequestModel.getPhone());
		userRepository.save(userEntity);
		return getUserDetails(userRequestModel.getUserId());
	}

	@Override
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public UserResponseModel updateUser(int user_id, UserUpdateRequestModel userUpdateRequestModel) {
		UserEntity userEntity = userRepository.findById(user_id).orElse(null);
		if (userEntity != null) {
			userEntity.setUserName(userUpdateRequestModel.getUserName());
			userEntity.setEmail(userUpdateRequestModel.getEmail());
			userEntity.setAddress(userUpdateRequestModel.getAddress());
			userEntity.setPassword(userUpdateRequestModel.getPassword());
			userEntity.setPhone(userUpdateRequestModel.getPhone());
			userRepository.save(userEntity);
		}
		return getUserDetails(user_id);
	}

}
