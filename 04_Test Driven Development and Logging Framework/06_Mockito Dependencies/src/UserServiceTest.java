import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class) // Initializes mocks without booting up Spring
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks // Automatically injects the mocked userRepository into this service instance
    private UserService userService;

    @Test
    public void testGetUserById() {
        // Arrange
        User mockUser = new User();
        mockUser.setId(10L);
        mockUser.setName("Alice Smith");

        Mockito.when(userRepository.findById(10L)).thenReturn(Optional.of(mockUser));

        // Act
        User result = userService.getUserById(10L);

        // Assert
        assertNotNull(result);
        assertEquals(10L, result.getId());
        assertEquals("Alice Smith", result.getName());
    }
}