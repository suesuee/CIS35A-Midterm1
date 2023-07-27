//Sue Sue - CIS 35A
// This program displays the burgers available at De Anza Food court, 
//	get the user choice and quantity, calculate the bills, and print the receipt. 

package midterm1;

import java.util.Scanner;

public class Order {

	private int userInput;
	private String inputString;
	private int quantity;
	private String[] burgerName = {"De Anza Burger","Bacon Cheese Burger", "Mushroom Swiss Burger", "Western Burger", "Don Cali Burger" };
	private double[] priceArray = {5.25, 5.75, 5.95, 5.95, 5.95};
	private int[] quantityArray = new int[5];
	private double total;
	private double taxAmount;
	private final double TAX_RATE = 0.09;
	private double totalWithTax;
	private Scanner sc;

	//Displaying Burger names and prices
	public void displayMenu() {
		System.out.println("WELCOME TO DE ANZA GRILL");
		System.out.println("=========================");

		//Looping through the array to show the burger names
		System.out.println("Here are the options: ");
		for (int i = 0; i < 5; i++) {
			System.out.println(i + 1 + ": " + burgerName[i] + " - " + priceArray[i]);
		}
		System.out.println((burgerName.length + 1) + ": Exit! Calcuate the bill.\n");
	}

	// Getting user's choice of burger and its quantity
	// Check user's input validation: no string, only number from 1 to 6
	// Leave the system if user entered "6"
	public void getInputs() {

		System.out.println("Enter your burger choice (1-5): ");
		System.out.println("Don't forget to enter 6 after you are satisfied with your order!");

		// Asking for user's input until user entered "6"
		while (true) {
			sc = new Scanner(System.in);

			// Accept user input as string
			System.out.print("Your choice: ");
			inputString = sc.nextLine().trim();

			//Leave the loop when user enters 6
			if (inputString.equals("6")) {
				break;
			}

			// Convert string to int if the user doesn't want to exit
			try {
				userInput = Integer.parseInt(inputString);
				// If the string can't be converted to int
			} catch (NumberFormatException e) {
				System.out.println("What you entered is not a NUMBER! Pls try again.");
				continue;
			}

			//If the user is not between the range of 1 to burgerName Array Length
			if (userInput < 1 || userInput > burgerName.length) {
				System.out.println("Please choose an option between 1 and " + burgerName.length + ".");
				continue;
			}

			// Accept user input as string
			System.out.print("Enter the amount of burger: ");
			String quantityString = sc.nextLine().trim();

			//Convert string to int
			try {
				quantity = Integer.parseInt(quantityString);
				// If the string can't be converted to int
			} catch (NumberFormatException e) {
				System.out.println("What you entered is not a NUMBER! Pls start over.");
				continue;
			}

			// If the quantity is less than or equal to 0
			if (quantity <= 0) {
				System.out.println("Quantity cannot be negative or 0! Please enter a valid quantity.");
				continue;
			}

			//Will skip this if the user didn't enter either of the burger choice or quantity
			if((userInput >= 1 || userInput <= burgerName.length) && (quantity > 0)) {
				//Counting the quantity of each burger in the array
				quantityArray[userInput - 1] += quantity;
			}
		}

	}

	//Burger Price Calculation depends on student or staff
	public void calculate() {

		// Finding Total
		for (int i = 0; i < burgerName.length; i++) {
			total += priceArray[i] * quantityArray[i];
		}

		if(total != 0) {
			//Ask user if they are student or staff to add tax
			System.out.print("\nAre you a student or staff? ");
			System.out.println("Enter student or staff: ");
			String job = sc.nextLine().trim().toLowerCase();

			while(!job.equals("student") && !job.equals("staff")) 
			{
				System.out.print("\nAre you a student or staff? ");
				System.out.println("Enter student or staff: ");
				job = sc.nextLine().trim().toLowerCase();
			}

			// No tax if the customer is student
			if (job.equals("student")) {
				taxAmount = 0;
			}

			// Adding 9% tax if the customer is staff
			if (job.equals("staff")) {
				taxAmount = total * TAX_RATE;
			}

			// Calculate the total with tax
			totalWithTax = total + taxAmount;
		}
		else {
			System.out.println("You didn't buy anything!");
		}
	}

	//Print out what the user ordered
	public void printBill() {

		if (total != 0) {
			System.out.println("\n=====================================");
			System.out.println("DE ANZA FOOD COURT");
			System.out.println("ORDER DETAILS\n");

			for (int i = 0; i < burgerName.length; i++) {
				//Display food items, the quantities, and the cost of them
				if (quantityArray[i] > 0) {
					System.out.print(burgerName[i] + " (" + priceArray[i] + ") " + " x " + quantityArray[i] + " = " );
					System.out.printf("%.2f" ,priceArray[i] * quantityArray[i]);
					System.out.println();
				}
			}
			System.out.println("\n-------------------------------------");

			System.out.print("Total before tax: ");
			System.out.printf("%.2f", total);
			System.out.print("\nTotal after tax for staff: ");
			System.out.printf("%.2f", totalWithTax);

			System.out.println("\n=====================================");
			System.out.println("Thank you for being our customer.");
		} else {
			System.out.println("Please buy next time!");
		}
	}

}

/*
WELCOME TO DE ANZA GRILL
=========================
Here are the options: 
1: De Anza Burger - 5.25
2: Bacon Cheese Burger - 5.75
3: Mushroom Swiss Burger - 5.95
4: Western Burger - 5.95
5: Don Cali Burger - 5.95
6: Exit! Calcuate the bill.

Enter your burger choice (1-5): 
Don't forget to enter 6 after you are satisfied with your order!
Your choice: 1
Enter the amount of burger: 2
Your choice: 2
Enter the amount of burger: 3
Your choice: 3
Enter the amount of burger: 1
Your choice: 6

Are you a student or staff? Enter student or staff: 
student

=====================================
DE ANZA FOOD COURT
ORDER DETAILS

De Anza Burger (5.25)  x 2 = 10.50
Bacon Cheese Burger (5.75)  x 3 = 17.25
Mushroom Swiss Burger (5.95)  x 1 = 5.95

-------------------------------------
Total before tax: 33.70
Total after tax for staff: 33.70
=====================================
Thank you for being our customer.
 */

/*
WELCOME TO DE ANZA GRILL
=========================
Here are the options: 
1: De Anza Burger - 5.25
2: Bacon Cheese Burger - 5.75
3: Mushroom Swiss Burger - 5.95
4: Western Burger - 5.95
5: Don Cali Burger - 5.95
6: Exit! Calcuate the bill.

Enter your burger choice (1-5): 
Don't forget to enter 6 after you are satisfied with your order!
Your choice: 1
Enter the amount of burger: jlk
What you entered is not a NUMBER! Pls start over.
Your choice: 2
Enter the amount of burger: lj
What you entered is not a NUMBER! Pls start over.
Your choice: 6
You didn't buy anything!
Please buy next time!
 */

/*
WELCOME TO DE ANZA GRILL
=========================
Here are the options: 
1: De Anza Burger - 5.25
2: Bacon Cheese Burger - 5.75
3: Mushroom Swiss Burger - 5.95
4: Western Burger - 5.95
5: Don Cali Burger - 5.95
6: Exit! Calcuate the bill.

Enter your burger choice (1-5): 
Don't forget to enter 6 after you are satisfied with your order!
Your choice: 7
Please choose an option between 1 and 5.
Your choice: 2
Enter the amount of burger: a
What you entered is not a NUMBER! Pls start over.
Your choice: 2
Enter the amount of burger: 1
Your choice: 6

Are you a student or staff? Enter student or staff: 
student

=====================================
DE ANZA FOOD COURT
ORDER DETAILS

Bacon Cheese Burger (5.75)  x 1 = 5.75

-------------------------------------
Total before tax: 5.75
Total after tax for staff: 5.75
=====================================
Thank you for being our customer.
 */
