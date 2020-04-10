import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class GenerateUser {
	
	static Scanner scan = new Scanner(System.in);
	static UserDatabase db = new UserDatabase();
	
	/**
	 * prompts the user to sign up
	 * @return 
	 */
	public static User generateUser() {
		return choices();
	}
	
	/**
	 * Gives commands to sign up user
	 * @return
	 */
	public static User choices() { // TODO validate integer choice
		System.out.println("\nEnter a number based on what you want to do.");
		System.out.println("1. Login\n2. Create an Account\n3. Continue as Guest");
		int response = scan.nextInt();
		scan.nextLine();
		if (response == 1) {
			return login();
		}
		else if (response == 2){
			db.enterUser();
			System.out.println("Please log in to your new account.");
			return login();
		}
		else {
			return guestUser();
		}
	}
	
	/**
	 * Allows a signed up user to login to the system
	 * @return
	 */
	public static User login() {
		String username = "";
		ArrayList<String> users = db.getAllUsernames();
		while(true) {
			System.out.println("Enter your username:");
			username = scan.nextLine();
			if (username.length() == 0) {
				System.out.println("Your username cannot be empty.");
				continue;
			}
			if (users.contains(username)) {
				System.out.println("Enter your password in the popup window.");
				String correctPass = db.getUserPassword(username);
				String userPass = db.readPassword();
				while(!(userPass.equals(correctPass))) {
					System.out.println("Incorect. Enter your password.");
					userPass = db.readPassword();
				}
				System.out.println("Logging in...");
				return returnUser(username);
				
			}
			else {
				System.out.println("Username does not exist.");
				continue;
			}
		}
	}
	/**
	 *  Returns a user from database by username
	 * @param username
	 * @return user account
	 */
	public static User returnUser(String username) {
		JSONObject userObject = db.findUser(username);
		String password = (String) userObject.get("password");
		String email = (String) userObject.get("email");
		String[] wallet = new String[3];
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		ArrayList<Ticket> cart =  new ArrayList<Ticket>();
        int age = Integer.parseInt((String) userObject.get("age"));
        int rewardPoints = Integer.parseInt((String) userObject.get("points"));
        double discountRate = Double.parseDouble((String) userObject.get("discount"));
        String ID = (String) userObject.get("ID");
        String type = (String) userObject.get("type");
        Location location = DatabaseDriver.returnLocation(((String) userObject.get("location")));
        
		if (type.equals("handicapped"))
			return new HandicappedUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate, ID);
		if (type.equals("student"))
			return new StudentUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate, ID);
		if (type.equals("veteran"))
			return new VeteranUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate, ID);
		if (type.equals("employee"))
			return new EmployeeUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate, ID, location);
		if (type.equals("teacher"))
			return new TeacherUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate, ID);
		if (type.equals("admin"))
			return new AdminUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate, ID);
		if (type.equals("standard"))
			return new StandardUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate, ID);
		else
			return guestUser();
	}
	
	/**
	 * crates a guest account
	 * @return guest account
	 */
	public static User guestUser() {
		int age = 0;
		String[] wallet = new String[3];
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		while(true) {
			System.out.println("Enter your current age:");
			age = scan.nextInt();
			scan.nextLine();
			if (age < 18) {
				System.out.println("Users younger than 18 must purchase tickets with a registered adult account.");
				return choices();
			}
			if (age > 130) {
				System.out.println("That age is invalid.");
				continue;
			}
			else {
				System.out.println("Age added.");
				return new GuestUser(age, wallet, tickets);
			}
		}
	}

}
