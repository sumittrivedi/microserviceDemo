package com.example.demo.mapperimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.UserRequestModel;
import com.example.demo.models.UserResponseModel;

@Component
public class UserMapperImpl implements UserMapper {
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserResponseModel convertToUserResponseModel(UserEntity userEntity) {
		UserResponseModel userResponseModel = null;
		if (userEntity != null)
			userResponseModel = modelMapper.map(userEntity, UserResponseModel.class);
		return userResponseModel;
	}

	@Override
	public UserEntity convertToUserEntity(UserRequestModel userRequestModel) {
		UserEntity userEntity = null;
		if (userRequestModel != null)
			userEntity = modelMapper.map(userRequestModel, UserEntity.class);
		return userEntity;
	}

}
