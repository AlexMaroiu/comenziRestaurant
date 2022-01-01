package com.ComenziRestaurant.demo.service;

import com.ComenziRestaurant.demo.entity.Comanda;
import com.ComenziRestaurant.demo.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComandaService {

    @Autowired
    ComandaRepository comandaRepository;

    public List<Comanda> getComanda(){
        return comandaRepository.findAll();
    }

    public void saveComanda(Comanda comanda){
        comandaRepository.save(comanda);
    }
}
