import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    @Test
    public void testTimeout() {
        PerformanceTester tester = new PerformanceTester();

        assertTimeout(Duration.ofSeconds(1), () -> {
            tester.performTask();
        });
    }
}