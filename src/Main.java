import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Moving Company Simulation Program :
 * This program simulates a company relocation process where boxes need to be transported
 * from the old location to the new one using a truck with limited capacity.
 * The program calculates the number of trips required and displays the moving process step by step.
 *
 * @author Léa Deffaisse
 * @version 1.0
 * @since 2025
 */
public class Main {

    /**
     * Main entry point of the program.
     * Handles user inputs for total boxes and truck capacity, then simulates the moving process.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner keyboard = new Scanner(System.in);

        // Secure input for total number of boxes
        int totalBoxes = saisirEntierPositif(keyboard, "Veuillez saisir le nombre total de cartons :");

        // Secure input for truck capacity
        int truckCapacity = saisirEntierPositif(keyboard, "Veuillez saisir la capacité du camion en nombre de cartons :");

        // Close keyboard to free resources
        keyboard.close();

        // Initialize variables for simulation
        int remainingBoxes = totalBoxes;
        int tripsCount = 0;

        // Loop to simulate trips
        while (remainingBoxes > 0) {
            // Calculate how many boxes will be transported in this trip
            int boxesMoved;
            if (remainingBoxes > truckCapacity) {
                boxesMoved = truckCapacity; // Full truck load
            } else {
                boxesMoved = remainingBoxes; // Partial load (last trip)
            }

            // Update the number of remaining boxes
            remainingBoxes -= boxesMoved;
            tripsCount++; // Increment trip number
            // Display trip information
            displayMessage("Voyage " + tripsCount + " : " + boxesMoved + " cartons déplacés.");
        }

        displayMessage("Déménagement terminé!");
        displayMessage("Nombre total de voyages effectués : " + tripsCount);
    }


    /**
     * Prompts the user to enter a positive integer with complete input validation.
     * Uses try-catch mechanism to handle all possible input errors including
     * non-numeric input and negative/zero values.
     * The method will repeatedly ask for input until a valid positive integer is entered.
     * It clears the input buffer automatically when invalid input is detected.
     *
     * @param keyboard the Scanner object used for user input
     * @param message the prompt message to display to the user
     * @return a valid positive integer
     * @throws InputMismatchException when non-numeric input is provided (handled internally)
     *
     * @see Scanner#nextInt()
     * @see Scanner#next()
     */
    public static int saisirEntierPositif(Scanner keyboard, String message) {
        // Initialize variables for input validation
        int value = 0;
        boolean valideInput = false;

        // Loop until valid input is received
        while (!valideInput) {
            try {
                // Display prompt and read user input
                System.out.print(message);
                value = keyboard.nextInt();

                // Check that the value is positive
                if (value <= 0) {
                    displayMessage("Erreur : La valeur doit être positive !");
                } else {
                    valideInput = true; // Valid input received
                }

            } catch (InputMismatchException e) {
                // Handle non-numeric input
                displayMessage("Erreur = Veuillez saisir un nombre entier valide.");
                keyboard.next(); // Clear the buffer to avoid infinite loop
            }
        }
        // Return the validated positive integer
        return value;
    }

    /**
     * Displays a message to the console with a newline.
     * This utility method provides a simple way to output text to the standard output stream.
     *
     * @param message the text message to be displayed on the console
     *
     * @see System#out
     * @see java.io.PrintStream#println(String)
     */
    public static void displayMessage(String message) {
        System.out.println(message);
    }
}