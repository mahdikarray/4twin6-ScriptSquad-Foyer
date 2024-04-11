package com.example.twinscriptsquadfoyer.dao.restcontroller;

import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
import com.example.twinscriptsquadfoyer.dao.service.foyer.FoyerService;
import com.example.twinscriptsquadfoyer.dao.service.foyer.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("foyer")
public class FoyerRestController {

    @Autowired
    IFoyerService iFoyerService;
    FoyerService foyerService;

   private final String protocol = "http://";
   private final String ipAddress = "192.168.1.21";
   private final String port = "4201";
   private final String allowedOrigin = protocol + ipAddress + ":" + port;


    @CrossOrigin(origins = {allowedOrigin})
    @GetMapping("/findAll")
    public List<Foyer> findAll(){
        return  iFoyerService.findAll();
    }

    @CrossOrigin(origins = {allowedOrigin})
    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return iFoyerService.addFoyer(f);
    }

    @CrossOrigin(origins = {allowedOrigin})
    @PutMapping("update/{id}")
    public Foyer updateFoyer(@RequestBody Foyer f){
        return iFoyerService.editFoyer(f);
    }

    @CrossOrigin(origins = {allowedOrigin})
    @DeleteMapping("/delete/{id}")
    public void deleteFoyer(@PathVariable("id") Long id){
        iFoyerService.deleteById(id);
    }

    @CrossOrigin(origins = {allowedOrigin})
    @GetMapping("/{id}")
    public Foyer findById(@PathVariable("id") Long id){
        return iFoyerService.findById(id);
    }

    @CrossOrigin(origins = {allowedOrigin})
    @GetMapping("/search/{nomFoyer}")
    public ResponseEntity<List<Foyer>> searchFoyersByNomFoyer(@PathVariable String nomFoyer) {
        List<Foyer> foyers = foyerService.searchFoyersByNomFoyer(nomFoyer);
        return ResponseEntity.ok(foyers);
    }
}
