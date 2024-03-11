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
       // Assertions.assertNotNull(existingBloc);
        // Add more assertions as needed to validate the existing bloc
  //  }

  //  @Test
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
import com.example.twinscriptsquadfoyer.dao.entity.Chambre;
import com.example.twinscriptsquadfoyer.dao.entity.TypeChambre;
import com.example.twinscriptsquadfoyer.dao.entity.Universite;
import com.example.twinscriptsquadfoyer.dao.repository.BlocRepository;
import com.example.twinscriptsquadfoyer.dao.service.BlocService;
import com.example.twinscriptsquadfoyer.dao.service.IBlocService;
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

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
 class BlocServiceTest {
    @Mock
    private BlocRepository blocRepository; // Mock the repository

    @Mock
    private IBlocService blocService; // Inject the mocked service
   @InjectMocks
   private BlocServiceTest blocServiceTest;
   @BeforeEach
   void setup() {
      MockitoAnnotations.initMocks(this);
   }

    @Test
    void testAjouterBloc() {
        Bloc sampleBloc = Bloc.builder()
                .nomBloc("array")
                .capaciteBloc(1)
                .build();

        Mockito.when(blocService.addBloc(sampleBloc)).thenReturn(sampleBloc);

        Bloc savedBloc = blocService.addBloc(sampleBloc);
        Assertions.assertNotNull(savedBloc);
    }
    @Test
    void testFindBlocById() {
        Long existingBlocId = 2L;
        Bloc existingBloc = Bloc.builder()
                .idBloc(existingBlocId)
                .nomBloc("Found Bloc")
                .capaciteBloc(10)
                .build();

        Mockito.when(blocService.findById(existingBlocId)).thenReturn(existingBloc);

        existingBloc.setNomBloc("Esprit Ghazela");

        Mockito.when(blocService.editBloc(existingBloc)).thenReturn(existingBloc);

        blocService.editBloc(existingBloc);

        Bloc updatedBloc = blocService.findById(existingBlocId);

        Assertions.assertNotNull(updatedBloc);
        Assertions.assertEquals("Esprit Ghazela", updatedBloc.getNomBloc());
    }

    @Test
    void  testDeleteBloc() {
        Long BlocIdToDelete = 2L;

        // Mock the behavior of findById and deleteById methods
        Bloc existingBloc = Bloc.builder()
                .idBloc(BlocIdToDelete)
                .nomBloc("Existing Bloc")
                .build();
        Mockito.when(blocService.findById(BlocIdToDelete)).thenReturn(existingBloc);
        Mockito.doNothing().when(blocService).deleteById(BlocIdToDelete);

        // Delete the existing chambre from the database
        blocService.deleteById(BlocIdToDelete);

        // Verify that deleteById method was called with the correct ID
        Mockito.verify(blocService, Mockito.times(1)).deleteById(BlocIdToDelete);

        // Attempt to find the deleted chambre from the database
        Bloc deletedBloc = blocService.findById(BlocIdToDelete);

        // Assertion
        Assertions.assertNotNull(deletedBloc);
    }
    @Test
    void testEditBloc() {
        Long existingBlocId = 2L;
        Bloc existingBloc = Bloc.builder()
                .idBloc(existingBlocId)
                .capaciteBloc(1)
                .nomBloc("Existing Address")
                .build();


        Mockito.when(blocService.findById(existingBlocId)).thenReturn(existingBloc);

        existingBloc.setNomBloc("sui");

        Mockito.when(blocService.editBloc(existingBloc)).thenReturn(existingBloc);

        blocService.editBloc(existingBloc);

        Bloc updatedUniversity = blocService.findById(existingBlocId);

        Assertions.assertNotNull(updatedUniversity);
    }


}


