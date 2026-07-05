import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user = new User();
        user.setId(5L);
        user.setName("Charlie");
        userRepository.save(user);

        List<User> result = userRepository.findByName("Charlie");

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("Charlie", result.get(0).getName());
    }
}