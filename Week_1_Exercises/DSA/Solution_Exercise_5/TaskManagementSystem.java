class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    // Getters and setters (omitted for brevity)
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Not found
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task.getTaskName() + " (" + current.task.getStatus() + ")");
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            return; // Empty list
        }
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        tms.addTask(new Task(101, "Write report", "In progress"));
        tms.addTask(new Task(102, "Review code", "Pending"));

        Task foundTask = tms.searchTask(101);
        if (foundTask != null) {
            System.out.println("Found task: " + foundTask.getTaskName());
        } else {
            System.out.println("Task not found.");
        }

        tms.traverseTasks();

        tms.deleteTask(102);
        System.out.println("Remaining tasks:");
        tms.traverseTasks();
    }
}
