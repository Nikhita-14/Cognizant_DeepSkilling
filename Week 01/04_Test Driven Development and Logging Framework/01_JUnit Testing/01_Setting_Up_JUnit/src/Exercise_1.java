import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise_1 {
    @Test
    public void myFirstTestMethod() {
        int expected = 4;
        int actual = 2 + 2;

        // This checks if expected matches actual
        assertEquals(expected, actual);
    }
}
