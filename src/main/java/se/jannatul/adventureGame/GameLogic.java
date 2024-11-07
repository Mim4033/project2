package se.jannatul.adventureGame;
import se.jannatul.adventureGame.Model.*;

import java.util.Scanner;


public class GameLogic {
    public void startgame() {
        Scanner scanner = new Scanner(System.in);  // starts scanner for user input
        Resident resident = new Resident();        // resident instance of the player
        Burglar burglar = new Burglar();           // burglar instance of the enemy
        boolean fryingPanFound = false;            // if frying pan found
        boolean burglarDefeated = false;           // if burglar has been defeated
        boolean running = true;                    // Control the main game loop

        System.out.println("You wake up in the livingroom from a noise");
        System.out.println("What do you do? Please enter your choice");

        while (running) { // game loop start
            // display room options
            System.out.println("1. Go to Livingroom");
            System.out.println("2. Go to Office");
            System.out.println("3. Go to Hall");
            System.out.println("4. Go to kitchen");
            System.out.println("5. Go to bedroom");
            String choice = scanner.nextLine(); // Get user input for room choice
            try {
                switch (choice) {
                    case "1":  // Living room case
                        System.out.println("You are in the Livingroom, the TV is still on");
                        break;
                    case "2": // Office case
                        if (burglarDefeated) {
                            System.out.println("You use your phone to call the police");
                            System.out.println("Police successfully captured the burglar ");
                            System.out.println("You win the game!");
                            running = false;
                        } else {
                            System.out.println("You are in the Office, you see a phone");
                            System.out.println("You continue search for the sound");
                        }
                        break;
                    case "3": // Hall case (where burglar attack)
                        System.out.println("You are in the Hall, you encounter a burglar");
                        if (!burglarDefeated) { // Start fight loop if burglar not defeated
                            System.out.println("Prepare to fight");
                            System.out.println("Burglar's health: " + burglar.getHealth());
                            System.out.println("Resident's health: " + resident.getHealth());

                            // Fight loop
                            while (resident.isConcious() && burglar.isConcious()) {
                                System.out.println("You attack the burglar!");
                                resident.punch(burglar); // Resident attacks burglar
                                System.out.println("Burglar's health after hit: " + burglar.getHealth());

                                if (burglar.isConcious()) { // If burglar is still conscious, they attack back
                                    System.out.println("The burglar attacks back!");
                                    burglar.punch(resident);  // Burglar attacks resident
                                    System.out.println("Resident's health after hit: " + resident.getHealth());
                                }
                                if (resident.isConcious()) {
                                    System.out.println("Burglar is defeated!");
                                    burglarDefeated = true; // Set burglarDefeated to true to end fight
                                } else {
                                    System.out.println("Resident is defeated!");
                                    System.out.println("Game Over");
                                    running = false; // End the game if resident is defeated
                                }
                            }
                        }
                        break;
                    case "4": // Kitchen case
                        if (!fryingPanFound) { // Check if frying pan has not been picked up
                            System.out.println("You are in the Kitchen, you see an frying pan");
                            System.out.println(" Do you want to pickup the frying pan?");
                            System.out.println("y");
                            System.out.println("n");
                            String fryingPan = scanner.nextLine();
                            try {
                                switch (fryingPan) {
                                    case "y":
                                        System.out.println("You picked up the frying pan, your damaged is increased by 3");

                                        resident.addDamage(3); // Increase resident's damage
                                        fryingPanFound = true; // Set fryingPanFound to true

                                    System.out.println("Attack the burglar with more damage power");
                                        break;
                                    case "n":
                                        System.out.println("You have to fight without frying pan");
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("Something went wrong");
                            }
                        }

                                    case "5": // Bedroom case
                                        System.out.println("You are in the bedroom, light is still on");
                                        break;
                                    default:
                                        System.out.println("Choose between 1 to 5"); // Handle invalid input
                                }
                            } catch (Exception e) {  // Catch unexpected exceptions
                                System.out.println("Choose between 1 to 5");
                            }
                        }
                        scanner.close(); // Close the scanner when game ends
                }

            }

