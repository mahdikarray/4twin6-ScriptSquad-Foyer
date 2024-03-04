package com.example.twinscriptsquadfoyer.dao.repository;

import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.entity.Chambre;
import com.example.twinscriptsquadfoyer.dao.entity.TypeChambre;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.testng.annotations.Test;


import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    // 1- Recherche par numéro de chambre
    @Test
    @Order(0)
    Chambre findByNumeroChambre(long numeroChambre);

    // 2- Recherche par type de chambre
    @Test
    @Order(1)
    List<Chambre> findByTypeChambre(TypeChambre typeChambre);
    @Test
    @Order(2)
    List<Chambre> findByBlocNomBloc(String nomBloc);

    // 3- Recherche des chambres par bloc
    List<Chambre> findByBloc(Bloc bloc);

    // 4- Recherche des chambres par bloc et type de chambre
    List<Chambre> findByBlocAndTypeChambre(Bloc bloc, TypeChambre typeChambre);

    // 5- Recherche des chambres par numéro de chambre et type de chambre
    List<Chambre> findByNumeroChambreAndTypeChambre(long numeroChambre, TypeChambre typeChambre);
    //Recherche par numero de chambre


    //Recherche par numero de chambre
    @Query("select c from Chambre c where c.numeroChambre=?1")
    List<Chambre> selectByNum(Long num);

    @Query("select c from Chambre c where c.numeroChambre=:num")
    List<Chambre> selectByNum2(@Param(value = "num") long num);

    @Query(value = "select * from chambre where numeroChambre=?1 ", nativeQuery = true)
    List<Chambre> selectByNumSQL(long num);

    List<Chambre> findByStatut(String statut);


    boolean existsByIdChambreNotAndNumeroChambre(Long idChambre, Long numeroChambre);


}

