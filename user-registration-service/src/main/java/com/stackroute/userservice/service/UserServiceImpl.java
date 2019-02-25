package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;


import com.stackroute.userservice.exceptions.UserAlreadyExistException;
import com.stackroute.userservice.exceptions.UserNotFoundException;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    User user;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistException {
        if (userRepository.existsById(user.getUserId())) {
            throw new UserAlreadyExistException("user already exists");
        }
        User savedUser = userRepository.save(user);
        if (savedUser == null) {
            throw new UserAlreadyExistException("User already exists");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {

        //if(userRepository.existsById(user.getUserId()))

        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        if (userRepository.existsById(user.getUserId())) {
            User savedUser = userRepository.save(user);
            return savedUser;
            //throw new UserNotFoundException("user already exists");
        } else
            throw new UserNotFoundException("user not found");


    }


    @Override
    public User deleteUser(Long id) throws UserNotFoundException {

        if(this.userRepository.existsById(user.getUserId())) {
            this.userRepository.delete(user);
            return user;
        }
        else
            throw new UserNotFoundException("user not found");

    }
}