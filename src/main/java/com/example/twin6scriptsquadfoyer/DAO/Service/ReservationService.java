package com.example.twin6scriptsquadfoyer.DAO.Service;

import com.example.twin6scriptsquadfoyer.DAO.Entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReservationService implements IReservationService{
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;


    @Override
    public Reservation addReservation(Reservation r) {
        return null;
    }

    @Override
    public Reservation editReservation(String id, Reservation r) {
        return null;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(String id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void delete(Reservation e) {
        reservationRepository.delete(e);
    }

    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(long numChambre, long cin) {
        return null;
    }

    @Override
    public void acceptReservation(String idReservation) {

    }

    @Override
    public void refuseReservation(String idReservation) {

    }


    private Reservation findReservationById(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    private Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }




}
