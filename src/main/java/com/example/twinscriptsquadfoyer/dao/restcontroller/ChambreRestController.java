package com.example.twinscriptsquadfoyer.dao.restcontroller;

import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.entity.Chambre;
import com.example.twinscriptsquadfoyer.dao.repository.ChambreRepository;
import com.example.twinscriptsquadfoyer.dao.service.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("chambre")

public class ChambreRestController {

    //test-fares
    @Autowired
    IChambreService iChambreService;

    @Autowired
    ChambreRepository chambreRepository;

    @GetMapping("/findAll")

    public List<Chambre> findAll(){
        return  iChambreService.findAll();
    }
    @GetMapping("/searchByBloc")
    public List<Chambre> searchChambresByBlocName(@RequestParam String nomBloc) {
        return chambreRepository.findByBlocNomBloc(nomBloc);
    }

@PostMapping("/add")
public Chambre addChambre(Chambre c)
{
    return iChambreService.addChambre(c);
}









    @GetMapping("/{id}")
          //  @PreAuthorize("hasRole('ADMIN')")
            public Chambre findById(@PathVariable("id") Long id){
                return iChambreService.findById(id);
            }






        }