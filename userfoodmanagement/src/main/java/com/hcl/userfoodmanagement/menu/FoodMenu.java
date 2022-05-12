package com.hcl.userfoodmanagement.menu;

import java.util.List;
import java.util.Scanner;

import com.hcl.userfoodmanagement.beans.Food;
import com.hcl.userfoodmanagement.beans.User;
import com.hcl.userfoodmanagement.serviceImpl.FoodServiceImp;
import com.hcl.userfoodmanagement.serviceImpl.UserServiceImpl;

public class FoodMenu {
	FoodServiceImp foodService;
	UserServiceImpl userService;

	public FoodMenu() {
		super();
		foodService=new FoodServiceImp();
		userService=new UserServiceImpl();
	}
	public void choice() {
		System.out.println("----------Food managemant system-----------\n");
		System.out.println("1. Save Food data");
		System.out.println("2. Update Food Data");
		System.out.println("3. Delete Food Data");
		System.out.println("4. Food Data FindById");
		System.out.println("5. Show All Food Data ");
		System.out.println("6. Show Main Menu");
		System.out.println("7. Exit");
		
		System.out.println("enter choice : (1,2,3,4,6,7) ");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		switch (choice) {
		case "1": 
			createFoodData(sc);
			break;
		case "2":
			updateFoodData(sc);
			break;
		case "3":
			deleteFoodData(sc);
			break;
		case "4":
			findDataById(sc);
			break;
		case "5":
			getAllData();
			break;
		case "6":
			MainMenu mainMenu=new MainMenu();
			mainMenu.start();
			break;
		case "7":
			System.out.println("Exit");
			System.out.println("-------Thank you for using  application-------");
			System.exit(7);
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
		choice();
		
	}
	public void createFoodData(Scanner scanner) {
		System.out.println("Enter Food Name");
		String foodName=scanner.nextLine();
		System.out.println("Enter User Id");
		String userId=scanner.nextLine();
		System.out.println("Enter Food Price");
		Double foodPrice=scanner.nextDouble();
		User user=(User) userService.findById(Long.parseLong(userId));
		Food food=new Food();
		food.setFood_name(foodName);
		food.setFood_price(foodPrice);
		food.setUser_details(user);
		foodService.saveData(food);
		System.out.println("Successfully!! Data Saved");

	}
	public void updateFoodData(Scanner scanner) {
		System.out.println("Enter Food Id :-");
		Long id=Long.parseLong(scanner.nextLine());
		
		System.out.println("****************");
		System.out.println("Please enter food name for update :-");
		String foodName=scanner.nextLine();
		Food food=(Food) foodService.findById(id);;
		food.setFood_name(foodName);
		foodService.updateObject(food);
		System.out.println("Successfully!! Data Updated");
		choice();
	}
	
	public void deleteFoodData(Scanner scanner) {
		System.out.println("Enter Food Id");
		Long id=scanner.nextLong();
		foodService.deleteObject(id);
		System.out.println("SuccessFully!! Data Deleted");
	}
	public void getAllData() {
		List<Object> list= foodService.getAllData();
		int count=1;
		for(Object obj:list) {
			System.out.println("------------------------ Food "+count+" Data---------------------");
			System.out.println("Food Id : "+((Food)obj).getFood_id());
			System.out.println("Food Name: "+((Food)obj).getFood_name());
			count++;
		}
	}
	public void findDataById(Scanner sc) {
		System.out.println("enter id :-");
		Long id=Long.parseLong(sc.nextLine());
		Object obj=foodService.findById(id);
		System.out.println("------------------ Food Data ---------------------------");
		System.out.println("Food Id : "+((Food)obj).getFood_id());
		System.out.println("Food Name: "+((Food)obj).getFood_name());
	}
	

}
