package com.ComenziRestaurant.demo.service;

import com.ComenziRestaurant.demo.entity.Mancare;
import com.ComenziRestaurant.demo.repository.MancareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MancareSercive {

    @Autowired
    MancareRepository rep;

    public List<Mancare> getMancare(){
        return rep.findAll();
    }

    public  Mancare getMancareById(Integer id){
        var mancare =  rep.findById(id);
        return mancare.get();
    }
}
