// Program: Terning
// Version: 2.00
// Date created: 2014-06-10
// Last modified: 2016-09-24
// Author: Bjørn Christensen 
// Modified by: Agner Fog

// Description:
// This program simulates roll of a die
// It has three errors:
// 1. The program asks the user how many times he wants the dice to roll.
//    If he doesn´t enter a valid number the program will crash.
// 2. The program rolls the dice one time less than asked
// 3. The dice is not symetric. It will roll too few ones and six'es

package terning;

import java.util.Scanner;

public class UseDice {

    public static void main(String[] args) {
        int n = 0;
        boolean isOk = false;

        Dice cup = new Dice();   // Make an instance of Dice
        Scanner keyboard = new Scanner(System.in);   // Make an instance of keyboard Scanner
        System.out.println("Welcome to the diceroll program");
        System.out.println("How many times do you want to roll the dice?");

        while (!isOk) {
            try {
                n = keyboard.nextInt();
                isOk = true;
            } catch (Exception e) {

                //Når inputtet er ulovligt fjernes den ulovlige indtastning.
                keyboard.nextLine();

                //Brugeren bliver gjort opmærksom på han laver noget forkert.
                System.out.println("Indtastning skal være af typen Integer, prøv igen.");
            }
        }
        cup.rollMultiple(n);         // Roll the dice n times
        keyboard.close();            // Close the scanner
    }
}