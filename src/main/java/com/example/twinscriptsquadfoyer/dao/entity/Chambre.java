package com.example.twinscriptsquadfoyer.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "chambre")
@Builder
public class Chambre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;

    @Column(name = "numeroChambre", unique = true)
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

    @Transient
    private Long blocId; // Store the ID of the Bloc instead of the whole object

    public Chambre() {
        // Default constructor
    }
    @SuppressWarnings("squid:S00107")
    public Chambre(long idChambre, long numeroChambre, TypeChambre typeChambre, String statut, LocalDate dateDebut, LocalDate dateFin, Bloc bloc, Long blocId) {
        this.idChambre = idChambre;
        this.numeroChambre = numeroChambre;
        this.typeChambre = typeChambre;
        this.statut = statut;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.bloc = bloc;
        this.blocId = blocId;
    }


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
