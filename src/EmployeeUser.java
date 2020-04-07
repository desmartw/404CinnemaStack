import java.util.ArrayList;

public class EmployeeUser extends User {
	public String employeeID;
	/*
	 * Default constructor
	 */
	public EmployeeUser() {
		username = "employedBob123";
		password = "password";
		email = "employedBob123@email.com";
		wallet = new Currency[3];
		tickets = new ArrayList<Ticket>();
		cart =  new ArrayList<Ticket>();
		age = 18;
		rewardPoints = 0;
		discountRate = .1;
		employeeID = "123LoveToWork";
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
	public EmployeeUser(String username, String password, String email,
			Currency[] wallet, ArrayList<Ticket> tickets,
			ArrayList<Ticket> cart, int age, int rewardPoints, 
			double discountRate, String employeeID) {
		super(username, password, email, wallet,
				tickets, cart, age, rewardPoints, discountRate);
		this.employeeID = employeeID;
	}

}
