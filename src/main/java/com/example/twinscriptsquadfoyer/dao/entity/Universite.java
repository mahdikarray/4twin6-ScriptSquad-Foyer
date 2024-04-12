package com.example.twinscriptsquadfoyer.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "universite")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite;


    @Column(name = "nomUniversite")
    private String nomUniversite;

    @Column(name = "adresse")
    private String adresse;


@OneToOne(cascade = CascadeType.ALL)
@JsonIgnore
 private Foyer foyer;
}