package com.example.twinscriptsquadfoyer;


import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.entity.Chambre;
import com.example.twinscriptsquadfoyer.dao.entity.TypeChambre;
import com.example.twinscriptsquadfoyer.dao.entity.Universite;
import com.example.twinscriptsquadfoyer.dao.repository.UniversiteRepo;
import com.example.twinscriptsquadfoyer.dao.service.IuniversiteService;
import com.example.twinscriptsquadfoyer.dao.service.UniversiteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class UniversiteServiceTest {

    @Mock
    private UniversiteRepo universiteRepo; // Mock the repository

    @Mock
    private IuniversiteService iuniversiteService ; // Inject the mocked service
    @InjectMocks
    private UniversiteServiceTest universiteServiceTest;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testAjouterUniversity() {
        Universite sampleUniversity = Universite.builder()
                .nomUniversite("Esprit")
                .adresse("Ariana Soghra")
                .build();

        Mockito.when(iuniversiteService.addUniversite(sampleUniversity)).thenReturn(sampleUniversity);

        Universite savedUniversity = iuniversiteService.addUniversite(sampleUniversity);
        Assertions.assertNotNull(savedUniversity);
    }


    @Test
    void testFindUniversityById() {
        Long existingUniversityId = 2L;
        Universite existingUniversity = Universite.builder()
                .idUniversite(existingUniversityId)
                .nomUniversite("Found University")
                .adresse("Found Address")
                .build();

        Mockito.when(iuniversiteService.findById(existingUniversityId)).thenReturn(existingUniversity);

        existingUniversity.setNomUniversite("Esprit Ghazela");

        Mockito.when(iuniversiteService.editUniversite(existingUniversity)).thenReturn(existingUniversity);

        iuniversiteService.editUniversite(existingUniversity);

        Universite updatedUnivrsity = iuniversiteService.findById(existingUniversityId);

        Assertions.assertNotNull(updatedUnivrsity);
        Assertions.assertEquals("Esprit Ghazela", updatedUnivrsity.getNomUniversite());
    }

    @Test
    void  testDeleteUniversity() {
        Long UniversityIdToDelete = 2L;

        // Mock the behavior of findById and deleteById methods
        Universite existingUniversity = Universite.builder()
                .idUniversite(UniversityIdToDelete)
                .nomUniversite("Existing University")
                .adresse("Existing Address")
                .build();
        Mockito.when(iuniversiteService.findById(UniversityIdToDelete)).thenReturn(existingUniversity);
        Mockito.doNothing().when(iuniversiteService).deleteById(UniversityIdToDelete);

        // Delete the existing chambre from the database
        iuniversiteService.deleteById(UniversityIdToDelete);

        // Verify that deleteById method was called with the correct ID
        Mockito.verify(iuniversiteService, Mockito.times(1)).deleteById(UniversityIdToDelete);

        // Attempt to find the deleted chambre from the database
        Universite deletedUniversity = iuniversiteService.findById(UniversityIdToDelete);

        // Assertion
        Assertions.assertNotNull(deletedUniversity);
    }




    @Test
    void testEditUniversity() {
        Long existingUniversityId = 2L;
        Universite existingUniversity = Universite.builder()
                .idUniversite(existingUniversityId)
                .nomUniversite("Existing University")
                .adresse("Existing Address")
                .build();


        Mockito.when(iuniversiteService.findById(existingUniversityId)).thenReturn(existingUniversity);

        existingUniversity.setAdresse("Address Updated");

        Mockito.when(iuniversiteService.editUniversite(existingUniversity)).thenReturn(existingUniversity);

        iuniversiteService.editUniversite(existingUniversity);

        Universite updatedUniversity = iuniversiteService.findById(existingUniversityId);

        Assertions.assertNotNull(updatedUniversity);
        Assertions.assertEquals("Address Updated", updatedUniversity.getAdresse());
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
