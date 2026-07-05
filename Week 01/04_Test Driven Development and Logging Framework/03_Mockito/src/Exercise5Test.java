import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise5Test {
    @Test
    public void testConsecutive() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        Mockito.when(mockApi.getData()).thenReturn("A").thenReturn("B");

        assertEquals("A", service.fetchData());
        assertEquals("B", service.fetchData());
    }
}