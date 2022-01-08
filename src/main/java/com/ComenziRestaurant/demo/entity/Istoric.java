package com.ComenziRestaurant.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "Istoric")
public class Istoric {

    @Id
    @Column
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User username;

    @Column
    private LocalDate data_comanda;

    @Column
    private double valoare;
}
