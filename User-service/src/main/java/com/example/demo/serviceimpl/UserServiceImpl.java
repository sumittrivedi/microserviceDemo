package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.UserRequestModel;
import com.example.demo.models.UserResponseModel;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserResponseModel> getAllUsers() {
		List<UserEntity> usersEntityList = (List<UserEntity>) userRepository.findAll();
		List<UserResponseModel> userResponseModels = new ArrayList<>();
		if (usersEntityList.isEmpty() == false) {
			usersEntityList
					.forEach(userEntity -> userResponseModels.add(userMapper.convertToUserResponseModel(userEntity)));
		}
		return userResponseModels;
	}

	@Override
	public UserResponseModel getUserById(int userId) {
		UserEntity userEntity = userRepository.findById(userId).orElse(null);
		UserResponseModel userResponseModel = new UserResponseModel();
		if (userEntity != null) {
			userResponseModel = userMapper.convertToUserResponseModel(userEntity);
		}
		return userResponseModel;
	}

	@Override
	public UserResponseModel createUser(UserRequestModel userRequestModel) {
		UserEntity userEntity = new UserEntity();
		userMapper.convertToUserEntity(userRequestModel);
		userRepository.save(userEntity);
		return getUserById(userEntity.getUserId());
	}

	@Override
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public UserResponseModel updateUser(int userId, UserRequestModel userRequestModel) {
		UserEntity userEntity = userRepository.findById(userId).orElse(null);
		if (userEntity != null) {
			userEntity = userMapper.convertToUserEntity(userRequestModel);
			userRepository.save(userEntity);
		}
		return userMapper.convertToUserResponseModel(userEntity);
	}

}
