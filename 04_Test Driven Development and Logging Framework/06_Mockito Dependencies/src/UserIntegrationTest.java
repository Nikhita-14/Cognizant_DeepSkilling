import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest // Loads the full application context
@AutoConfigureMockMvc // Provides a fully functional MockMvc instance for integration routing
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // Replaces the real service with a mock inside the running application context
    private UserService userService;

    @Test
    public void testFullFlowWithMockedService() throws Exception {
        // Arrange
        User integrationMockUser = new User();
        integrationMockUser.setId(55L);
        integrationMockUser.setName("Integration Mock");

        Mockito.when(userService.getUserById(55L)).thenReturn(integrationMockUser);

        // Act & Assert
        mockMvc.perform(get("/users/55")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(55))
                .andExpect(jsonPath("$.name").value("Integration Mock"));
    }
}