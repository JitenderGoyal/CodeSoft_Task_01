//                    Numeber Gussesing Game

import java.util.Scanner; // Import the Scanner class for user input
import java.util.Random; // Import the Random class for generating random numbers

public class Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        Random random = new Random(); // Create a Random object for generating random numbers
        int lowerBound = 1; // Set the lower bound for the random number
        int upperBound = 100; // Set the upper bound for the random number
        int numberToGuess; // Declare a variable to store the number the user needs to guess
        int maxAttempts = 10; // Define the maximum number of attempts allowed
        int attempts = 0; // Initialize a variable to keep track of the current attempt
        int round = 0; // Initialize a variable to keep track of the current round
        int totalRounds = 0; // Initialize a variable to keep track of the total number of rounds
        int correctGuesses = 0; // Initialize a variable to keep track of the correct guesses
        int[] totalAttemptsPerRound = new int[10]; // Create an array to store the total attempts per round (assuming a maximum of 10 rounds)
        int[] correctGuessesPerRound = new int[10]; // Create an array to store the correct guesses per round

        // Define strings for formatting
        String border = "========================================================";
        String roundedBorder = "+------------------------------------------------------+";
        String welcome = "        Welcome to the Number Guessing Game        ";

        // Print a welcome message
        System.out.println(border);
        System.out.println(welcome);
        System.out.println(border);

        while (true) {
            round++; // Increment the round number
            totalRounds++; // Increment the total number of rounds

            // Print the round information
            System.out.println(roundedBorder);
            System.out.println("                      Round " + round + "                      ");
            System.out.println(roundedBorder);

            // Generate a random number for the user to guess
            numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            attempts = 0; // Reset the number of attempts for the current round

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: "); // Prompt the user for a guess
                int userGuess = scanner.nextInt(); // Read the user's guess from input

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Your guess should be between " + lowerBound + " and " + upperBound + ".");
                    continue; // If the guess is out of bounds, display a message and continue the loop
                }

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number: " + numberToGuess);
                    correctGuesses++; // Increment the correct guess counter
                    correctGuessesPerRound[round - 1]++; // Increment the correct guess counter for the current round
                    totalAttemptsPerRound[round - 1] = attempts + 1; // Store total attempts for the round
                    break; // Exit the loop if the guess is correct
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }

                attempts++; // Increment the attempt count
            }

            if (attempts == maxAttempts) {
                System.out.println("Out of attempts. The correct number was: " + numberToGuess);
                totalAttemptsPerRound[round - 1] = maxAttempts; // Store max attempts for the round
            }

            System.out.print("\nDo you want to play again? (yes/no): "); // Ask the user if they want to play again
            String playAgain = scanner.next().toLowerCase(); // Read the user's response and convert to lowercase

            if (!playAgain.equals("yes")) {
                break; // Exit the loop if the user does not want to play again
            }
        }

        // Game over message and statistics
        System.out.println(border);
        System.out.println("                    Game Over                     ");
        System.out.println(border);
        System.out.println(" Total Correct Guesses: " + correctGuesses + "                   ");
        System.out.println(" Detail of Guesses per round                   ");

        // Print the correct guesses for each round
        for (int i = 0; i < totalRounds; i++) {
            System.out.println(" Round " + (i + 1) + ": " + correctGuessesPerRound[i] + " correct guess        ");
        }
        System.out.println(border);
        System.out.println(" Total Attempts per Round:                        ");

        // Print the total attempts for each round
        for (int i = 0; i < totalRounds; i++) {
            System.out.println(" Round " + (i + 1) + ": " + totalAttemptsPerRound[i] + " attempts                 ");
        }
        System.out.println(border);

        scanner.close(); // Close the Scanner object to release resources
    }
}
