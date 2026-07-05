public class MyService {
    private ExternalApi api;

    // Constructor that accepts our mock API
    public MyService(ExternalApi api) {
        this.api = api;
    }

    // Method for Exercise 1, 2, and 5
    public String fetchData() {
        return api.getData();
    }

    // Method for Exercise 3
    public String handleInput(String input) {
        return api.processInput(input);
    }

    // Method for Exercise 4 and 6
    public void doLogging(String msg) {
        api.logAction(msg);
    }

    // Method for Exercise 7
    public void executeCritical() {
        api.criticalTask();
    }
}