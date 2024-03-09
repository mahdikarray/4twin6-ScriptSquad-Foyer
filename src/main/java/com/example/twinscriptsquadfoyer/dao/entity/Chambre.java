package com.example.twinscriptsquadfoyer.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "chambre")
@Builder
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;


    @Column(name = "numeroChambre",unique = true)
    private long numeroChambre;

    @Column(name = "typeChambre")
    private TypeChambre typeChambre;


    @Column(name = "statut")
    private String statut;

    @Column(name = "dateDebut")
    private LocalDate dateDebut;


    @Column(name = "dateFin")
    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "bloc_id_bloc", referencedColumnName = "idBloc")
    @JsonBackReference
    private Bloc bloc;




    public long getIdChambre() {
        return idChambre;
    }

    public long getNumeroChambre() {
        return numeroChambre;
    }

    public TypeChambre getTypeChambre() {
        return typeChambre;
    }

    public String getStatut() {
        return statut;
    }

    public Bloc getBloc() {
        return bloc;
    }


    public void setIdChambre(long idChambre) {
        this.idChambre = idChambre;
    }

    public void setNumeroChambre(long numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public void setTypeChambre(TypeChambre typeChambre) {
        this.typeChambre = typeChambre;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

}
