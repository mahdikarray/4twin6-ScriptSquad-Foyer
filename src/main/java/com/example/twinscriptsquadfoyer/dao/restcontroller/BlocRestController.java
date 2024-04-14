package com.example.twinscriptsquadfoyer.dao.restcontroller;


import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.service.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor

@RequestMapping("/api/blocs")
public class BlocRestController {
    IBlocService iBlocService;

    @GetMapping("/findAll")
    public List<Bloc> findAll(){
        return iBlocService.findAll();
    }

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc b){
        return iBlocService.addBloc(b);
    }

    @GetMapping("findById/{id}")
    public Bloc findById(@PathVariable("id") long id){
        return iBlocService.findById(id);
    }

    @DeleteMapping("deleteByID/{id}")
    public void deleteByID(@PathVariable("id") long id){
        iBlocService.deleteById(id);
    }

    @DeleteMapping("deleteB")
    public void delete(@RequestBody Bloc b){
        iBlocService.delete(b);
    }

    @PutMapping("editBloc")
    public Bloc editBloc(@RequestBody Bloc b){
        return iBlocService.editBloc(b);
    }

  
}