import java.util.ArrayList;

public class EmployeeUser extends User {
	public String employeeID;
	
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
	
	public EmployeeUser(String username, String password, String email,
			Currency[] wallet, ArrayList<Ticket> tickets,
			ArrayList<Ticket> cart, int age, int rewardPoints, 
			double discountRate, String employeeID) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.wallet = wallet;
		this.tickets = tickets;
		this.cart =  cart;
		this.age = age;
		this.rewardPoints = rewardPoints;
		this.discountRate = discountRate;
		this.employeeID = employeeID;
	}

}
