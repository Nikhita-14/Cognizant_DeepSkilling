import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 10, 12, 100})
    public void testIsEven(int input) {
        EvenChecker checker = new EvenChecker();
        assertTrue(checker.isEven(input));
    }
}