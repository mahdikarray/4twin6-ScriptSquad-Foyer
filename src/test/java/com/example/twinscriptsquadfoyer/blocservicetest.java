package com.example.twinscriptsquadfoyer;

import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.service.BlocService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest


public class blocservicetest {

    @Autowired
    private BlocService blocService;

    @Test
    public void testAjouterBloc() {
        Bloc sampleBloc = Bloc.builder()
                .nomBloc("Sample Bloc")
                .capaciteBloc(10)
                .build();

        Bloc savedBloc = blocService.addBloc(sampleBloc);

        Assertions.assertNotNull(savedBloc.getIdBloc());


    }
}