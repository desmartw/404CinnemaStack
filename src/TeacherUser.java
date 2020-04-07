import java.util.ArrayList;

public class TeacherUser extends User {
	public String teacherID;
	/**
	 * Teacher account
	 */
	public TeacherUser() {
		username = "teacherBob123";
		password = "password";
		email = "teacherBob123@email.com";
		wallet = new Currency[3];
		tickets = new ArrayList<Ticket>();
		cart =  new ArrayList<Ticket>();
		age = 18;
		rewardPoints = 0;
		discountRate = .1;
		teacherID= "123LoveToTeach";
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
	 * @param teacherID
	 */
	public TeacherUser(String username, String password, String email,
			Currency[] wallet, ArrayList<Ticket> tickets,
			ArrayList<Ticket> cart, int age, int rewardPoints, 
			double discountRate, String teacherID) {
		super(username, password, email, wallet,
				tickets, cart, age, rewardPoints, discountRate);
		this.teacherID = teacherID;
	}

}
