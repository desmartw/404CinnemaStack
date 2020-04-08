
import java.util.ArrayList;
/**
 * @author wilsdesmarteau
 * 
 */
public class AdminUser extends User {
	public String adminID;
	
	/*
	 * Default Constructor
	 */
	public AdminUser() {
		username = "adminBob123";
		password = "password";
		email = "adminBob123@email.com";
		wallet = new String[3];
		tickets = new ArrayList<Ticket>();
		cart =  new ArrayList<Ticket>();
		age = 18;
		rewardPoints = 0;
		discountRate = .1;
		adminID= "123LoveToAdmin";
	}
	/*
	 * Parameterized COnstructor
	 */
	public AdminUser(String username, String password, String email,
			String[] wallet, ArrayList<Ticket> tickets,
			ArrayList<Ticket> cart, int age, int rewardPoints, 
			double discountRate, String adminID) {
		super(username, password, email, wallet,
				tickets, cart, age, rewardPoints, discountRate);
		this.adminID = adminID;
	}
	
	//TODO admin abilities :
	// add/delete venue, user, event

}
