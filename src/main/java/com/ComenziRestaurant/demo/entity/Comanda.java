package com.ComenziRestaurant.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "Comanda")
public class Comanda {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mancare")
    private Mancare id_mancare;

    @Column
    private int portii;

    @Column
    private double pret;

    @Column
    private String username;

    @Column
    private boolean finalizat;

    public Comanda(){
        portii = 1;
    }
}
