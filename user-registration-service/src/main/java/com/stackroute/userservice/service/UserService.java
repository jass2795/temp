package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;

import com.stackroute.userservice.exceptions.UserAlreadyExistException;
import com.stackroute.userservice.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {

     User saveUser(User user) throws  UserAlreadyExistException;
     List<User> getAllUsers();
     User updateUser(User user) throws UserNotFoundException;
     User deleteUser(Long id) throws UserNotFoundException;

}
