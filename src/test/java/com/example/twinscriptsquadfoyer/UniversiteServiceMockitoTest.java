package com.example.twinscriptsquadfoyer;

import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.entity.Chambre;
import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
import com.example.twinscriptsquadfoyer.dao.entity.Universite;
import com.example.twinscriptsquadfoyer.dao.repository.UniversiteRepo;
import com.example.twinscriptsquadfoyer.dao.service.IuniversiteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class UniversiteServiceMockitoTest {


    @Mock
    private UniversiteRepo universiteRepo; // Mock the repository

    @Mock
    private IuniversiteService iuniversiteService ; // Inject the mocked service
    @InjectMocks
    private UniversiteServiceMockitoTest universiteServiceMockitoTest;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testAjouterUniversity() {
        Universite sampleUniversity = Universite.builder()
                .nomUniversite("Esprit")
                .adresse("Ariana Soghra")
                .foyer(Foyer.builder().build())
                .build();

        Mockito.when(iuniversiteService.addUniversite(sampleUniversity)).thenReturn(sampleUniversity);

        Universite savedUniversity = iuniversiteService.addUniversite(sampleUniversity);
        Assertions.assertNotNull(savedUniversity);

    }

    @Test
    void testAddUniversities() {
        List<Universite> universites = new ArrayList<>();
        universites.add(Universite.builder().build());
        Mockito.when(iuniversiteService.addUniversites(universites)).thenReturn(universites);
        List<Universite> savedUniversities = iuniversiteService.addUniversites(universites);
        Assertions.assertEquals(universites, savedUniversities);
    }


    @Test
    void testFindUniversityById() {
        long id = 1L;
        Universite universite = Universite.builder().idUniversite(id).build();
        Mockito.when(iuniversiteService.findById(id)).thenReturn(universite);
        Universite foundUniversity = iuniversiteService.findById(id);
        Assertions.assertEquals(universite, foundUniversity);
    }

    @Test
    void testDelete() {
        Universite universite = Universite.builder().build();
        iuniversiteService.delete(universite);
        Mockito.verify(iuniversiteService, Mockito.times(1)).delete(universite);
    }

    @Test
    void testDeleteById() {
        long id = 1L;
        iuniversiteService.deleteById(id);
        Mockito.verify(iuniversiteService, Mockito.times(1)).deleteById(id);
    }

    @Test
    void  testDeleteExistingUniversity() {
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
        long existingUniversityId = 2L;
        Universite existingUniversity = Universite.builder()
                .idUniversite(existingUniversityId)
                .nomUniversite("Existing University")
                .adresse("Existing Address")
                .foyer(Foyer.builder().build())
                .build();


        Mockito.when(iuniversiteService.findById(existingUniversityId)).thenReturn(existingUniversity);

        existingUniversity.setAdresse("Address Updated");

        Mockito.when(iuniversiteService.editUniversite(existingUniversityId, existingUniversity)).thenReturn(existingUniversity);

        iuniversiteService.editUniversite(existingUniversityId, existingUniversity);

        Universite updatedUniversity = iuniversiteService.findById(existingUniversityId);

        Assertions.assertNotNull(updatedUniversity);
        Assertions.assertEquals("Address Updated", updatedUniversity.getAdresse());
    }

    @Test
    void testFindAll() {
        List<Universite> universites = new ArrayList<>();
        universites.add(Universite.builder().build());
        Mockito.when(iuniversiteService.findAll()).thenReturn(universites);
        List<Universite> foundUniversities = iuniversiteService.findAll();
        Assertions.assertEquals(universites, foundUniversities);
    }

    @Test
    void testFindByAddress() {
        String addressUniversity = "Ariana Soghra";
        Universite universite = Universite.builder().adresse(addressUniversity).build();
        Mockito.when(iuniversiteService.getByAdresse(addressUniversity)).thenReturn(universite);
        Universite foundUniversity = iuniversiteService.getByAdresse(addressUniversity);
        Assertions.assertEquals(universite, foundUniversity);
    }

    @Test
    void testGetFoyerByUniversity() {
        long idUniversity = 1L;
        Foyer foyer = Foyer.builder().build();
        Mockito.when(iuniversiteService.getFoyerByUniversity(idUniversity)).thenReturn(foyer);
        Foyer foundFoyer = iuniversiteService.getFoyerByUniversity(idUniversity);
        Assertions.assertEquals(foyer, foundFoyer);
    }
}
