package com.example.twin6scriptsquadfoyer.DAO.Service;




import com.example.twin6scriptsquadfoyer.DAO.Entity.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation r);

    Reservation editReservation(String id, Reservation r);
    List<Reservation> findAll();
    Reservation findById(String id);
    void deleteById(String id);
    void delete(Reservation r);

    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (long numChambre, long cin) ;

    void acceptReservation(String idReservation);
    void refuseReservation(String idReservation);

  //  Reservation addReservationWithPayment(Reservation reservation, PaymentMethods paymentMethod);




}

