package com.example.twinscriptsquadfoyer.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Setter
@Getter
@Table(name = "Foyer")
public class Foyer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;

    @Column(name = "nomFoyer")
    private String nomFoyer;

    @Column(name = "capaciteFoyer")
    private long capaciteFoyer;

//gzdhdhdhzhdhzdhdhzd

  //  @OneToOne(mappedBy = "foyer")
    // @JsonManagedReference
   // @JsonIgnore
    //private Universite universite ;


 //   @OneToMany(mappedBy = "foyer")
  //  @JsonIgnore
  //  private Set<Bloc> blocs = new HashSet<>();
  //  @OneToMany( mappedBy = "foyer")
   // @JsonIgnore
   // private List<Bloc> blocss;

}
