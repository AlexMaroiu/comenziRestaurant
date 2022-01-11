package com.ComenziRestaurant.demo.service;

import com.ComenziRestaurant.demo.entity.Comanda;
import com.ComenziRestaurant.demo.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ComandaService {

    @Autowired
    ComandaRepository comandaRepository;

    public List<Comanda> gasesteDupaUser(String username){
        return comandaRepository.gasesteDupaUser(username);
    }

    public List<Comanda> gasesteGrupat(String username){
        return comandaRepository.gasesteDupaUserGrupat(username);
    }

    public List<Comanda> getComanda(){
        return comandaRepository.findAll();
    }

    public void saveComanda(Comanda comanda){
        comandaRepository.save(comanda);
    }

    @Transactional
    public void golireCos(String user){
        comandaRepository.updateComanda(user);
    }
}
