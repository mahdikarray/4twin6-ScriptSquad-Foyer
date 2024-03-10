package com.example.twinscriptsquadfoyer.dao.service;

import com.example.twinscriptsquadfoyer.dao.entity.Universite;

import java.util.List;

public interface IuniversiteService {

    Universite addUniversite(Universite u );
    List<Universite> addUniversites(List<Universite> universites);
    Universite editUniversite(Universite u);
    List<Universite> findAll();
    Universite findById(long id);
    void deleteById(long id);
    void delete(Universite u);
}
