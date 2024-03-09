package com.example.twinscriptsquadfoyer.dao.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Bloc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long idBloc ;
    @Column(name="nomBloc")
    private String nomBloc ;
    @Column(name="capaciteBloc")
    private int capaciteBloc ;
    @OneToMany(mappedBy = "bloc" , cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private Set<Chambre> chambers = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "foyer_id")
    @JsonIgnore
    private Foyer foyer;
}
