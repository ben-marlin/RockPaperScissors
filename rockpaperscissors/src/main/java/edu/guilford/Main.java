package edu.guilford;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int choice;
        char comp = 'b';

        String response = "whatever";
        char play = 'w';        

        while ((play != 'r') && (play != 'p') && (play != 's')) {
            System.out.print("Type rock, paper, or scissors: ");
            response = scanner.nextLine();
            response = response.toLowerCase();
            play = response.charAt(0);
            System.out.println(play);
        }

        choice = rand.nextInt(3) + 1;

        if (choice == 1) {
            comp = 'r';
        }
        
        if (choice == 2) {
            comp = 'p';
        }
        
        if (choice == 3) {
            comp = 's';
        } 

        String feedback = "Player threw ";

        if (play == 'r') {
            feedback += "rock. ";
        }

        if (play == 'p') {
            feedback += "paper. ";
        }

        if (play == 's') {
            feedback += "scissors. ";
        }

        feedback += "Computer threw ";

        if (comp == 'r') {
            feedback += "rock. ";
        }

        if (comp == 'p') {
            feedback += "paper. ";
        }

        if (comp == 's') {
            feedback += "scissors. ";
        }

        System.out.println(feedback);

        if (play == comp) {
            feedback = "It's a draw!";
        }

        if (((play == 'r') && (comp == 'p')) || ((play == 'p') && (comp == 's')) || ((play == 's') && (comp == 'r'))) {
            feedback = "You lost!";
        }

        if (((play == 'r') && (comp == 's')) || ((play == 'p') && (comp == 'r')) || ((play == 's') && (comp == 'p'))) {
            feedback = "You won!";
        }

        System.out.println(feedback);
        }
}