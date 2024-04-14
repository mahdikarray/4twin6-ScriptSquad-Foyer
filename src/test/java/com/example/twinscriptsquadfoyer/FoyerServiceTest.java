// package com.example.twinscriptsquadfoyer;

// import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
// import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
// import com.example.twinscriptsquadfoyer.dao.entity.Universite;
// import com.example.twinscriptsquadfoyer.dao.service.foyer.FoyerService;
// import com.example.twinscriptsquadfoyer.dao.service.foyer.IFoyerService;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.runner.RunWith;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.junit.jupiter.api.Test;

// import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
// import com.example.twinscriptsquadfoyer.dao.repository.FoyerRepository;
// import com.example.twinscriptsquadfoyer.dao.service.foyer.FoyerService;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.junit4.SpringRunner;

// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.mockito.ArgumentMatchers.any;


// @RunWith(SpringRunner.class)
// @SpringBootTest
// @ActiveProfiles("test")
//  class FoyerServiceTest {

//     @Mock
//     private FoyerRepository foyerRepository; // Mock the repository

//     @Mock
//     private IFoyerService iFoyerService; // Inject the mocked service
//     @InjectMocks
//     private FoyerServiceTest foyerServiceTest;

//     @BeforeEach
//     void setup() {
//         MockitoAnnotations.initMocks(this);
//     }

//     @Test
//     void testAjouterFoyer() {
//         Foyer sampleFoyer = Foyer.builder()
//                 .nomFoyer("Add Foyer")
//                 .capaciteFoyer(25)
//                 .build();

//         Mockito.when(iFoyerService.addFoyer(sampleFoyer)).thenReturn(sampleFoyer);

//         Foyer savedFoyer = iFoyerService.addFoyer(sampleFoyer);
//         Assertions.assertNotNull(savedFoyer);
//     }

//     @Test
//     void testFindFoyerById() {
//         Long existingFoyerId = 2L;
//         Foyer existingFoyer = Foyer.builder()
//                 .idFoyer(existingFoyerId)
//                 .nomFoyer("Found Foyer")
//                 .capaciteFoyer(25)
//                 .build();

//         Mockito.when(iFoyerService.findById(existingFoyerId)).thenReturn(existingFoyer);

//         existingFoyer.setNomFoyer("Edit Foyer");

//         Mockito.when(iFoyerService.editFoyer(existingFoyer)).thenReturn(existingFoyer);

//         iFoyerService.editFoyer(existingFoyer);

//         Foyer updatedFoyer = iFoyerService.findById(existingFoyerId);

//         Assertions.assertNotNull(updatedFoyer);
//         Assertions.assertEquals("Edit Foyer", updatedFoyer.getNomFoyer());
//     }


//     @Test
//     void  testDeleteFoyer() {
//         Long FoyerIdToDelete = 2L;

//         // Mock the behavior of findById and deleteById methods
//         Foyer existingFoyer = Foyer.builder()
//                 .idFoyer(FoyerIdToDelete)
//                 .nomFoyer("Existing Foyer")
//                 .capaciteFoyer(10)
//                 .build();
//         Mockito.when(iFoyerService.findById(FoyerIdToDelete)).thenReturn(existingFoyer);
//         Mockito.doNothing().when(iFoyerService).deleteById(FoyerIdToDelete);

//         // Delete the existing chambre from the database
//         iFoyerService.deleteById(FoyerIdToDelete);

//         // Verify that deleteById method was called with the correct ID
//         Mockito.verify(iFoyerService, Mockito.times(1)).deleteById(FoyerIdToDelete);

//         // Attempt to find the deleted chambre from the database
//         Foyer deletedFoyer = iFoyerService.findById(FoyerIdToDelete);

//         // Assertion
//         Assertions.assertNotNull(deletedFoyer);
//     }
//     @Test
//     void testEditFoyer() {
//         Long existingFoyerId = 2L;
//         Foyer existingFoyer = Foyer.builder()
//                 .idFoyer(existingFoyerId)
//                 .nomFoyer("Existing Foyer")
//                 .capaciteFoyer(20)
//                 .build();


//         Mockito.when(iFoyerService.findById(existingFoyerId)).thenReturn(existingFoyer);

//         existingFoyer.setNomFoyer("Name Updated");

//         Mockito.when(iFoyerService.editFoyer(existingFoyer)).thenReturn(existingFoyer);

//         iFoyerService.editFoyer(existingFoyer);

//         Foyer updatedFoyer = iFoyerService.findById(existingFoyerId);

//         Assertions.assertNotNull(updatedFoyer);
//         Assertions.assertEquals("Name Updated", updatedFoyer.getNomFoyer());
//     }

// }


import com.example.twinscriptsquadfoyer.dao.entity.Foyer;
import com.example.twinscriptsquadfoyer.dao.repository.FoyerRepository;
import com.example.twinscriptsquadfoyer.dao.service.foyer.FoyerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

class FoyerServiceTest {

    @Mock
    private FoyerRepository foyerRepository;

    @InjectMocks
    private FoyerService foyerService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAjouterFoyer() {
        Foyer sampleFoyer = Foyer.builder()
                .nomFoyer("Add Foyer")
                .capaciteFoyer(25)
                .build();

        Mockito.when(foyerRepository.save(any(Foyer.class))).thenReturn(sampleFoyer);

        Foyer savedFoyer = foyerService.addFoyer(sampleFoyer);
        assertNotNull(savedFoyer);
    }

    @Test
    void testFindFoyerById() {
        Long existingFoyerId = 2L;
        Foyer existingFoyer = Foyer.builder()
                .idFoyer(existingFoyerId)
                .nomFoyer("Found Foyer")
                .capaciteFoyer(25)
                .build();

        Mockito.when(foyerRepository.findById(existingFoyerId)).thenReturn(Optional.of(existingFoyer));

        Foyer foundFoyer = foyerService.findById(existingFoyerId);

        assertNotNull(foundFoyer);
        assertEquals("Found Foyer", foundFoyer.getNomFoyer());
    }

    @Test
    void testDeleteFoyer() {
        Long foyerIdToDelete = 2L;

        Foyer existingFoyer = Foyer.builder()
                .idFoyer(foyerIdToDelete)
                .nomFoyer("Existing Foyer")
                .capaciteFoyer(10)
                .build();
        Mockito.when(foyerRepository.findById(foyerIdToDelete)).thenReturn(Optional.of(existingFoyer));

        // Delete the existing foyer from the database
        foyerService.deleteById(foyerIdToDelete);

        // Verify that deleteById method was called with the correct ID
        Mockito.verify(foyerRepository, times(1)).deleteById(foyerIdToDelete);

        // Attempt to find the deleted foyer from the database
        Optional<Foyer> deletedFoyer = foyerRepository.findById(foyerIdToDelete);

        // Assertion
        assertFalse(deletedFoyer.isPresent());
    }

    @Test
    void testEditFoyer() {
        Long existingFoyerId = 2L;
        Foyer existingFoyer = Foyer.builder()
                .idFoyer(existingFoyerId)
                .nomFoyer("Existing Foyer")
                .capaciteFoyer(20)
                .build();


        Mockito.when(foyerRepository.findById(existingFoyerId)).thenReturn(Optional.of(existingFoyer));

        existingFoyer.setNomFoyer("Name Updated");

        Foyer updatedFoyer = foyerService.editFoyer(existingFoyer);

        assertNotNull(updatedFoyer);
        assertEquals("Name Updated", updatedFoyer.getNomFoyer());
    }

    @Test
    void testFindAllFoyers() {
        // Create sample foyers
        Foyer foyer1 = Foyer.builder()
                .nomFoyer("Foyer 1")
                .capaciteFoyer(30)
                .build();
        Foyer foyer2 = Foyer.builder()
                .nomFoyer("Foyer 2")
                .capaciteFoyer(40)
                .build();

        Mockito.when(foyerRepository.findAll()).thenReturn(List.of(foyer1, foyer2));

        // Retrieve all foyers
        List<Foyer> allFoyers = foyerService.findAll();

        // Assertions
        assertNotNull(allFoyers);
        assertEquals(2, allFoyers.size());
    }

    @Test
    void testAddFoyers() {
        // Create sample foyers
        Foyer foyer1 = Foyer.builder()
                .nomFoyer("Foyer 1")
                .capaciteFoyer(30)
                .build();
        Foyer foyer2 = Foyer.builder()
                .nomFoyer("Foyer 2")
                .capaciteFoyer(40)
                .build();

        Mockito.when(foyerRepository.saveAll(any())).thenReturn(List.of(foyer1, foyer2));

        // Add foyers
        List<Foyer> addedFoyers = foyerService.addFoyers(List.of(foyer1, foyer2));

        // Assertions
        assertNotNull(addedFoyers);
        assertEquals(2, addedFoyers.size());
    }
}


/*@SpringBootTest
class FoyerServiceTest {
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
}*/
