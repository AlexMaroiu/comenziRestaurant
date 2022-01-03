package com.ComenziRestaurant.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean enabled;
}
