package com.example.twinscriptsquadfoyer;

import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.service.BlocService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class BlocServiceTest {

    @Autowired
    private BlocService blocService;

    @Test
    void testAjouterBloc() {
        Bloc sampleBloc = Bloc.builder()
                .nomBloc("Sample Bloc")
                .capaciteBloc(10)
                .build();
        Bloc savedBloc = blocService.addBloc(sampleBloc);
        Assertions.assertNotNull(savedBloc);
    }
}
