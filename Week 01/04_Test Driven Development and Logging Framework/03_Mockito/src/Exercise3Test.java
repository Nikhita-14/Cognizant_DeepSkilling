import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise3Test {
    @Test
    public void testMatchers() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        Mockito.when(mockApi.processInput(Mockito.anyString())).thenReturn("Passed");

        assertEquals("Passed", service.handleInput("Any Text"));
    }
}