package com.example.twin6scriptsquadfoyer.DAO.Repository;

import com.example.twin6scriptsquadfoyer.DAO.Entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {


    List<Foyer> findByNomFoyerContainingIgnoreCase(String nomFoyer);

    Foyer findByNomFoyer(String nomFoyer);

    // 1- Recherche des foyers d'un bloc spécifique
    //List<Foyer> findByBlocs(Bloc bloc);

    // 2- Recherche du foyer par son idFoyer pour un bloc donné
    //Foyer findByIdFoyerAndBlocs(Bloc bloc, long idFoyer);

    // 3- Recherche des foyers d'un bloc ayant une capacité spécifique
    //List<Foyer> findByBlocsCapaciteFoyer(Bloc bloc, long capaciteFoyer);

    // 4- Recherche du foyer d'un bloc spécifique dans une université donnée
    //List<Foyer> findByBlocsAndUniversite(Bloc bloc, Universite universite);
}
