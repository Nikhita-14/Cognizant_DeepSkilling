import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // 1. Assert Equals: Checks if the expected value matches the actual value
        assertEquals(5, 2 + 3);

        // 2. Assert True: Passes if the condition inside is true
        assertTrue(5>3);

        // 3. Assert False: Passes if the condition inside is false
        assertFalse(5<3);

        // 4. Assert Null: Passes if the object evaluates to null
        String name = null;
        assertNull(name);

        // 5. Assert Not Null: Passes if the object actually exists (is not null)
        Object obj = new Object();
        assertNotNull(obj);
    }
}