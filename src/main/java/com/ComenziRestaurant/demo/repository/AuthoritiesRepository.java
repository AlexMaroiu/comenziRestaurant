package com.ComenziRestaurant.demo.repository;

import com.ComenziRestaurant.demo.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {
}
