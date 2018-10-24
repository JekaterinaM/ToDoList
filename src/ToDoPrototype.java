import java.util.ArrayList;
import java.util.Scanner;

public class ToDoPrototype {

    public static void main(String[] args) {


        ArrayList<String> toDoList = new ArrayList<String>();
        printMenu();
        boolean isProgrammeRunning = true;

        while(isProgrammeRunning) {
            int userAction = getActionFromUser();
            switch(userAction) {
                case 1: addTask(toDoList);
                    break;
                case 2: deleteTask(toDoList);
                    break;
                case 3: printToDoList(toDoList);
                    break;
                case 4: printMessageToConsole("Closing the programme...");
                    isProgrammeRunning = false;
                    break;
                default: printMessageToConsole("Invalid action!");

            }
        }
    }



    public static void printMessageToConsole (String message) {
        System.out.println(message);
    }


    public static void printMenu() {
        printMessageToConsole("This is a ToDoList application menu:");
        printMessageToConsole("1 - add new task");
        printMessageToConsole("2 - remove task from a list");
        printMessageToConsole("3 - print a list");
        printMessageToConsole("4 - quit");
    }





    public static int getActionFromUser () {
        printMessageToConsole("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int action = sc.nextInt();
        return action;
    }


    public static String getTaskNameFromUser() {
        Scanner sc = new Scanner(System.in);
        String item = sc.next();
        return item;
    }





    public static boolean isTaskInTheList(ArrayList<String> currentList, String checkedItem) {
        boolean isTaskInTheList = false;
        for (String item:
                currentList) {
            if (checkedItem.equals(item)) {
                isTaskInTheList = true;
            }
        }
        return isTaskInTheList;
    }


    public static void addTask(ArrayList<String> currentList) {
        printMessageToConsole("Please enter task name: ");
        String newTask = getTaskNameFromUser();
        boolean isTaskInTheList = isTaskInTheList(currentList, newTask);
        if (isTaskInTheList) {
            printMessageToConsole("Item already in the list. Cannot add duplicated value.");
        } else {
            currentList.add(newTask);
            printMessageToConsole(newTask + " has been added.");
        }
    }


    public static void printToDoList(ArrayList<String> currentList) {
        printMessageToConsole("Tasks in the list are " +currentList);
    }


    public static void deleteTask(ArrayList<String> currentList) {
        printMessageToConsole("Please enter task name you would like to remove: ");
        String taskToDelete = getTaskNameFromUser();
        boolean isTaskInTheList = isTaskInTheList(currentList, taskToDelete);
        if (isTaskInTheList) {
            int listLength = currentList.size();
            int currentListLength = listLength;
            for (int i = 0; i < currentListLength; i++) {
                if (taskToDelete.equals(currentList.get(i))) {
                    currentList.remove(i);
                    currentListLength--;
                    i--;
                }
            }
            printMessageToConsole(taskToDelete + " has been deleted.");
        } else {
            printMessageToConsole("Item is not in the list. Cannot delete absent value.");
        }
    }




}
