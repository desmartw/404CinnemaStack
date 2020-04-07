import java.util.ArrayList;

public class StudentUser extends User {
	public String studentIDNum;
	
	/**
	 * Student user
	 */
	public StudentUser() {
		username = "studentBob123";
		password = "password";
		email = "studentBob123@email.com";
		wallet = new Currency[3];
		tickets = new ArrayList<Ticket>();
		cart =  new ArrayList<Ticket>();
		age = 18;
		rewardPoints = 0;
		discountRate = .1;
		studentIDNum= "123LoveToStudy";
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
	 * @param studentIDNum
	 */
	public StudentUser(String username, String password, String email,
			Currency[] wallet, ArrayList<Ticket> tickets,
			ArrayList<Ticket> cart, int age, int rewardPoints, 
			double discountRate, String studentIDNum) {
		super(username, password, email, wallet,
				tickets, cart, age, rewardPoints, discountRate);
		this.studentIDNum = studentIDNum;
	}

}
