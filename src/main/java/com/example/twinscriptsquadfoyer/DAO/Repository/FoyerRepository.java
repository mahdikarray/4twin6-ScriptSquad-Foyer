package com.example.twinscriptsquadfoyer.DAO.Repository;

import com.example.twinscriptsquadfoyer.DAO.Entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {


    List<Foyer> findByNomFoyerContainingIgnoreCase(String nomFoyer);

    Foyer findByNomFoyer(String nomFoyer);

}
