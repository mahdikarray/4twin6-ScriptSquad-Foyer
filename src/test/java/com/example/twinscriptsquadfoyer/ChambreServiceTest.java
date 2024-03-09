package com.example.twinscriptsquadfoyer;

import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.entity.Chambre;
import com.example.twinscriptsquadfoyer.dao.entity.TypeChambre;
import com.example.twinscriptsquadfoyer.dao.service.BlocService;
import com.example.twinscriptsquadfoyer.dao.service.ChambreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class ChambreServiceTest {

    @Autowired
    private ChambreService chambreService;

    @Autowired
    private BlocService blocService;

    @Test
    void testAjouterChambre() {
        Chambre sampleChambre = Chambre.builder()
                .numeroChambre(101)
                .typeChambre(TypeChambre.SIMPLE)
                .statut("AVAILABLE")
                .dateDebut(LocalDate.now())
                .dateFin(LocalDate.now().plusDays(7))
                .build();
        Chambre savedChambre = chambreService.addChambre(sampleChambre);
        Assertions.assertNotNull(savedChambre);
    }

    @Test
    void testEditExistingChambre() {
        // Assuming there is an existing chambre with ID 1 in the database
        Long existingChambreId = 2L;

        // Retrieve the existing chambre from the database
        Chambre existingChambre = chambreService.findById(existingChambreId);

        // Modify the existing chambre's numeroChambre
        existingChambre.setNumeroChambre(102);

        // Update the existing chambre in the database
        chambreService.editChambre(existingChambreId, existingChambre);

        // Retrieve the updated chambre from the database for verification
        Chambre updatedChambre = chambreService.findById(existingChambreId);

        // Assertions
        Assertions.assertNotNull(updatedChambre);
        Assertions.assertEquals(102, updatedChambre.getNumeroChambre());
    }

    @Test
    void testFindExistingChambre() {
        // Assuming there is an existing chambre with ID 1 in the database
        long existingChambreId = 2L;

        // Retrieve the existing chambre from the database
        Chambre existingChambre = chambreService.findById(existingChambreId);

        // Assertions
        Assertions.assertNotNull(existingChambre);
        // Add more assertions as needed to validate the existing chambre
    }

    @Test
    void testDeleteExistingChambre() {
        // Assuming there is an existing chambre with ID 1 in the database
        long existingChambreId = 2L;

        // Delete the existing chambre from the database
        chambreService.deleteById(existingChambreId);

        // Attempt to find the deleted chambre from the database
        Chambre deletedChambre = chambreService.findById(existingChambreId);

        // Assertion
        Assertions.assertNull(deletedChambre);
    }



}
