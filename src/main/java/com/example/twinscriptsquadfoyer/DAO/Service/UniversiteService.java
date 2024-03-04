package com.example.twinscriptsquadfoyer.DAO.Service;

import com.example.twinscriptsquadfoyer.DAO.Entity.Universite;
import com.example.twinscriptsquadfoyer.DAO.Repository.UniversiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteService implements IuniversiteService{
    @Autowired
    private UniversiteRepo universiteRepo ;
    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public List<Universite> addUniversites(List<Universite> universites) {
        return universiteRepo.saveAll(universites);
    }

    @Override
    public Universite editUniversite(Long id, Universite u) {
        if(universiteRepo.findById(id).isPresent()){
            Universite toUpdateUniversite = universiteRepo.findById(id).get();
            toUpdateUniversite.setNomUniversite(u.getNomUniversite());
            toUpdateUniversite.setAdresse(u.getAdresse());

            return universiteRepo.save(toUpdateUniversite);
        }
        return null;
    }

    @Override
    public List<Universite> findAll() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite findById(long id) {
        return universiteRepo.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        universiteRepo.deleteById(id);
    }

    @Override
    public void delete(Universite u) {
        universiteRepo.delete(u);
    }
}
