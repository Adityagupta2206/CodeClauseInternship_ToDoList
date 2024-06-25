import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {1
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[x] " : "[ ] ") + description;
    }
}

public class ToDoListApp {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    editTask(scanner);
                    break;
                case 3:
                    deleteTask(scanner);
                    break;
                case 4:
                    listTasks();
                    break;
                case 5:
                    markTaskAsCompleted(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nTo-Do List Application");
        System.out.println("1. Add a task");
        System.out.println("2. Edit a task");
        System.out.println("3. Delete a task");
        System.out.println("4. List all tasks");
        System.out.println("5. Mark a task as completed");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added.");
    }

    private static void editTask(Scanner scanner) {
        listTasks();
        System.out.print("Enter the task number to edit: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();  

        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        System.out.print("Enter the new task description: ");
        String newDescription = scanner.nextLine();
        tasks.get(taskNumber - 1).setDescription(newDescription);
        System.out.println("Task updated.");
    }

    private static void deleteTask(Scanner scanner) {
        listTasks();
        System.out.print("Enter the task number to delete: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();  

        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.remove(taskNumber - 1);
        System.out.println("Task deleted.");
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show.");
            return;
        }

        System.out.println("\nList of tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        listTasks();
        System.out.print("Enter the task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); 

        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.get(taskNumber - 1).markAsCompleted();
        System.out.println("Task marked as completed.");
    }
}
