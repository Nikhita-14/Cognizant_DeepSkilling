import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class Exercise6Test {
    @Test
    public void testOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();
        service.doLogging("End");

        InOrder inOrder = Mockito.inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).logAction("End");
    }
}