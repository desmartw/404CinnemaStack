/**
 * 
 * @author Ryan Henderson
 * Helper class holding functionality and structure for the Driver
 * that is why most things are public // TODO maybe change this line
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Page {
	
	String display;
	ArrayList<Page> links;
	String color;
	
	public Page() {
		display = "";
		links = new ArrayList<Page>();
		color = "\\033[0;102m";
	}
	
	/**
	 * Parameterized constructor
	 */
	public Page(ArrayList<Page> links, String color) {
		display = "";
		this.links = links;
		this.color = color;
	}
	
	public int getValidatedChoice(Scanner scan) {
		String choice;
		int intChoice;
		while (true) {
			choice = scan.nextLine();
			if (!intChoice.matches("[0-9]+")) {
				System.out.println("Please enter an integer");
				continue;
			}
			intChoice = Integer.parseInt(choice);
			if (intChoice < 0 || intChoice >= links.size())
		}
	}
	
	/**
	 * Gives admin users an option so that they may access their administrative functions
	 * @param user
	 * @return String - empty if the user is not of admin status, filled with a number to choose so that
	 * an admin can execute their unique functionality
	 */
	public String goToAdminOptions(User user) {
		if (user.getType().equalsIgnoreCase("admin")) {
			return links.size() + ": Access Root options";
		}
		return "";
	}
	
	/**
	 * Gives employee users an option so that they may access their administrative functions
	 * @param user
	 * @return String - empty if the user is not an EmployeeUser, filled a number to choose the specific
	 * employee functionalities not available to most users
	 */
	public String goToEmployeeOptions(User user) {
		if (user.getType().equalsIgnoreCase("employee")) {
			return links.size() + ": Access Employee options";
		}
		return "";
	}
	
	// getters and setters
	public String getDisplay() {
		return display;
	}
	
	public void setDisplay(String display) {
		this.display = display;
	}
	
	public ArrayList<Page> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Page> links) {
		this.links = links;
	}
}
