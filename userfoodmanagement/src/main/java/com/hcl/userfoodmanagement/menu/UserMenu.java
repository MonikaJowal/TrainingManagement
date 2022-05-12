package com.hcl.userfoodmanagement.menu;

import java.util.List;
import java.util.Scanner;

import com.hcl.userfoodmanagement.beans.Food;
import com.hcl.userfoodmanagement.beans.User;
import com.hcl.userfoodmanagement.serviceImpl.FoodServiceImp;
import com.hcl.userfoodmanagement.serviceImpl.UserServiceImpl;

public class UserMenu {
	UserServiceImpl userService;

	public UserMenu() {
		super();
		userService=new UserServiceImpl();
	}
	public void choice() {
		System.out.println("----------User managemant system-----------\n");
		System.out.println("1. Save_data");
		System.out.println("2. Update User Data");
		System.out.println("3. Delete User Data");
		System.out.println("4. User Data FindById");
		System.out.println("5. Show All Data ");
		System.out.println("6. Show Main Menu ");
		System.out.println("7. Exit");
		
		System.out.println("enter choice : (1,2,3,4,5,6,7) ");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		switch (choice) {
		case "1": 
			createUserData(sc);
			break;
		case "2":
			updateUserData(sc);
			break;
		case "3":
			deleteUserData(sc);
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
	public void createUserData(Scanner scanner) {
		System.out.println("Enter First Name");
		String first_name=scanner.nextLine();
		System.out.println("Enter Last Name");
		String last_name=scanner.nextLine();
		System.out.println("Enter Mobile No");
		String mobile_no=scanner.nextLine();
		System.out.println("Enter Email Id");
		String email_id=scanner.nextLine();
		User user=new User();
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setMobile_no(mobile_no);
		user.setEmail_id(email_id);
		userService.saveData(user);
		System.out.println("Successfully!! Data Saved");

	}
	public void updateUserData(Scanner scanner) {
		System.out.println("Enter User Id :-");
		Long id=Long.parseLong(scanner.nextLine());
		
		System.out.println("****************");
		System.out.println("Please enter choice for update :-");
		System.out.println("1. First_Name");
		System.out.println("2. Last_Name");
		System.out.println("3. Mobile_No");
		System.out.println("4. Email_Id");
		String choice=scanner.nextLine();
		User user=(User) userService.findById(id);;
		switch (choice) {
		case "1":
			System.out.println("Enter First Name");
			String first_name=scanner.next();
			user.setFirst_name(first_name);
			break;
		case "2":
			System.out.println("Enter Last Name");
			String last_name=scanner.next();
			user.setLast_name(last_name);
			break;
		case "3":
			System.out.println("Enter Mobile No");
			String mobile=scanner.next();
			user.setMobile_no(mobile);
			break;
		case "4":
			System.out.println("Enter Email Id");
			String email=scanner.next();
			user.setEmail_id(email);
			break;
		default:
			break;
			
		}
		userService.updateObject(user);
		System.out.println("Successfully!! Data Updated");
		choice();
	}
	
	public void deleteUserData(Scanner scanner) {
		System.out.println("Enter User Id");
		Long id=scanner.nextLong();
		userService.deleteObject(id);
		System.out.println("SuccessFully!! Data Deleted");
	}
	public void getAllData() {
		List<Object> list= userService.getAllData();
		int count=1;
		for(Object obj:list) {
			User user=(User) obj;
			System.out.println("------------------ User "+count+" Data --------------------");
			System.out.println("first name : "+user.getFirst_name());
			System.out.println("last name : "+user.getLast_name());
			System.out.println("email id : "+user.getEmail_id());
			System.out.println("mobile no : "+user.getMobile_no());
			System.out.println("------------------ Food Detail for User "+count+"--------------------");
			for(Food food:user.getFood_menu()) {
				System.out.println("Food Id : "+food.getFood_id());
				System.out.println("Food Name : "+food.getFood_name());
			}
			count++;
		}
	}
	public void findDataById(Scanner sc) {
		System.out.println("enter id :-");
		Long id=Long.parseLong(sc.nextLine());
		User user=(User) userService.findById(id);
		System.out.println("--------------------- User Data-------------------------------");
		System.out.println("first name : "+user.getFirst_name());
		System.out.println("last name : "+user.getLast_name());
		System.out.println("email id : "+user.getEmail_id());
		System.out.println("mobile no : "+user.getMobile_no());
		System.out.println("--------------------- Food Detail--------------------------");
		for(Food food:user.getFood_menu()) {
			System.out.println("Food Id : "+food.getFood_id());
			System.out.println("Food Name : "+food.getFood_name());
		}
	}

}
