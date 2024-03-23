package com.example.twinscriptsquadfoyer.dao.restcontroller;

import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
import com.example.twinscriptsquadfoyer.dao.entity.Universite;
import com.example.twinscriptsquadfoyer.dao.service.IuniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {

    @Autowired
    IuniversiteService iUniversiteService;

    @GetMapping("/findAll")
    public List<Universite> findAll(){
        return  iUniversiteService.findAll();
    }

    @PostMapping("/addUniv")
    public Universite addUniversite(@RequestBody Universite u) {
        return iUniversiteService.addUniversite(u);
    }

    @PostMapping("/addUnivs")
    public List<Universite> addUniversities(@RequestBody List<Universite> universites) {
        return iUniversiteService.addUniversites(universites);
    }

    @PutMapping("/updateUniv/{id}")
    public Universite updateUniversite(@PathVariable("id") Long id , @RequestBody Universite u){
        return iUniversiteService.editUniversite(id,u);
    }

    @DeleteMapping("/deleteUniv/{id}")
    public void deleteUniversiteById(@PathVariable("id") Long id){
        iUniversiteService.deleteById(id);
    }
    @DeleteMapping("/delete")
    public void deleteUniversite(@RequestBody Universite u){
        iUniversiteService.delete(u);
    }

    @GetMapping("findById/{id}")
    public Universite findById(@PathVariable("id") Long id){
        return iUniversiteService.findById(id);
    }

    @GetMapping("/getByAddress")
    public Universite getByAddress(@RequestBody String address){
        return iUniversiteService.getByAdresse(address);
    }

    @GetMapping("/getFoyerByUniv")
    public ResponseEntity<Foyer> getFoyerByUniversity(@PathVariable long id) {
        var foyer = iUniversiteService.getFoyerByUniversity(id);
        return new ResponseEntity<>(foyer, HttpStatus.OK);
    }


}
