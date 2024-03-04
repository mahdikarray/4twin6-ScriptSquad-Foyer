package com.example.twinscriptsquadfoyer;

import com.example.twinscriptsquadfoyer.dao.repository.ChambreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)
@SpringBootTest
class Twin6ScriptSquadFoyerApplicationTests {

    @Mock
    ChambreRepository chambreRepository;
    @Test
    void contextLoads() {

    }

}
