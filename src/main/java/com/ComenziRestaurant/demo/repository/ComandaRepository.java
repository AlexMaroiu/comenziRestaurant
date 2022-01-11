package com.ComenziRestaurant.demo.repository;

import com.ComenziRestaurant.demo.entity.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Integer> {

    @Query("select c from Comanda c where (username=?1 and finalizat = false)")
    public List<Comanda> gasesteDupaUser(String username);

    @Query(value = "select id, sum(portii) as portii, username, id_mancare, sum(pret) as pret, finalizat  from Comanda where (username=?1 and finalizat = false) group by  id_mancare",
    nativeQuery = true)
    public List<Comanda> gasesteDupaUserGrupat(String username);

    @Modifying
    @Query("update Comanda set finalizat = true where (finalizat = false and username = ?1)")
    public void updateComanda(String user);
}
