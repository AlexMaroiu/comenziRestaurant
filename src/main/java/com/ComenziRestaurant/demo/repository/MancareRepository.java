package com.ComenziRestaurant.demo.repository;

import com.ComenziRestaurant.demo.entity.Mancare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MancareRepository extends JpaRepository<Mancare, Integer> {
}
