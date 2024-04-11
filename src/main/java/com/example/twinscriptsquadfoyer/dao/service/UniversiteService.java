package com.example.twinscriptsquadfoyer.dao.service;

import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
import com.example.twinscriptsquadfoyer.dao.entity.Universite;
import com.example.twinscriptsquadfoyer.dao.repository.FoyerRepository;
import com.example.twinscriptsquadfoyer.dao.repository.UniversiteRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteService implements IuniversiteService{
    @Autowired
    private UniversiteRepo universiteRepo ;

    FoyerRepository foyerRepository;
    @Autowired
    public UniversiteService(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }

    @Override
    public Universite addUniversite(Universite u) {
        var foyer = u.getFoyer();
        if (foyer != null && foyer.getIdFoyer() == 0) {
            u.setFoyer(foyer);
        }
        return universiteRepo.save(u);
    }

    @Override
    public List<Universite> addUniversites(List<Universite> universites) {
        return universiteRepo.saveAll(universites);
    }

    @Override
    public Universite editUniversite(long id, Universite u) {

        Optional<Universite> optionalUniversite = universiteRepo.findById(id);
        if(optionalUniversite.isPresent()){
            var toUpdateUniversity = optionalUniversite.get();
            toUpdateUniversity.setNomUniversite(u.getNomUniversite());
            toUpdateUniversity.setAdresse(u.getAdresse());
            toUpdateUniversity.setFoyer(u.getFoyer());

            return universiteRepo.save(toUpdateUniversity);
        }
        return null;
    }

    @Override
    public List<Universite> findAll() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite findById(long id) {
        Optional<Universite> optionalUniversite = universiteRepo.findById(id);
        return optionalUniversite.orElse(null);
    }
    @Override
    public void deleteById(long id) {
        universiteRepo.deleteById(id);
    }

    @Override
    public void delete(Universite u) {
        universiteRepo.delete(u);
    }

    @Override
    public Universite getByAdresse(String adresse) {
        return universiteRepo.findByAdresse(adresse);
    }

    @Override
    public Foyer getFoyerByUniversity(long id) {
        var university = universiteRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("University not found"));

        return university.getFoyer();
    }
}
