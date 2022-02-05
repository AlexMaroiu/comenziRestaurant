package com.ComenziRestaurant.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Authorities")
public class Authorities {

    @Column
    @Id
    private String username;

    @Column
    private String authority;
}
