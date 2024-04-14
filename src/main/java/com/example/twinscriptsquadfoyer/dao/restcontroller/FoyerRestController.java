package com.example.twinscriptsquadfoyer.dao.restcontroller;

import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
import com.example.twinscriptsquadfoyer.dao.service.foyer.FoyerService;
import com.example.twinscriptsquadfoyer.dao.service.foyer.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("foyer")
@CrossOrigin(origins = "${foyer.allowed.origins}")

public class FoyerRestController {

    @Autowired
    IFoyerService iFoyerService;
    FoyerService foyerService;

    private  String ip;
    public FoyerRestController(){}
    public FoyerRestController(@Value("${foyer.socket.ip}") String ip) {
        this.ip = ip;
    }

    @GetMapping("/findAll")
    public List<Foyer> findAll(){
        return  iFoyerService.findAll();
    }

    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return iFoyerService.addFoyer(f);
    }

    @PutMapping("update/{id}")
    public Foyer updateFoyer(@RequestBody Foyer f){
        return iFoyerService.editFoyer(f);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFoyer(@PathVariable("id") Long id){
        iFoyerService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Foyer findById(@PathVariable("id") Long id){
        return iFoyerService.findById(id);
    }




}