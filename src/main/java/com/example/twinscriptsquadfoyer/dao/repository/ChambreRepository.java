package com.example.twinscriptsquadfoyer.dao.repository;

import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.entity.Chambre;
import com.example.twinscriptsquadfoyer.dao.entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    Chambre findByNumeroChambre(long numeroChambre);


    List<Chambre> findByTypeChambre(TypeChambre typeChambre);
    List<Chambre> findByBlocNomBloc(String nomBloc);


    List<Chambre> findByBloc(Bloc bloc);

    List<Chambre> findByBlocAndTypeChambre(Bloc bloc, TypeChambre typeChambre);


    List<Chambre> findByNumeroChambreAndTypeChambre(long numeroChambre, TypeChambre typeChambre);

    @Query("select c from Chambre c where c.numeroChambre=?1")
    List<Chambre> selectByNum(Long num);

    @Query("select c from Chambre c where c.numeroChambre=:num")
    List<Chambre> selectByNum2(@Param(value = "num") long num);

    @Query(value = "select * from chambre where numeroChambre=?1 ", nativeQuery = true)
    List<Chambre> selectByNumSQL(long num);

    List<Chambre> findByStatut(String statut);


    boolean existsByIdChambreNotAndNumeroChambre(Long idChambre, Long numeroChambre);
}