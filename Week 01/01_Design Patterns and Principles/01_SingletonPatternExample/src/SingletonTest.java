public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");
        System.out.println("\n--- Verification Results ---");
        System.out.println("Logger 1 Hashcode: " + logger1.hashCode());
        System.out.println("Logger 2 Hashcode: " + logger2.hashCode());
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both variables reference the same Logger instance.");
        } else {
            System.out.println("FAILURE: Multiple Logger instances exist.");
        }
    }
}
