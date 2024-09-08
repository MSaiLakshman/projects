import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    private static ArrayList<String> tasks=new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean isrunning=true;

        System.out.println("Welcome to ToDo application: ");
        while (isrunning){
            System.out.println("Choose one option from below");
            System.out.println("1. Add a task");
            System.out.println("2. View all tasks");
            System.out.println("3. Remove a task");
            System.out.println("4. Exit");
            int choice=sc.nextInt();

            switch (choice){
                case 1:
                    addTask(sc);
                    break;
                case 2:
                    viewTask();
                    break;
                case 3:
                    removeTask(sc);
                    break;
                case 4:
                    isrunning=false;
                    System.out.println("Exiting the application. Bye!!!");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        sc.close();
    }

    private static void addTask(Scanner sc){
        System.out.println("Enter the task to be added: ");
        String task=sc.nextLine();
        tasks.add(task);
        System.out.println("Tasks added");

    }

    private static void viewTask(){
        if(tasks.isEmpty())
            System.out.println("No tasks added yet");
        else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i+1)+". "+tasks.get(i));
            }
        }
    }

    private static void removeTask(Scanner sc) {
        viewTask();
        System.out.println("Enter the number of the task to remove");
        int taskNumber = sc.nextInt();
        sc.nextLine();
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            String removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }
}
