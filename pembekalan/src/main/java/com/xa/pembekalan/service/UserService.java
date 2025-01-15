package com.xa.pembekalan.service;

import java.util.List;

import com.xa.pembekalan.dto.response.UserResponseDto;
import com.xa.pembekalan.dto.request.UserRequestDto;
import com.xa.pembekalan.entity.User;

public interface UserService {

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(Integer id);

    User saveUser(UserRequestDto user);

    void deleteUserById(Integer id);
}
