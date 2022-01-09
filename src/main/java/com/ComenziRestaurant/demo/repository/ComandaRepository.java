package com.ComenziRestaurant.demo.repository;

import com.ComenziRestaurant.demo.entity.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Integer> {

    @Query("select c from Comanda c where username=?1")
    public List<Comanda> gasesteDupaUser(String username);

    @Query(value = "select id, sum(portii) as portii, username, id_mancare, sum(pret) as pret  from Comanda where username=?1 group by  id_mancare",
    nativeQuery = true)
    public List<Comanda> gasesteDupaUserg(String username);
}
