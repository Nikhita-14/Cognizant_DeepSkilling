import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {

    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.info("Application context initialized.");
        logger.debug("Processing business logic step 1...");
        logger.warn("System resources are slightly elevated.");
        logger.error("Failed to connect to secondary service placeholder.");

        System.out.println("--- Check your project root directory for 'app.log'! ---");
    }
}