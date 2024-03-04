package com.example.twinscriptsquadfoyer.DAO.Repository;

import com.example.twinscriptsquadfoyer.DAO.Entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepo extends JpaRepository<Universite, Long>{

}
