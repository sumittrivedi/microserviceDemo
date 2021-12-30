package com.example.demo.models;

import lombok.Data;

@Data
public class UserResponseModel {
	private int userId;
	private String userName;
	private String email;
	private String phone;
	private String address;
}
