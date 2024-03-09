package com.example.twinscriptsquadfoyer;

/*import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.service.BlocService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.testng.Assert.assertEquals;
/*@SpringBootTest
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

    @Test
    void testEditExistingBloc() {
        // Assuming there is an existing bloc with ID 1 in the database
        Long existingBlocId = 1L;

        // Retrieve the existing bloc from the database
        Bloc existingBloc = blocService.findById(existingBlocId);

        // Modify the existing bloc
        existingBloc.setNomBloc("Edited Bloc");
        existingBloc.setCapaciteBloc(20);

        // Update the existing bloc in the database
        Bloc updatedBloc = blocService.editBloc(existingBloc);

        // Retrieve the updated bloc from the database for verification
        Bloc retrievedBloc = blocService.findById(existingBlocId);

        // Assertions
        Assertions.assertNotNull(retrievedBloc);
        Assertions.assertEquals("Edited Bloc", retrievedBloc.getNomBloc());
        Assertions.assertEquals(20, retrievedBloc.getCapaciteBloc());
    }


    @Test
    void testFindExistingBloc() {
        // Assuming there is an existing bloc with ID 1 in the database
        Long existingBlocId = 1L;

        // Retrieve the existing bloc from the database
        Bloc existingBloc = blocService.findById(existingBlocId);

        // Assertions
        Assertions.assertNotNull(existingBloc);
        // Add more assertions as needed to validate the existing bloc
    }

    @Test
    void testDeleteExistingBloc() {
        // Assuming there is an existing bloc with ID 1 in the database
        Long existingBlocId = 1L;

        // Delete the existing bloc from the database
        blocService.deleteById(existingBlocId);

        // Attempt to find the deleted bloc from the database
        Bloc deletedBloc = blocService.findById(existingBlocId);

        // Assertion
        Assertions.assertNull(deletedBloc);
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

import java.util.Optional;

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
    @Test
     void testFindBlocById() {
        long blocIdToFind = 1L;

        // Mock the behavior of the repository findById method
        Mockito.when(blocRepository.findById(blocIdToFind))
                .thenReturn(Optional.of(Bloc.builder()
                        .idBloc(blocIdToFind)
                        .nomBloc("Found Bloc")
                        .capaciteBloc(25)
                        .build()));

        // Find the Bloc
        Bloc foundBloc = blocService.findById(blocIdToFind);

        // Verify that the found Bloc matches our expectations
        assertEquals("Found Bloc", foundBloc.getNomBloc());
        assertEquals(25, foundBloc.getCapaciteBloc());
    }
    @Test
     void testDeleteBloc() {
        long blocIdToDelete = 1L;

        blocService.deleteById(blocIdToDelete);

        Mockito.verify(blocRepository).deleteById(blocIdToDelete);
    }
    @Test
     void testEditBloc() {
        Bloc existingBloc = Bloc.builder()
                .idBloc(1L)
                .nomBloc("Existing Bloc")
                .capaciteBloc(20)
                .build();

        Mockito.when(blocRepository.findById(1L))
                .thenReturn(Optional.of(existingBloc));
        Mockito.when(blocRepository.save(any(Bloc.class)))
                .thenReturn(existingBloc);

        Bloc updatedBloc = blocService.editBloc(existingBloc);

        assertEquals("Updated Bloc", updatedBloc.getNomBloc());
        assertEquals(30, updatedBloc.getCapaciteBloc());
    }

}


