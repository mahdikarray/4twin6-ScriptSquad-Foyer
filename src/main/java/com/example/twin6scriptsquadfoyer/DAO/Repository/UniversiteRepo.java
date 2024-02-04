package com.example.twin6scriptsquadfoyer.DAO.Repository;

import com.example.twin6scriptsquadfoyer.DAO.Entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepo extends JpaRepository<Universite, Long>{

}
