package com.example.twinscriptsquadfoyer;


import com.example.twinscriptsquadfoyer.dao.entity.Universite;
import com.example.twinscriptsquadfoyer.dao.service.IuniversiteService;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest
class UniversiteServiceTest {

    @Autowired
    private IuniversiteService  iuniversiteService;

    @Test
    void testAjouterUniversity() {
        Universite espritUniversite = Universite.builder()
                .nomUniversite("Esprit")
                .adresse("Ariana Soghra")
                .build();
        Universite savedUniversite = iuniversiteService.addUniversite(espritUniversite);
        Assertions.assertNotNull(savedUniversite);
    }

    @Test
    void testEditExistingUniversity() {
        // Assuming there is an existing University with ID 1 in the database
        long existingUniversityId = 2L;

        // Retrieve the existing University from the database
        Universite existingUniversity = iuniversiteService.findById(existingUniversityId);

        // Modify the existing University
        existingUniversity.setNomUniversite("Edited University Name");
        existingUniversity.setAdresse("Edited University Address");

        // Update the existing University in the database
        Universite updatedUniversity = iuniversiteService.editUniversite(existingUniversity);

        // Retrieve the updated University from the database for verification
        Universite retrievedUniversity= iuniversiteService.findById(existingUniversityId);

        // Assertions
        Assertions.assertNotNull(retrievedUniversity);
        Assertions.assertEquals("Edited University Name", retrievedUniversity.getNomUniversite());
        Assertions.assertEquals("Edited University Address", retrievedUniversity.getAdresse());
    }

    @Test
    void testFindExistingUniversity() {
        // Assuming there is an existing University with ID 1 in the database
        long existingUniversityId = 2L;

        // Retrieve the existing University from the database
        Universite existingUniversity = iuniversiteService.findById(existingUniversityId);

        // Assertions
        Assertions.assertNotNull(existingUniversity);
        // Add more assertions as needed to validate the existing University
    }

    @Test
    void testDeleteExistingUniversity() {
        // Assuming there is an existing University with ID 1 in the database
        long existingUniversityId = 1L;

        // Delete the existing University from the database
        iuniversiteService.deleteById(existingUniversityId);

        // Attempt to find the deleted University from the database
        Universite deletedUniversity = iuniversiteService.findById(existingUniversityId);

        // Assertion
        Assertions.assertNull(deletedUniversity);
    }
}
