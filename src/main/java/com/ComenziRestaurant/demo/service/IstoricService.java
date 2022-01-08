package com.ComenziRestaurant.demo.service;

import com.ComenziRestaurant.demo.entity.Istoric;
import com.ComenziRestaurant.demo.entity.User;
import com.ComenziRestaurant.demo.repository.IstoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IstoricService {

    @Autowired
    IstoricRepository istoricRepository;

    public List<Istoric> getIstoric(){
        return istoricRepository.findAll();
    }

    public List<Istoric> getIstoricByUser(User user){
        return istoricRepository.getIstoricByUser(user);
    }
}
