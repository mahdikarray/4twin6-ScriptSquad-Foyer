package com.example.twinscriptsquadfoyer.DAO.RestController;

import com.example.twinscriptsquadfoyer.DAO.Entity.Foyer;
import com.example.twinscriptsquadfoyer.DAO.Service.Foyer.FoyerService;
import com.example.twinscriptsquadfoyer.DAO.Service.Foyer.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("foyer")
@CrossOrigin(origins = "http://localhost:4200")

public class FoyerRestController {

    @Autowired
    IFoyerService iFoyerService;
    FoyerService foyerService;
    @GetMapping("/findAll")
    List<Foyer> findAll(){
        return  iFoyerService.findAll();
    }

    @PostMapping("/add")
    //@PreAuthorize("hasRole('ADMIN')")
    Foyer addFoyer(@RequestBody Foyer f) {
        return iFoyerService.addFoyer(f);
    }

    @PutMapping("update/{id}")
   // @PreAuthorize("hasRole('ADMIN')")
    Foyer updateFoyer(@PathVariable("id") Long id, @RequestBody Foyer f){
        return iFoyerService.editFoyer(id, f);
    }

    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    void deleteFoyer(@PathVariable("id") Long id){
        iFoyerService.deleteById(id);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    Foyer findById(@PathVariable("id") Long id){
        return iFoyerService.findById(id);
    }



    @GetMapping("/search/{nomFoyer}")
    public ResponseEntity<List<Foyer>> searchFoyersByNomFoyer(@PathVariable String nomFoyer) {
        List<Foyer> foyers = foyerService.searchFoyersByNomFoyer(nomFoyer);
        return ResponseEntity.ok(foyers);
    }
}



