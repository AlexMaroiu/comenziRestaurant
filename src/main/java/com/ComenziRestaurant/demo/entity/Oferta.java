package com.ComenziRestaurant.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "oferte")
@Table(name = "oferte")
public class Oferta {

    public Oferta(){
        this.reducere = 25;
        this.valabil = LocalDate.now();
    }

    @Id
    @Column
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mancare")
    private Mancare id_mancare;

    @Column
    private int reducere;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate valabil;
}
