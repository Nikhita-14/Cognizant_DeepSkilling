import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.NoSuchElementException;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(UserController.class)
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testHandleNotFoundException() throws Exception {
        // Force the service to throw the target exception when called
        Mockito.when(userService.getUserById(500L)).thenThrow(new NoSuchElementException("Not Found"));

        mockMvc.perform(get("/users/500"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }
}