import java.util.ArrayList;

public class VeteranUser extends User {
	public String militaryID;
	
	public VeteranUser() {
		username = "vetBob123";
		password = "password";
		email = "vetBob123@email.com";
		wallet = new Currency[3];
		tickets = new ArrayList<Ticket>();
		cart =  new ArrayList<Ticket>();
		age = 18;
		rewardPoints = 0;
		discountRate = .1;
		militaryID = "123LovetoShoot";
	}
	
	public VeteranUser(String username, String password, String email,
			Currency[] wallet, ArrayList<Ticket> tickets,
			ArrayList<Ticket> cart, int age, int rewardPoints, 
			double discountRate, String militaryID) {
		super(username, password, email, wallet,
				tickets, cart, age, rewardPoints, discountRate);
		this.militaryID = militaryID;
	}

}
