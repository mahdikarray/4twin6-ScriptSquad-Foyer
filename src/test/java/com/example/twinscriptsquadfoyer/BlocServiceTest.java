package com.example.twinscriptsquadfoyer;/*package com.example.twinscriptsquadfoyer;

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
*/
import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.repository.BlocRepository;
import com.example.twinscriptsquadfoyer.dao.service.BlocService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
 class BlocServiceTest {

    @Mock
    private BlocRepository blocRepository; // Mock the repository

    @InjectMocks
    private BlocService blocService; // Inject the mocked service

    @Test
     void testAjouterBloc() {
        // Create a sample Bloc
        Bloc sampleBloc = Bloc.builder()
                .nomBloc("Sample Bloc")
                .capaciteBloc(10)
                .build();

        // Mock the behavior of the repository save method
        Mockito.when(blocRepository.save(any(Bloc.class)))
                .thenReturn(sampleBloc);

        // Add the Bloc
        Bloc savedBloc = blocService.addBloc(sampleBloc);

        // Verify that the Bloc has been added
        assertEquals("Sample Bloc", savedBloc.getNomBloc());
        assertEquals(10, savedBloc.getCapaciteBloc());

        // Clean up (optional):
        // blocService.supprimerBloc(savedBloc.getIdBloc());
    }
}
