package com.hcl.userfoodmanagement.menu;

import java.util.Scanner;

import com.hcl.userfoodmanagement.serviceImpl.FoodServiceImp;

public class OrderMenu {
	private static double itemPrice;
	static boolean ordering = true;
	public static double runningTotal;
	FoodServiceImp foodService;

	public OrderMenu() {
		super();
		foodService=new FoodServiceImp();
	}
	public void menu() {
		System.out.println("--------------WELCOME------------");
		System.out.println("1. Burger ($50.00)");
		System.out.println("2. Pizza ($100.00)");
		System.out.println("3. Fries ($30.00)");
		System.out.println("4. Soda ($50.00)");
		System.out.println("5. Done");
		do {
			System.out.println("Enter Choice : (1,2,3,4,5)");
			Scanner sc= new Scanner(System.in);
			String menuOptions=sc.nextLine();

			int foodItem=0;
			switch (menuOptions) {
			case "1":
				foodItem = 1;
				itemPrice(foodItem);
				break;
			case "2":
				foodItem = 2;
				itemPrice(foodItem);
				break;
			case "3":
				foodItem = 3;
				itemPrice(foodItem);
				break;
			case "4":
				foodItem = 4;
				itemPrice(foodItem);
				break;
			case "5":
				done();
				break;

			default:
				System.out.println("Invalid option.");
				break;
			}

		} while(ordering); 
		
	}
	public static double itemPrice(int foodItem) {
		if (foodItem == 1) {
			// burger= $50.00
			System.out.println("You've ordered a burger");
			itemPrice = 50.00;
		}
		if (foodItem == 2) {
			// pizza = $100.50
			System.out.println("You've ordered pizza");
			itemPrice = 100.00;
		}
		if (foodItem == 3) {
			// fries = $30.00
			System.out.println("You've ordered fries");
			itemPrice = 30.00;
		}
		if (foodItem == 4) {
			// soda = $50.00
			System.out.println("You've ordered a soda");
			itemPrice = 50.00;
		}
		quantity();
		return itemPrice;
	}
	private static double quantity() {
		System.out.println("Enter quantity");
		Scanner input=new Scanner(System.in);
		double quantity = input.nextDouble();
		subTotal(quantity, itemPrice);
		return quantity;		
	}
	private static double subTotal(double quantity, double itemPrice2) {
		double subTotal = quantity*itemPrice;
		System.out.println("Subtotal: "+ subTotal);
		runningTotal += subTotal;
		return subTotal;

	}
	public static void done(){
		ordering = false;
		System.out.println(runningTotal);
		System.out.println("Enjoy your meal");
	}

}
