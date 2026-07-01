import org.junit.Test;
import static org.junit.Assert.*;


public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();

        // Test if 5 + 3 equals 8
        int result = calc.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    public void testIsEven() {
        Calculator calc = new Calculator();

        // Test a known even number (should return true)
        assertTrue(calc.isEven(4));

        // Test a known odd number (should return false)
        assertFalse(calc.isEven(7));
    }
}