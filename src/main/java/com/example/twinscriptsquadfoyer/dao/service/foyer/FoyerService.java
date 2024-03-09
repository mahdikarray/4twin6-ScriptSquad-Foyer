package com.example.twinscriptsquadfoyer.dao.service.foyer;

import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
import com.example.twinscriptsquadfoyer.dao.repository.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FoyerService implements IFoyerService{
    @Autowired
    private FoyerRepository foyerRepository;

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> addFoyers(List<Foyer> foyers) {
        return foyerRepository.saveAll(foyers);
    }

    @Override
    public Foyer editFoyer(Long id, Foyer f) {
        if(foyerRepository.findById(id).isPresent()){
            var toUpdateFoyer = foyerRepository.findById(id).get();
            toUpdateFoyer.setNomFoyer(f.getNomFoyer());
            toUpdateFoyer.setCapaciteFoyer(f.getCapaciteFoyer());
            toUpdateFoyer.setBlocs(f.getBlocs());
            toUpdateFoyer.setUniversite(f.getUniversite());

            return foyerRepository.save(toUpdateFoyer);
        }
        return null;
    }

    @Override
    public List<Foyer> findAll() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findById(long id) {
        return foyerRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public void delete(Foyer e) {
        foyerRepository.delete(e);
    }

    public List<Foyer> searchFoyersByNomFoyer(String nomFoyer) {
        return foyerRepository.findByNomFoyerContainingIgnoreCase(nomFoyer);
    }
}
