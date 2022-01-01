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

    @Column
    private int id_mancare;

    @Column
    private int portii;

    public Comanda(){
        portii = 1;
    }
}
