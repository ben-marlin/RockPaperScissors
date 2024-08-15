package edu.guilford;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a letter
        System.out.print("Enter a single letter: ");
        String response = scanner.nextLine();

        // Push the user to enter only a single character
        while (response.length() > 1) {
            System.out.print("Enter a SINGLE letter: ");
            response = scanner.nextLine();
        }

        // Converts the string to a char using charAt(0) method
        char letter = response.toUpperCase().charAt(0);

        // Initialize the point value
        int points = 0;

        // Determine the Scrabble score using if statements with compound logical operators
        if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U' ||
            letter == 'L' || letter == 'N' || letter == 'S' || letter == 'T' || letter == 'R') {
            points = 1;
        } else if (letter == 'D' || letter == 'G') {
            points = 2;
        } else if (letter == 'B' || letter == 'C' || letter == 'M' || letter == 'P') {
            points = 3;
        } else if (letter == 'F' || letter == 'H' || letter == 'V' || letter == 'W' || letter == 'Y') {
            points = 4;
        } else if (letter == 'K') {
            points = 5;
        } else if (letter == 'J' || letter == 'X') {
            points = 8;
        } else if (letter == 'Q' || letter == 'Z') {
            points = 10;
        } else {
            System.out.println("Invalid input. Please enter a valid letter.");
            return;
        }

        // Output the point value
        System.out.println("The Scrabble point value for '" + letter + "' is: " + points);
    }
}