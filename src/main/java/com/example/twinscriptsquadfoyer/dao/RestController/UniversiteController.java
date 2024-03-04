package com.example.twinscriptsquadfoyer.dao.RestController;

import com.example.twinscriptsquadfoyer.dao.entity.Universite;
import com.example.twinscriptsquadfoyer.dao.Service.IuniversiteService;
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
    List<Universite> findAll(){
        return  iUniversiteService.findAll();
    }

    @PostMapping("/addUniv")
    Universite addUniversite(@RequestBody Universite u) {
        return iUniversiteService.addUniversite(u);
    }

    @PutMapping("updateUniv/{id}")
    Universite updateUniversite(@PathVariable("id") Long id, @RequestBody Universite u){
        return iUniversiteService.editUniversite(id, u);
    }

    @DeleteMapping("/deleteUniv/{id}")
    void deleteUniversiteById(@PathVariable("id") Long id){
        iUniversiteService.deleteById(id);
    }
    @DeleteMapping("/delete")
    void deleteUniversite(@RequestBody Universite u){
        iUniversiteService.delete(u);
    }

    @GetMapping("findById/{id}")
    Universite findById(@PathVariable("id") Long id){
        return iUniversiteService.findById(id);
    }

}
