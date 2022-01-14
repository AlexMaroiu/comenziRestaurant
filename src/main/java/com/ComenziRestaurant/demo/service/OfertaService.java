package com.ComenziRestaurant.demo.service;

import com.ComenziRestaurant.demo.entity.Mancare;
import com.ComenziRestaurant.demo.entity.Oferta;
import com.ComenziRestaurant.demo.repository.OferteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class OfertaService {
    @Autowired
    OferteRepository oferteRepository;

    public List<Oferta> getOferte(){
        return oferteRepository.findAll();
    }

    public Oferta gasesteOferta(Mancare mancare){
        var gasit = oferteRepository.gasesteIdMancare(mancare, LocalDate.now());
        Oferta oferta = null;
        if(gasit.isPresent()){
            oferta = gasit.get();
        }
        return oferta;
    }

    public boolean esteInOferta(Mancare mancare){
        var gasit = oferteRepository.gasesteIdMancare(mancare, LocalDate.now());
        return gasit.isPresent();
    }

    public List<Oferta> gasesteOfertaData(LocalDate data){
        return oferteRepository.gasesteOfertaData(data);
    }

    public void save(Oferta oferta){
        oferteRepository.save(oferta);
    }
}
