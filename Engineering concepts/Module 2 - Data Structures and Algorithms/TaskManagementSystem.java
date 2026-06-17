// Main Class
public class TaskManagementSystem {

    // Node Class (Task)
    static class Task {

        private int taskId;
        private String taskName;
        private String status;
        private Task next;

        public Task(int taskId,
                    String taskName,
                    String status) {

            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
            this.next = null;
        }

        @Override
        public String toString() {

            return "Task ID: " + taskId +
                   ", Task Name: " + taskName +
                   ", Status: " + status;
        }
    }

    // Head of Linked List
    private Task head;

    public TaskManagementSystem() {
        head = null;
    }

    // Add Task
    public void addTask(int taskId,
                        String taskName,
                        String status) {

        Task newTask =
                new Task(taskId,
                         taskName,
                         status);

        if (head == null) {

            head = newTask;
        }
        else {

            Task current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newTask;
        }

        System.out.println(
                "Task Added Successfully.");
    }

    // Search Task
    public Task searchTask(int taskId) {

        Task current = head;

        while (current != null) {

            if (current.taskId == taskId) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    // Traverse Tasks
    public void displayTasks() {

        if (head == null) {

            System.out.println(
                    "No Tasks Available.");

            return;
        }

        System.out.println(
                "\nCurrent Task List:");

        Task current = head;

        while (current != null) {

            System.out.println(current);

            current = current.next;
        }
    }

    // Delete Task
    public void deleteTask(int taskId) {

        if (head == null) {

            System.out.println(
                    "Task List is Empty.");

            return;
        }

        // Delete first node
        if (head.taskId == taskId) {

            head = head.next;

            System.out.println(
                    "Task Deleted Successfully.");

            return;
        }

        Task current = head;

        while (current.next != null &&
               current.next.taskId != taskId) {

            current = current.next;
        }

        if (current.next == null) {

            System.out.println(
                    "Task Not Found.");
        }
        else {

            current.next = current.next.next;

            System.out.println(
                    "Task Deleted Successfully.");
        }
    }

    public static void main(String[] args) {

        TaskManagementSystem taskManager =
                new TaskManagementSystem();

        // Add Tasks
        taskManager.addTask(
                101,
                "Design Database",
                "Pending");

        taskManager.addTask(
                102,
                "Develop API",
                "In Progress");

        taskManager.addTask(
                103,
                "Frontend Development",
                "Pending");

        taskManager.addTask(
                104,
                "Testing",
                "Not Started");

        // Display Tasks
        taskManager.displayTasks();

        // Search Task
        System.out.println(
                "\nSearching Task ID 102...");

        Task task =
                taskManager.searchTask(102);

        if (task != null) {

            System.out.println(
                    "Task Found:");

            System.out.println(task);
        }
        else {

            System.out.println(
                    "Task Not Found.");
        }

        // Delete Task
        System.out.println(
                "\nDeleting Task ID 103...");

        taskManager.deleteTask(103);

        // Display Updated Tasks
        taskManager.displayTasks();
    }
}