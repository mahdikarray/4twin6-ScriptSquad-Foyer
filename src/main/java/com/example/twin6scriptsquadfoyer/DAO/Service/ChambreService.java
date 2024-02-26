package com.example.twin6scriptsquadfoyer.DAO.Service;


import com.example.twin6scriptsquadfoyer.DAO.Entity.Bloc;
import com.example.twin6scriptsquadfoyer.DAO.Entity.Chambre;
import com.example.twin6scriptsquadfoyer.DAO.Entity.Reservation;
import com.example.twin6scriptsquadfoyer.DAO.Repository.BlocRepository;
import com.example.twin6scriptsquadfoyer.DAO.Repository.ChambreRepository;
import com.example.twin6scriptsquadfoyer.DAO.Repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ChambreService implements IChambreService {
    @Autowired
    private ChambreRepository chambreRepository;
    private BlocRepository blocRepository;
    private ReservationRepository reservationRepository;
    @Autowired
    public ChambreService(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    public List<Chambre> searchChambresByBlocName(String nomBloc) {
        return chambreRepository.findByBloc_NomBloc(nomBloc);
    }
    @Override
    public Chambre addChambre(Chambre c) {

        Bloc bloc = c.getBloc();
        if (bloc != null && bloc.getIdBloc() == 0) {
            c.setBloc(bloc);
        }

        // Save the Chambre
        return chambreRepository.save(c);
    }



    @Override

    public Chambre findByNumeroChambre(long numeroChambre) {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }
    @Override
    public List<Chambre> addChambres(List<Chambre> chambres) {
        return chambreRepository.saveAll(chambres);
    }

    @Override
    public Chambre editChambre(Long id, Chambre c) {
        if(chambreRepository.findById(id).isPresent()){
            Chambre toUpdateChambre = chambreRepository.findById(id).get();
            toUpdateChambre.setNumeroChambre(c.getNumeroChambre());
            toUpdateChambre.setTypeChambre(c.getTypeChambre());
            toUpdateChambre.setBloc(c.getBloc());
            toUpdateChambre.setReservations(c.getReservations());
            return chambreRepository.save(toUpdateChambre);
        }
        return null;
    }

    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre findById(long id) {
        return chambreRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        Chambre chambre = chambreRepository.findById(id).orElse(null);

        if (chambre != null) {
            // Remove the association with reservations
            for (Reservation reservation : chambre.getReservations()) {
                reservation.setChambre(null);
            }
            // Clear the reservations collection in Chambre
            chambre.getReservations().clear();

            // Now you can safely delete the Chambre
            chambreRepository.deleteById(id);
        }
    }


    public void delete(Chambre c) {
        chambreRepository.delete(c);
    }

    // ChambreRestController.java

    @Override
    public boolean isChambreOccupeeALaDate(long chambreId, LocalDate date) {
        Optional<Chambre> optionalChambre = chambreRepository.findById(chambreId);

        if (optionalChambre.isPresent()) {
            Chambre chambre = optionalChambre.get();
            return chambre.isOccupeeALaDate(date);
        }

        return false;
    }
    @Override
    public boolean isChambreOccupee(long chambreId) {
        Optional<Chambre> optionalChambre = chambreRepository.findById(chambreId);

        if (optionalChambre.isPresent()) {
            Chambre chambre = optionalChambre.get();
            return chambre.isOccupee();
        }

        return false;
    }
    public Bloc getBlocByChambre(long idChambre) {
        Chambre chambre = chambreRepository.findById(idChambre)
                .orElseThrow(() -> new EntityNotFoundException("Chambre not found"));

        return chambre.getBloc();
    }

    @Override
    public boolean isNumeroChambreUnique(long numeroChambre) {
        return !chambreRepository.existsByNumeroChambre(numeroChambre);
    }
    @Override
    public boolean isNumeroChambreUniqueForUpdate(Long idChambre, Long numeroChambre) {
        // Implement logic to check if the chambre number is unique, excluding the chambre with the given ID
        return !chambreRepository.existsByIdChambreNotAndNumeroChambre(idChambre, numeroChambre);
    }

    @Override
    public Chambre getChambreById(Long idChambre) {
        // Implement logic to retrieve a chambre by its ID
        Optional<Chambre> optionalChambre = chambreRepository.findById(idChambre);
        return optionalChambre.orElse(null);

    }
        @Override
        public List<Long> findAllRoomNumbers() {
            // Retrieve all Chambre entities and map them to their numeroChambre
            return chambreRepository.findAll().stream()
                    .map(Chambre::getNumeroChambre)
                    .distinct() // only unique
                    .collect(Collectors.toList());
        }
    }
