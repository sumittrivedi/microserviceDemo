package com.example.demo.models;

import lombok.Data;

@Data
public class UserUpdateRequestModel {
	private String password;
	private String userName;
	private String email;
	private String phone;
	private String address;
}
