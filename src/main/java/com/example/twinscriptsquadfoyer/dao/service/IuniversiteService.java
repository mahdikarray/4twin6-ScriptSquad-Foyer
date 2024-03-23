package com.example.twinscriptsquadfoyer.dao.service;

import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
import com.example.twinscriptsquadfoyer.dao.entity.Universite;

import java.util.List;

public interface IuniversiteService {

    Universite addUniversite(Universite u );
    List<Universite> addUniversites(List<Universite> universites);
    Universite editUniversite(long id,Universite u);
    List<Universite> findAll();
    Universite findById(long id);
    void deleteById(long id);
    void delete(Universite u);

    Universite getByAdresse(String adresse);

    Foyer getFoyerByUniversity(long id);
}
