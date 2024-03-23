package com.example.twinscriptsquadfoyer.dao.service;


import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.entity.Chambre;
import com.example.twinscriptsquadfoyer.dao.repository.BlocRepository;
import com.example.twinscriptsquadfoyer.dao.repository.ChambreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ChambreService implements IChambreService {
    @Autowired
    private ChambreRepository chambreRepository;
    BlocRepository blocRepository;
    @Autowired
    public ChambreService(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    public List<Chambre> searchChambresByBlocName(String nomBloc) {
        return chambreRepository.findByBlocNomBloc(nomBloc);
    }
    @Override
    public Chambre addChambre(Chambre c) {
        // Ensure that the associated Bloc is saved
        var bloc = c.getBloc();
        if (bloc != null && bloc.getIdBloc() == 0) {
            c.setBloc(bloc);
        }
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
        Optional<Chambre> optionalChambre = chambreRepository.findById(id);
        if(optionalChambre.isPresent()){
            var toUpdateChambre = optionalChambre.get();
            toUpdateChambre.setNumeroChambre(c.getNumeroChambre());
            toUpdateChambre.setTypeChambre(c.getTypeChambre());
            toUpdateChambre.setBloc(c.getBloc());
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
        Optional<Chambre> optionalChambre = chambreRepository.findById(id);
        return optionalChambre.orElse(null);
    }


    public void delete(Chambre c) {
        chambreRepository.delete(c);
    }

    public void deleteById(long id) {
        chambreRepository.deleteById(id);

    }

    public Bloc getBlocByChambre(long idChambre) {
        var chambre = chambreRepository.findById(idChambre)
                .orElseThrow(() -> new EntityNotFoundException("Chambre not found"));

        return chambre.getBloc();
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
