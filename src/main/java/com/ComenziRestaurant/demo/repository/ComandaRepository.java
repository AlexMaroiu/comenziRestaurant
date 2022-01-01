package com.ComenziRestaurant.demo.repository;

import com.ComenziRestaurant.demo.entity.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Integer> {
}
