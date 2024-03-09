package com.example.twinscriptsquadfoyer;

import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
import com.example.twinscriptsquadfoyer.dao.service.foyer.FoyerService;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

/*import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
import com.example.twinscriptsquadfoyer.dao.repository.FoyerRepository;
import com.example.twinscriptsquadfoyer.dao.service.foyer.FoyerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
 class FoyerServiceTest {

    @Mock
    private FoyerRepository foyerRepository; // Mock the repository

    @InjectMocks
    private FoyerService foyerService; // Inject the mocked service

    @Test
    void testAjouterFoyer() {
        // Create a sample Bloc
        Foyer sampleFoyer = Foyer.builder()
                .nomFoyer("Sample Foyer")
                .capaciteFoyer(10)
                .build();

        // Mock the behavior of the repository save method
        Mockito.when(foyerRepository.save(any(Foyer.class)))
                .thenReturn(sampleFoyer);

        // Add the Foyer
        Foyer savedFoyer = foyerService.addFoyer(sampleFoyer);

        // Verify that the Foyer has been added
        assertEquals("Sample Foyer", savedFoyer.getNomFoyer());
        assertEquals(10, savedFoyer.getCapaciteFoyer());

        // Clean up (optional):
        // blocService.supprimerBloc(savedBloc.getIdBloc());
    }

    @Test
    void testFindFoyerById() {
        long foyerIdToFind = 1L;

        // Mock the behavior of the repository findById method
        Mockito.when(foyerRepository.findById(foyerIdToFind))
                .thenReturn(Optional.of(Foyer.builder()
                        .idFoyer(foyerIdToFind)
                        .nomFoyer("Found Bloc")
                        .capaciteFoyer(25)
                        .build()));

        // Find the Foyer
        Foyer foundFoyer = foyerService.findById(foyerIdToFind);


        assertEquals("Found Bloc", foundFoyer.getNomFoyer());
        assertEquals(25, foundFoyer.getCapaciteFoyer());
    }


    @Test
    void testDeleteFoyer() {
        long foyerIdToDelete = 1L;

        foyerService.deleteById(foyerIdToDelete);

        Mockito.verify(foyerRepository).deleteById(foyerIdToDelete);
    }
    @Test
    void testEditFoyer() {
        Foyer existingFoyer = Foyer.builder()
                .idFoyer(1L)
                .nomFoyer("Existing Foyer")
                .capaciteFoyer(20)
                .build();
        Mockito.when(foyerRepository.findById(1L))
                .thenReturn(Optional.of(existingFoyer));
        Mockito.when(foyerRepository.save(any(Foyer.class)))
                .thenReturn(existingFoyer);
        Foyer updatedFoyer = foyerService.editFoyer(existingFoyer);
        assertEquals("Updated Bloc", updatedFoyer.getNomFoyer());
        assertEquals(30, updatedFoyer.getCapaciteFoyer());
    }

}
*/
@SpringBootTest
class FoyerServiceTest {
    @Autowired
    private FoyerService foyerService;

    @Test
    void testAjouterFoyer() {
        Foyer sampleFoyer = Foyer.builder()
                .nomFoyer("Sample Foyer")
                .capaciteFoyer(10)
                .build();
        Foyer savedFoyer = foyerService.addFoyer(sampleFoyer);
        Assertions.assertNotNull(savedFoyer);
    }

    @Test
    void testEditExistingFoyer() {
        // Assuming there is an existing bloc with ID 1 in the database
        Long existingFoyerId = 1L;

        // Retrieve the existing bloc from the database
        Foyer existingFoyer = foyerService.findById(existingFoyerId);

        // Modify the existing bloc
        existingFoyer.setNomFoyer("Edited Foyer");
        existingFoyer.setCapaciteFoyer(20);

        // Update the existing bloc in the database
        Foyer updatedFoyer = foyerService.editFoyer(existingFoyer);

        // Retrieve the updated bloc from the database for verification
        Foyer retrievedFoyer= foyerService.findById(existingFoyerId);

        // Assertions
        Assertions.assertNotNull(retrievedFoyer);
        Assertions.assertEquals("Edited Foyer", retrievedFoyer.getNomFoyer());
        Assertions.assertEquals(20, retrievedFoyer.getCapaciteFoyer());
    }


    @Test
    void testFindExistingFoyer() {
        // Assuming there is an existing bloc with ID 1 in the database
        Long existingFoyerId = 1L;

        // Retrieve the existing bloc from the database
        Foyer existingFoyer = foyerService.findById(existingFoyerId);

        // Assertions
        Assertions.assertNotNull(existingFoyer);
        // Add more assertions as needed to validate the existing bloc
    }

    @Test
    void testDeleteExistingFoyer() {
        // Assuming there is an existing bloc with ID 1 in the database
        Long existingFoyerId = 1L;

        // Delete the existing bloc from the database
        foyerService.deleteById(existingFoyerId);

        // Attempt to find the deleted bloc from the database
        Foyer deletedFoyer = foyerService.findById(existingFoyerId);

        // Assertion
        Assertions.assertNull(deletedFoyer);
    }
}