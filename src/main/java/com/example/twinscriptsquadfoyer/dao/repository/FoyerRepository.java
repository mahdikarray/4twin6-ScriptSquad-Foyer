package com.example.twinscriptsquadfoyer.dao.repository;

import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {


   

    Foyer findByNomFoyer(String nomFoyer);

}
