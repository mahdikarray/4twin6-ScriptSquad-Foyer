package com.example.twin6scriptsquadfoyer.DAO.Service;





import com.example.twin6scriptsquadfoyer.DAO.Entity.Bloc;
import com.example.twin6scriptsquadfoyer.DAO.Entity.Chambre;

import java.time.LocalDate;
import java.util.List;


public interface IChambreService {
    Chambre addChambre(Chambre b);
    List<Chambre> addChambres(List<Chambre> blocs);
    Chambre editChambre(Long id, Chambre b);
    List<Chambre> findAll();
    Chambre findById(long id);
    void delete(Chambre b);
     Chambre findByNumeroChambre(long numeroChambre);


    Bloc getBlocByChambre(long idChambre);
    boolean isNumeroChambreUnique(long numeroChambre);


    boolean isNumeroChambreUniqueForUpdate(Long id, Long numeroChambre);

    // Get chambre by ID
    Chambre getChambreById(Long idChambre);


    List<Long> findAllRoomNumbers();



}

