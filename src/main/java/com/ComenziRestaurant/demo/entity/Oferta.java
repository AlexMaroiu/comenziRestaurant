package com.ComenziRestaurant.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "oferte")
@Table(name = "oferte")
public class Oferta {

    @Id
    @Column
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mancare")
    private Mancare id_mancare;

    @Column
    private int reducere;

    @Column
    private LocalDate valabil;
}
