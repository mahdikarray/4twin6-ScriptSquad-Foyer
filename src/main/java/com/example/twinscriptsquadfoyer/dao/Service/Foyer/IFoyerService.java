package com.example.twinscriptsquadfoyer.dao.Service.Foyer;



import com.example.twinscriptsquadfoyer.dao.entity.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addFoyer(Foyer f);

    List<Foyer> addFoyers(List<Foyer> foyers);
    Foyer editFoyer(Long id, Foyer f);
    List<Foyer> findAll();
    Foyer findById(long id);
    void deleteById(long id);
    void delete(Foyer f);
}

