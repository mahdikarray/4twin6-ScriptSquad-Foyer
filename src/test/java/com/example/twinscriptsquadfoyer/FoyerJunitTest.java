package com.example.twinscriptsquadfoyer;


import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
import com.example.twinscriptsquadfoyer.dao.service.foyer.IFoyerService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FoyerJunitTest {



    @Autowired
    private IFoyerService foyerService;

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
