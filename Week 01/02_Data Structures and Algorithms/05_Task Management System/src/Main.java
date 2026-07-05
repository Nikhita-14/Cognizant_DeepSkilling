public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        System.out.println("--- Adding Tasks ---");
        taskList.add(new Task("T001", "Database Setup", "Completed"));
        taskList.add(new Task("T002", "API Development", "In Progress"));
        taskList.add(new Task("T003", "UI Mockups", "Pending"));
        taskList.traverse();

        System.out.println("\n--- Searching for Task T002 ---");
        Task found = taskList.search("T002");
        if (found != null) {
            System.out.println("Found: " + found.getTaskName() + " (" + found.getStatus() + ")");
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\n--- Deleting Task T002 ---");
        taskList.delete("T002");

        System.out.println("\n--- Final Task Records ---");
        taskList.traverse();
    }
}