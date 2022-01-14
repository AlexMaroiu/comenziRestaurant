package com.ComenziRestaurant.demo.repository;

import com.ComenziRestaurant.demo.entity.Mancare;
import com.ComenziRestaurant.demo.entity.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OferteRepository extends JpaRepository<Oferta, Integer> {

    @Query("select o from oferte o where (id_mancare=?1 and valabil>=?2)")
    public Optional<Oferta> gasesteIdMancare(Mancare mancare, LocalDate date);

    @Query("select o from oferte o where valabil>=?1")
    public List<Oferta> gasesteOfertaData(LocalDate date);
}
