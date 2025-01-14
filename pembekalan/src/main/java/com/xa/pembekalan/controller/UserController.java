package com.xa.pembekalan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xa.pembekalan.dto.request.UserRequestDto;
import com.xa.pembekalan.dto.response.UserResponseDto;
import com.xa.pembekalan.entity.User;
import com.xa.pembekalan.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public ModelAndView getAllUsers() {
        ModelAndView view = new ModelAndView("user/index");
        List<UserResponseDto> userResponseDtos = userService.getAllUsers();
        // List<UserRequestDto> userRequestDtos = new ArrayList<>();
        // for (User user : users) {
        // UserRequestDto userRequestDto = new UserRequestDto();
        // userRequestDto.setName(user.getName());
        // userRequestDto.setPhoneNumber(user.getPhoneNumber());
        // userRequestDto.setAddress(user.getAddress());
        // userRequestDtos.add(userRequestDto);
        // }
        String title = "User Page";
        view.addObject("users", userResponseDtos);
        view.addObject("title", title);
        return view;
    }

    @GetMapping("/form")
    public ModelAndView userForm() {
        ModelAndView view = new ModelAndView("user/form");
        UserResponseDto userResponseDto = new UserResponseDto();
        view.addObject("user", userResponseDto);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView saveUser(@ModelAttribute UserRequestDto userRequestDto, BindingResult result) {
        if (!result.hasErrors()) {
            userService.saveUser(userRequestDto);
        }
        return new ModelAndView("redirect:/user");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editUser(@PathVariable Integer id) {
        ModelAndView view = new ModelAndView("user/form");
        UserResponseDto userResponseDto = userService.getUserById(id);
        view.addObject("user", userResponseDto);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return new ModelAndView("redirect:/user");
    }
}
