import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise1Test {

    @Test
    public void testExternalApi() {
        // 1. Create a mock object for the external API
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Explicitly stub the method call
        Mockito.when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Write a test case that uses the mock object
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Verify that our service correctly returned the stubbed value
        assertEquals("Mock Data", result);
    }
}