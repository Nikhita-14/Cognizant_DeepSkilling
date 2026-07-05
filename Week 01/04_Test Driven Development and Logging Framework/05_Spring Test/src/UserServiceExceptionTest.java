import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class UserServiceExceptionTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserByIdNotFound() {
        // Return empty optional simulating a missing entry
        Mockito.when(userRepository.findById(404L)).thenReturn(Optional.empty());

        User result = userService.getUserById(404L);

        // Asserts orElse(null) logic processes correctly
        assertNull(result);
    }
}