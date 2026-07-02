import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise7Test {
    @Test
    public void testException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        Mockito.doThrow(new RuntimeException("Err")).when(mockApi).criticalTask();

        assertThrows(RuntimeException.class, () -> service.executeCritical());
    }
}