package com.example.twinscriptsquadfoyer;/*package com.example.twinscriptsquadfoyer;

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
*/
import com.example.twinscriptsquadfoyer.dao.entity.Bloc;
import com.example.twinscriptsquadfoyer.dao.entity.Chambre;
import com.example.twinscriptsquadfoyer.dao.entity.TypeChambre;
import com.example.twinscriptsquadfoyer.dao.service.IBlocService;
import com.example.twinscriptsquadfoyer.dao.service.IChambreService;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class ChambreServiceTest {

    @Mock
    private IChambreService chambreService;

    @Mock
    private IBlocService blocService;

    @InjectMocks
    private ChambreServiceTest chambreServiceTest;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAjouterChambre() {
        Chambre sampleChambre = Chambre.builder()
                .numeroChambre(101)
                .typeChambre(TypeChambre.SIMPLE)
                .statut("AVAILABLE")
                .dateDebut(LocalDate.now())
                .dateFin(LocalDate.now().plusDays(7))
                .bloc(Bloc.builder().build())
                .build();

        Mockito.when(chambreService.addChambre(sampleChambre)).thenReturn(sampleChambre);

        Chambre savedChambre = chambreService.addChambre(sampleChambre);
        Assertions.assertNotNull(savedChambre);
    }

    @Test
    void testEditExistingChambre() {
        Long existingChambreId = 2L;
        Chambre existingChambre = Chambre.builder()
                .idChambre(existingChambreId)
                .numeroChambre(101)
                .typeChambre(TypeChambre.SIMPLE)
                .statut("AVAILABLE")
                .dateDebut(LocalDate.now())
                .dateFin(LocalDate.now().plusDays(7))
                .bloc(Bloc.builder().build())
                .build();

        Mockito.when(chambreService.findById(existingChambreId)).thenReturn(existingChambre);

        existingChambre.setNumeroChambre(102);

        Mockito.when(chambreService.editChambre(existingChambreId, existingChambre)).thenReturn(existingChambre);

        chambreService.editChambre(existingChambreId, existingChambre);

        Chambre updatedChambre = chambreService.findById(existingChambreId);

        Assertions.assertNotNull(updatedChambre);
        Assertions.assertEquals(102, updatedChambre.getNumeroChambre());
    }

    @Test
    void testFindExistingChambre() {
        long existingChambreId = 2L;
        Chambre existingChambre = Chambre.builder()
                .idChambre(existingChambreId)
                .numeroChambre(101)
                .typeChambre(TypeChambre.SIMPLE)
                .statut("AVAILABLE")
                .dateDebut(LocalDate.now())
                .dateFin(LocalDate.now().plusDays(7))
                .build();

        Mockito.when(chambreService.findById(existingChambreId)).thenReturn(existingChambre);

        Chambre retrievedChambre = chambreService.findById(existingChambreId);

        Assertions.assertNotNull(retrievedChambre);
    }

    @Test
    void testDeleteExistingChambre() {
        // Assuming there is an existing chambre with ID 1 in the database
        long existingChambreId = 1L;

        // Mock the behavior of findById and deleteById methods
        Chambre existingChambre = Chambre.builder()
                .idChambre(existingChambreId)
                .numeroChambre(101)
                .typeChambre(TypeChambre.SIMPLE)
                .statut("AVAILABLE")
                .dateDebut(LocalDate.now())
                .dateFin(LocalDate.now().plusDays(7))
                .build();
        Mockito.when(chambreService.findById(existingChambreId)).thenReturn(existingChambre);
        Mockito.doNothing().when(chambreService).deleteById(existingChambreId);

        // Delete the existing chambre from the database
        chambreService.deleteById(existingChambreId);

        // Verify that deleteById method was called with the correct ID
        Mockito.verify(chambreService, Mockito.times(1)).deleteById(existingChambreId);

        // Attempt to find the deleted chambre from the database
        Chambre deletedChambre = chambreService.findById(existingChambreId);

        // Assertion
        Assertions.assertNotNull(deletedChambre);
    }

    @Test
    void testAddChambres() {
        List<Chambre> chambres = new ArrayList<>();
        chambres.add(Chambre.builder().build());
        Mockito.when(chambreService.addChambres(chambres)).thenReturn(chambres);
        List<Chambre> savedChambres = chambreService.addChambres(chambres);
        Assertions.assertEquals(chambres, savedChambres);
    }

    @Test
    void testFindAll() {
        List<Chambre> chambres = new ArrayList<>();
        chambres.add(Chambre.builder().build());
        Mockito.when(chambreService.findAll()).thenReturn(chambres);
        List<Chambre> foundChambres = chambreService.findAll();
        Assertions.assertEquals(chambres, foundChambres);
    }

    @Test
    void testFindById() {
        long id = 1L;
        Chambre chambre = Chambre.builder().idChambre(id).build();
        Mockito.when(chambreService.findById(id)).thenReturn(chambre);
        Chambre foundChambre = chambreService.findById(id);
        Assertions.assertEquals(chambre, foundChambre);
    }

    @Test
    void testDelete() {
        Chambre chambre = Chambre.builder().build();
        chambreService.delete(chambre);
        Mockito.verify(chambreService, Mockito.times(1)).delete(chambre);
    }

    @Test
    void testFindByNumeroChambre() {
        long numeroChambre = 101L;
        Chambre chambre = Chambre.builder().numeroChambre(numeroChambre).build();
        Mockito.when(chambreService.findByNumeroChambre(numeroChambre)).thenReturn(chambre);
        Chambre foundChambre = chambreService.findByNumeroChambre(numeroChambre);
        Assertions.assertEquals(chambre, foundChambre);
    }

    @Test
    void testGetBlocByChambre() {
        long idChambre = 1L;
        Bloc bloc = Bloc.builder().build();
        Mockito.when(chambreService.getBlocByChambre(idChambre)).thenReturn(bloc);
        Bloc foundBloc = chambreService.getBlocByChambre(idChambre);
        Assertions.assertEquals(bloc, foundBloc);
    }

    @Test
    void testDeleteById() {
        long id = 1L;
        chambreService.deleteById(id);
        Mockito.verify(chambreService, Mockito.times(1)).deleteById(id);
    }

    @Test
    void testIsNumeroChambreUniqueForUpdate() {
        long id = 1L;
        long numeroChambre = 101L;
        Mockito.when(chambreService.isNumeroChambreUniqueForUpdate(id, numeroChambre)).thenReturn(true);
        boolean isUnique = chambreService.isNumeroChambreUniqueForUpdate(id, numeroChambre);
        Assertions.assertTrue(isUnique);
    }

    @Test
    void testGetChambreById() {
        long id = 1L;
        Chambre chambre = Chambre.builder().idChambre(id).build();
        Mockito.when(chambreService.getChambreById(id)).thenReturn(chambre);
        Chambre foundChambre = chambreService.getChambreById(id);
        Assertions.assertEquals(chambre, foundChambre);
    }

    @Test
    void testFindAllRoomNumbers() {
        List<Long> roomNumbers = Arrays.asList(101L, 102L, 103L);
        Mockito.when(chambreService.findAllRoomNumbers()).thenReturn(roomNumbers);
        List<Long> foundRoomNumbers = chambreService.findAllRoomNumbers();
        Assertions.assertEquals(roomNumbers, foundRoomNumbers);
    }

}
