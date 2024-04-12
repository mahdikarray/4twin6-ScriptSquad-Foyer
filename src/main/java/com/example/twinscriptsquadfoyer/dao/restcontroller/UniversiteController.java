package com.example.twinscriptsquadfoyer.dao.restcontroller;

import com.example.twinscriptsquadfoyer.dao.entity.Universite;
import com.example.twinscriptsquadfoyer.dao.service.IuniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/updateUniv/{id}")
    public Universite updateUniversite(@PathVariable("id") Long id , @RequestBody Universite u){
        return iUniversiteService.editUniversite(u);
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
}