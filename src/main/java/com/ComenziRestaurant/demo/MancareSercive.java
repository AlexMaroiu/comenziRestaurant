package com.ComenziRestaurant.demo;

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
}
