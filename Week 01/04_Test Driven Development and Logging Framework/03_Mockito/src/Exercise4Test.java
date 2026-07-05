import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise4Test {
    @Test
    public void testVoid() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.doLogging("Log Me");
        Mockito.verify(mockApi).logAction("Log Me");
    }
}