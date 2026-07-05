public class TaskLinkedList {
    private class Node {
        Task task;
        Node next;
        Node(Task task) { this.task = task; }
    }

    private Node head;

    public void add(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Task search(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equals(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.task.getTaskId() + " | Task: " + temp.task.getTaskName() + " | Status: " + temp.task.getStatus());
            temp = temp.next;
        }
    }

    public void delete(String taskId) {
        if (head == null) return;

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && !temp.next.task.getTaskId().equals(taskId)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
}