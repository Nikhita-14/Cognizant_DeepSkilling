import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "DCSekhar";
        int loginAttempts = 3;

        // 1. Single parameter logging
        logger.info("User logged in: {}", username);

        // 2. Multiple parameters logging
        logger.warn("User {} failed login attempt #{}", username, loginAttempts);

        // 3. Exception logging (The exception stack trace is automatically appended if it's the last parameter)
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("An error occurred during calculation for user {}: ", username, e);
        }
    }
}