package com.example.demo.mapper;

import com.example.demo.Entity.UserEntity;
import com.example.demo.models.UserRequestModel;
import com.example.demo.models.UserResponseModel;

public interface UserMapper {
	UserResponseModel convertToUserResponseModel(UserEntity userEntity);
	UserEntity convertToUserEntity(UserRequestModel userRequestModel);
}
