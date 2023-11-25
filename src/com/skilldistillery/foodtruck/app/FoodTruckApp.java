package com.skilldistillery.foodtruck.app;

import java.util.Scanner;
import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	private FoodTruck[] fleet = new FoodTruck[5];
	private Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.run();
	}
	
	public void run() {
		promptUser();
		int userChoice;
		do {
			printMenu();
			userChoice = getChoice();

            switch (userChoice) {
                case 1:
                    listFoodTrucks();
                    break;
                case 2:
                    displayAverageRating();
                    break;
                case 3:
                    displayHighestRatedTruck();
                    break;
                case 4:
                    System.out.println("\nExiting program.");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please enter a number between 1 and 4.");
            }
        } while (userChoice != 4);
			
		
	}
	
	private void displayHighestRatedTruck() {
		if (fleet[0] != null) {
			double highestRating = fleet[0].getRating();
			int highestRated = 0;
			int index = 0;
			for (FoodTruck truck : fleet) {
				if (truck != null && truck.getRating() > highestRating) {
					highestRating = truck.getRating();
					highestRated = index;
				}
				index++;
			}
			System.out.println("\n" + fleet[highestRated].toString());
		} else {
			System.out.println("\nNo food trucks to display!");
		}
			

	}
	
	private void displayAverageRating() {
		if (fleet[0] != null) {
			int nonNullCount = 0;
			double totalRating = 0;
			for (FoodTruck truck : fleet) {
				if (truck != null) {
					nonNullCount++;
					totalRating += truck.getRating();
				}
			}
			System.out.printf("%nThe average food truck rating is %.1f%n", totalRating/nonNullCount);
		} else {
			System.out.println("\nNo food trucks to display!");
		}


	}
	
	private void listFoodTrucks() {
		if  (fleet[0] != null ) {
			System.out.println();
			for (FoodTruck truck : fleet) {
				if (truck != null) {
					System.out.println(truck.toString());
				} 
			}
		} else {
			System.out.println("\nNo food trucks to display!");
		}
	}
	
	private void promptUser(){
		System.out.println("Please enter the name, food type, and rating for up to five food trucks: ");
		String name;
		String foodType;
		double rating;
		for (int i = 1; i <= 5; i++) {
			System.out.printf("name %d:%n", i);
			name = keyboard.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.printf("food type %d:%n", i);
			foodType = keyboard.nextLine();
			System.out.printf("rating %d:%n", i);
			rating = keyboard.nextDouble();
			keyboard.nextLine();
			FoodTruck foodTruck = new FoodTruck(name, foodType, rating);
			fleet[i-1] = foodTruck;
		}
		
	}

    private void printMenu() {
        System.out.println("\n---- Food Truck Menu ----");
        System.out.println("1. List All Food Trucks");
        System.out.println("2. See Average Rating");
        System.out.println("3. Display Highest-Rated Truck");
        System.out.println("4. Quit");
    }

    private int getChoice() {
    	return keyboard.nextInt();
    	
    }
}
