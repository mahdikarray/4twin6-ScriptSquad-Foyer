package com.example.twinscriptsquadfoyer.DAO.Service;

import com.example.twinscriptsquadfoyer.DAO.Entity.Universite;

import java.util.List;

public interface IuniversiteService {

    Universite addUniversite(Universite u );
    List<Universite> addUniversites(List<Universite> universites);
    Universite editUniversite(Long id, Universite u);
    List<Universite> findAll();
    Universite findById(long id);
    void deleteById(long id);
    void delete(Universite u);
}
