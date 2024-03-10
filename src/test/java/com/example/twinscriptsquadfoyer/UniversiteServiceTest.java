package com.example.twinscriptsquadfoyer;


import com.example.twinscriptsquadfoyer.dao.entity.Universite;
import com.example.twinscriptsquadfoyer.dao.repository.UniversiteRepo;
import com.example.twinscriptsquadfoyer.dao.service.UniversiteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class UniversiteServiceTest {

    @Mock
    private UniversiteRepo universiteRepo; // Mock the repository

    @InjectMocks
    private UniversiteService universiteService ; // Inject the mocked service

    @Test
    void testAjouterUniversity() {
        // Create a sample University
        Universite espritUniversity = Universite.builder()
                .nomUniversite("Esprit")
                .adresse("Ariana Soghra")
                .build();

        // Mock the behavior of the repository save method
        Mockito.when(universiteRepo.save(any(Universite.class)))
                .thenReturn(espritUniversity);

        // Add the University
        Universite savedUniversite = universiteService.addUniversite(espritUniversity);

        // Verify that the University has been added
        assertEquals("Esprit", savedUniversite.getNomUniversite());
        assertEquals("Ariana Soghra", savedUniversite.getAdresse());

        // Clean up (optional):
        // universiteService.deleteById(savedUniversite.getIdUniversite());
    }

    @Test
    void testFindUniversityById() {
        long universityIdToFind = 1L;

        // Mock the behavior of the repository findById method
        Mockito.when(universiteRepo.findById(universityIdToFind))
                .thenReturn(Optional.of(Universite.builder()
                        .idUniversite(universityIdToFind)
                        .nomUniversite("Found University")
                        .adresse("Found Address")
                        .build()));

        // Find the University
        Universite foundUniversity = universiteService.findById(universityIdToFind);


        assertEquals("Found University", foundUniversity.getNomUniversite());
        assertEquals("Found Address", foundUniversity.getAdresse());
    }

    @Test
    void testDeleteUniversity() {
        long UniversityIdToDelete = 1L;

        universiteService.deleteById(UniversityIdToDelete);

        Mockito.verify(universiteRepo).deleteById(UniversityIdToDelete);
    }
    @Test
    void testEditUniversity() {
        Universite existingUniversity = Universite.builder()
                .idUniversite(1L)
                .nomUniversite("Existing University")
                .adresse("Existing Address")
                .build();
        Mockito.when(universiteRepo.findById(1L))
                .thenReturn(Optional.of(existingUniversity));
        Mockito.when(universiteRepo.save(any(Universite.class)))
                .thenReturn(existingUniversity);
        Universite updatedUniversity = universiteService.editUniversite(existingUniversity);
        assertEquals("Existing University", updatedUniversity.getNomUniversite());
        assertEquals("Existing Address", updatedUniversity.getAdresse());
    }

}



//import com.example.twinscriptsquadfoyer.dao.entity.Universite;
//import com.example.twinscriptsquadfoyer.dao.service.IuniversiteService;
//import org.junit.jupiter.api.Assertions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.jupiter.api.Test;
//
//@SpringBootTest
//class UniversiteServiceTest {
//
//    @Autowired
//    private IuniversiteService  iuniversiteService;
//
//    @Test
//    void testAjouterUniversity() {
//        Universite espritUniversite = Universite.builder()
//                .nomUniversite("Esprit")
//                .adresse("Ariana Soghra")
//                .build();
//        Universite savedUniversite = iuniversiteService.addUniversite(espritUniversite);
//        Assertions.assertNotNull(savedUniversite);
//    }
//
//    @Test
//    void testEditExistingUniversity() {
//        // Assuming there is an existing University with ID 1 in the database
//        long existingUniversityId = 2L;
//
//        // Retrieve the existing University from the database
//        Universite existingUniversity = iuniversiteService.findById(existingUniversityId);
//
//        // Modify the existing University
//        existingUniversity.setNomUniversite("Edited University Name");
//        existingUniversity.setAdresse("Edited University Address");
//
//        // Update the existing University in the database
//        Universite updatedUniversity = iuniversiteService.editUniversite(existingUniversity);
//
//        // Retrieve the updated University from the database for verification
//        Universite retrievedUniversity= iuniversiteService.findById(existingUniversityId);
//
//        // Assertions
//        Assertions.assertNotNull(retrievedUniversity);
//        Assertions.assertEquals("Edited University Name", retrievedUniversity.getNomUniversite());
//        Assertions.assertEquals("Edited University Address", retrievedUniversity.getAdresse());
//    }
//
//    @Test
//    void testFindExistingUniversity() {
//        // Assuming there is an existing University with ID 1 in the database
//        long existingUniversityId = 2L;
//
//        // Retrieve the existing University from the database
//        Universite existingUniversity = iuniversiteService.findById(existingUniversityId);
//
//        // Assertions
//        Assertions.assertNotNull(existingUniversity);
//        // Add more assertions as needed to validate the existing University
//    }
//
//    @Test
//    void testDeleteExistingUniversity() {
//        // Assuming there is an existing University with ID 1 in the database
//        long existingUniversityId = 1L;
//
//        // Delete the existing University from the database
//        iuniversiteService.deleteById(existingUniversityId);
//
//        // Attempt to find the deleted University from the database
//        Universite deletedUniversity = iuniversiteService.findById(existingUniversityId);
//
//        // Assertion
//        Assertions.assertNull(deletedUniversity);
//    }
//}
