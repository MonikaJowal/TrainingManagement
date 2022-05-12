package com.hcl.userfoodmanagement.menu;

import java.util.Scanner;

public class MainMenu {
	@SuppressWarnings("resource")
	public void start() {
		System.out.println("Enter Menu Choice :- \n1.User Menu\n2.Food Menu");
		Scanner sc=new Scanner(System.in);
		String choice=sc.next();
		switch (choice) {
		case "1":
			UserMenu userMenu=new UserMenu();
			userMenu.choice();
			break;
		case "2":
			FoodMenu foodMenu=new FoodMenu();
			foodMenu.choice();
			break;
		default:
			break;
		}
	}
}
