package com.example.twinscriptsquadfoyer.dao.service;

import com.example.twinscriptsquadfoyer.dao.entity.Universite;
import com.example.twinscriptsquadfoyer.dao.repository.UniversiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Universite editUniversite(Universite u) {
        return universiteRepo.save(u);
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
}