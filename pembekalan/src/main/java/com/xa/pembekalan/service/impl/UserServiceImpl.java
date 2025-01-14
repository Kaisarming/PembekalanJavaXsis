package com.xa.pembekalan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.xa.pembekalan.dto.response.UserResponseDto;
import com.xa.pembekalan.entity.User;
import com.xa.pembekalan.repository.UserRepository;
import com.xa.pembekalan.service.UserService;

import com.xa.pembekalan.dto.request.UserRequestDto;

import org.modelmapper.ModelMapper;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    private ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> userResponseDtos = users.stream()
                .map(user -> modelMapper()
                        .map(user, UserResponseDto.class))
                .collect(Collectors.toList());
        return userResponseDtos;
    }

    @Override
    public UserResponseDto getUserById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        UserResponseDto userResponseDto = modelMapper().map(user, UserResponseDto.class);
        return userResponseDto;
    }

    @Override
    public User saveUser(UserRequestDto userRequestDto) {
        User user = modelMapper().map(userRequestDto, User.class);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

}
