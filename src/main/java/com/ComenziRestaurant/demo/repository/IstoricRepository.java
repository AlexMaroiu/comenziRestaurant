package com.ComenziRestaurant.demo.repository;

import com.ComenziRestaurant.demo.entity.Istoric;
import com.ComenziRestaurant.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IstoricRepository extends JpaRepository<Istoric, Integer> {

    @Query("select i from Istoric i where username=?1")
    public List<Istoric> getIstoricByUser(User user);
}
