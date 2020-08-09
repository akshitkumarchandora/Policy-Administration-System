package com.cognizant.pas.AuthorizationServer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
    private Users users;

    public Authorities(String role) {
        this.role = role;
    }
}
