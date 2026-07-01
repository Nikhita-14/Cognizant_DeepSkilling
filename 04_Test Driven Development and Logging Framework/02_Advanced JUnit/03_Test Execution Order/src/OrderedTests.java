import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    public void firstTest() {
        System.out.println("Running Step 1: Initialize");
    }

    @Test
    @Order(2)
    public void secondTest() {
        System.out.println("Running Step 2: Process");
    }

    @Test
    @Order(3)
    public void thirdTest() {
        System.out.println("Running Step 3: Clean up");
    }
}