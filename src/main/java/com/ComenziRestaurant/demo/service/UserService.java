package com.ComenziRestaurant.demo.service;

import com.ComenziRestaurant.demo.entity.User;
import com.ComenziRestaurant.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
}
