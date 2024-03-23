package com.example.twinscriptsquadfoyer.dao.repository;

import com.example.twinscriptsquadfoyer.dao.entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversiteRepo extends JpaRepository<Universite, Long>{

    Universite findByAdresse(String adresse);

}
