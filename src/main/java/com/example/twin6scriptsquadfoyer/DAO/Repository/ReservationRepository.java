package com.example.twin6scriptsquadfoyer.DAO.Repository;

import com.example.twin6scriptsquadfoyer.DAO.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

    Reservation findByIdReservation(String id);
    // 1- Recherche des réservations validées
    List<Reservation> findByEstValideTrue();

    // 2- Recherche des réservations par l'id de l'étudiant
    List<Reservation> findByEtudiantsIdEtudiant(long idEtudiant);

    // 3- Recherche des réservations par année et validité
    List<Reservation> findByAnneeUniversitaireAndEstValide(Date anneeUniversitaire, boolean estValide);
}
