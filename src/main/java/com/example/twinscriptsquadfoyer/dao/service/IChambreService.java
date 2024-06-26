package com.example.twinscriptsquadfoyer.dao.service;

import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.entity.Chambre;
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
    void deleteById(long id);
    boolean isNumeroChambreUniqueForUpdate(Long id, Long numeroChambre);
    Chambre getChambreById(Long idChambre);
    List<Long> findAllRoomNumbers();
}