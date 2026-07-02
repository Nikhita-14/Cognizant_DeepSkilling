public interface ExternalApi {
    String getData();
    String processInput(String input);
    void logAction(String message);
    void criticalTask();
}