/**
 *  @author Ryan Henderson
 *  EmployeeUser class for employees of event locations to log in and access the app
 */

import java.util.ArrayList;

public class EmployeeUser extends User {
	
	private String employeeID;
	private Location workplace;

	/**
	 * Default constructor
	 */
	public EmployeeUser() {
		
	}
	
	/**
	 * Paramaterized constructor
	 * @param username
	 * @param password
	 * @param email
	 * @param wallet
	 * @param tickets
	 * @param cart
	 * @param age
	 * @param rewardPoints
	 * @param discountRate
	 * @param employeeID
	 */
	public EmployeeUser(String username, String password, String email, String[] wallet, ArrayList<Ticket> tickets, 
			ArrayList<Ticket> cart, int age, int rewardPoints, double discountRate, String employeeID, Location workplace) {
		super(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate);
		this.employeeID = employeeID;
		this.workplace = workplace;
	}
	
	// getters and setters
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	public Location getLocation() {
		return workplace;
	}
	public void setLocation(Location workplace) {
		this.workplace = workplace;
	}
	
	
}
