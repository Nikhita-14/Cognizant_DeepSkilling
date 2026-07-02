import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise2Test {
    @Test
    public void testVerify() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();
        Mockito.verify(mockApi).getData(); // Verifies method was called
    }
}