package com.ComenziRestaurant.demo.service;

import com.ComenziRestaurant.demo.entity.Authorities;
import com.ComenziRestaurant.demo.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthotitiesService {

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    public List<Authorities> getAuthorities(){
        return authoritiesRepository.findAll();
    }

    public void saveAuthorities(Authorities authorities){
        authoritiesRepository.save(authorities);
    }

}
