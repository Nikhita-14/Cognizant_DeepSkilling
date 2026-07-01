import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class FixturesTest {

    // This variable is accessible by all your test methods
    private ArrayList<String> list;

    // SETUP METHOD: Runs automatically BEFORE every single individual @Test method
    @Before
    public void setUp() {
        list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        System.out.println("Setup executed: Fresh list created with 2 items.");
    }

    // TEARDOWN METHOD: Runs automatically AFTER every single individual @Test method
    @After
    public void tearDown() {
        list.clear();
        System.out.println("Teardown executed: List cleared out.");
    }

    // A test using the AAA (Arrange, Act, Assert) Pattern
    @Test
    public void testListAddition() {
        // 1. ARRANGE: Setting up the specific data needed for this test
        String newItem = "Orange";

        // 2. ACT: Executing the actual action/behavior you want to test
        list.add(newItem);

        // 3. ASSERT: Verifying that the outcome matches expectations
        assertEquals(3, list.size());
        assertTrue(list.contains("Orange"));
    }

    @Test
    public void testListRemoval() {
        // 1. ARRANGE: No extra setup needed because @Before already added Apple and Banana

        // 2. ACT: Perform the action
        list.remove("Apple");

        // 3. ASSERT: Verify the outcome
        assertEquals(1, list.size());
        assertFalse(list.contains("Apple"));
    }
}