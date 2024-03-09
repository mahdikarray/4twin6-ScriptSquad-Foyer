package com.example.twinscriptsquadfoyer;

import com.example.twinscriptsquadfoyer.dao.repository.ChambreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class Twin6ScriptSquadFoyerApplicationTests {
    @Test
    void contextLoads() {
        assertNotNull("Context is not null", new Object());
    }

}
