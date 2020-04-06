import java.util.ArrayList;

public class HandicappedUser extends User {
	public String handicappedTagNum;
	
	public HandicappedUser() {
		username = "handicappedBob123";
		password = "password";
		email = "handicappedBob123@email.com";
		wallet = new Currency[3];
		tickets = new ArrayList<Ticket>();
		cart =  new ArrayList<Ticket>();
		age = 18;
		rewardPoints = 0;
		discountRate = .1;
		handicappedTagNum = "123CantWalk";
	}
	
	public HandicappedUser(String username, String password, String email,
			Currency[] wallet, ArrayList<Ticket> tickets,
			ArrayList<Ticket> cart, int age, int rewardPoints, 
			double discountRate, String handicappedTagNum) {
		super(username, password, email, wallet,
				tickets, cart, age, rewardPoints, discountRate);
		this.handicappedTagNum = handicappedTagNum;
	}

}
