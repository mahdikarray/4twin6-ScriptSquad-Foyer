package com.example.twin6scriptsquadfoyer.DAO.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Builder
@Entity
@Setter
@Getter
@Table(name = "Foyer")
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;

    @Column(name = "nomFoyer")
    private String nomFoyer;

    @Column(name = "capaciteFoyer")
    private long capaciteFoyer;

//gzdhdhdhzhdhzdhdhzd

    @OneToOne(mappedBy = "foyer")
    // @JsonManagedReference
    @JsonIgnore
    private Universite universite ;


    @OneToMany(mappedBy = "foyer")
    @JsonIgnore
    private Set<Bloc> blocs = new HashSet<>();
    @OneToMany( mappedBy = "foyer")
    @JsonIgnore
    private List<Bloc> blocss;

}
