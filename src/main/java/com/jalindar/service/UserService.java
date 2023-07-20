package com.jalindar.service;

import com.jalindar.model.UserDtls;

public interface UserService {
public UserDtls createuser(UserDtls user);
public boolean checkEmail(String email);
}
