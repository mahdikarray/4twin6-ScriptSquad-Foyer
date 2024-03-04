package com.example.twinscriptsquadfoyer.dao.restcontroller;

import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.entity.Chambre;
import com.example.twinscriptsquadfoyer.dao.repository.ChambreRepository;
import com.example.twinscriptsquadfoyer.dao.service.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("chambre")
@CrossOrigin(origins = "http://localhost:4200")
public class ChambreRestController {

    //test-fares
    @Autowired
    IChambreService iChambreService;

    @Autowired
    ChambreRepository chambreRepository;

    @GetMapping("/findAll")

    List<Chambre> findAll(){
        return  iChambreService.findAll();
    }
    @GetMapping("/searchByBloc")
    public List<Chambre> searchChambresByBlocName(@RequestParam String nomBloc) {
        return chambreRepository.findByBlocNomBloc(nomBloc);
    }




        @PutMapping("/update/{id}")
       // @PreAuthorize("hasRole('ADMIN')")

        public ResponseEntity updateChambre(@PathVariable("id") Long idChambre, @RequestBody Chambre updatedChambre) {
            Chambre existingChambre = iChambreService.getChambreById(idChambre);

            if (existingChambre == null) {
                return new ResponseEntity<>("Chambre not found", HttpStatus.NOT_FOUND);
            }

            long numeroChambre = updatedChambre.getNumeroChambre();

            // Check for uniqueness, excluding the current chambre being updated
            if (!iChambreService.isNumeroChambreUniqueForUpdate(idChambre, numeroChambre)) {
                return new ResponseEntity<>("Le numéro de chambre doit être unique", HttpStatus.CONFLICT);
            }

            Chambre modifiedChambre = iChambreService.editChambre(idChambre, updatedChambre);
            return new ResponseEntity<>(modifiedChambre, HttpStatus.OK);
        }






            @GetMapping("/{id}")
          //  @PreAuthorize("hasRole('ADMIN')")
            public Chambre findById(@PathVariable("id") Long id){
                return iChambreService.findById(id);
            }

            @GetMapping("selectByNumSQL")
          //  @PreAuthorize("hasRole('ADMIN')")

            public List<Chambre> selectByNumSQL(long num){
                return chambreRepository.selectByNumSQL(num);
            }

            @GetMapping("/findByNumeroChambre/{numeroChambre}")
          //  @PreAuthorize("hasRole('ADMIN')")

            public ResponseEntity<Chambre> findByNumeroChambre(@PathVariable long numeroChambre) {
                Chambre chambre = iChambreService.findByNumeroChambre(numeroChambre);
                if (chambre == null) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(chambre, HttpStatus.OK);
            }


            @GetMapping("/bloc/{idChambre}")
           // @PreAuthorize("hasRole('ADMIN')")

            public ResponseEntity<Bloc> getBlocByChambre(@PathVariable long idChambre) {
                Bloc bloc = iChambreService.getBlocByChambre(idChambre);
                return new ResponseEntity<>(bloc, HttpStatus.OK);
            }




        }
