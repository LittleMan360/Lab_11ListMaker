// Importing the Scanner and ArrayList classes from Java's utility library
import java.util.Scanner;
import java.util.ArrayList;

// Defining a public class named ListMaker
public class ListMaker {


    public static void main(String[] args) {
        // Creating a new Scanner object named 'in'
        Scanner in = new Scanner(System.in);
        // Creating a new ArrayList of Strings named 'arrList'
        ArrayList<String> arrList = new ArrayList<>();
        // Declaring a String variable named 'ans' and initializing it to an empty string
        String ans;
        // Declaring a boolean variable named 'run' and initializing it to true
        boolean run = true;

        // Start of do-while loop
        do {
            // Displaying a menu to the user and storing their response in 'ans'
            ans = printMenu(in, arrList);
            // Switch statement to handle user's response
            switch (ans) {
                case "A":
                    // If the user chose to add an item to the list, call the 'addToArrList' function
                    addToArrList(in, arrList);
                    break;
                case "D":
                    // If the user chose to delete an item from the list, call the 'deleteFromArrList' function
                    deleteFromArrList(in, arrList);
                    break;
                case "P":
                    // If the user chose to print the list, call the 'displayArrList' function
                    displayArrList(arrList);
                    break;
                case "Q":
                    // If the user chose to quit, prompt for confirmation and exit the loop if confirmed
                    if (SafeInput.getYNConfirm(in, "Are you sure")) {
                        run = false;
                    } else {
                        System.out.println("Returning to menu...");
                    }
                    break;
            }
        } while (run); // End of do-while loop
    }

    // Function to add an item to the ArrayList
    public static void addToArrList(Scanner in, ArrayList arrList) {
        // Prompt the user for an item to add to the list and store it in 'itemToAdd'
        String itemToAdd = SafeInput.getNonZeroLenString(in, "What would you like to add to the array list");
        // Add the item to the end of the ArrayList
        arrList.add(itemToAdd);
    }

    // Function to delete an item from the ArrayList
    public static void deleteFromArrList(Scanner in, ArrayList arrList) {
        // Prompt the user for the index of the item to delete and store it in 'itemToDelete'
        int itemToDelete = SafeInput.getRangedInt(in, "What item do you want to delete", 1, arrList.size());
        // Remove the item at the specified index from the ArrayList
        arrList.remove(itemToDelete - 1);
    }

    // Function to display the contents of the ArrayList
    public static void displayArrList(ArrayList arrList) {
        // Loop through the ArrayList and print each item on a new line
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
    }

    // A method that displays a menu and returns the user's choice as a String
    // The method takes a Scanner object and an ArrayList as parameters
    private static String printMenu(Scanner in, ArrayList arrList) {
        // If ArrayList is empty, display a message
        if (arrList.isEmpty()) {
            System.out.println("Your list is currently empty.");
        } else {
            // If ArrayList is not empty, display the contents
            System.out.println("Current list:");
            for (int i = 0; i < arrList.size(); i++) {
                System.out.printf(" %d. %s\n", i + 1 , arrList.get(i));
            }
        }
            // Get user input for menu option using a regular expression to ensure it's a valid choice
        return SafeInput.getRegExString(in, "Select a menu option:\n A: Add\n D: Delete\n P: Print\n Q: Quit\n", "[AaDdPpQq]").toUpperCase();
    }
}