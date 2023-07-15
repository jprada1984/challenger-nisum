package cl.nisum.challenger.userms;

import cl.nisum.challenger.userms.domain.entity.UserEntity;
import cl.nisum.challenger.userms.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IntegrationJpaTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void testFindById(){
        Optional<UserEntity> entity = userRepository.findById(UUID.fromString("37c7dcca-6260-4190-8792-7f1e41d756cb"));
        assertTrue(entity.isPresent());
        assertEquals("Anita Perez", entity.orElseThrow().getName());
    }

    @Test
    void testFindAll(){
        List<UserEntity>  users = userRepository.findAll();
        assertFalse(users.isEmpty());
        assertEquals(2, users.size());
    }


}
