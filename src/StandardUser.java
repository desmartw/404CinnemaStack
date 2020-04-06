import java.util.ArrayList;
public class StandardUser extends User{
	public String ID;
	
	public StandardUser() {
		username = "";
		password = "";
		email = "";
		wallet = new Currency[3];
		tickets = new ArrayList<Ticket>();
		cart =  new ArrayList<Ticket>();
		age = 0;
		rewardPoints = 0;
		discountRate = 0;
		ID = "";
	}
	
	public StandardUser(String username, String password, String email,
			Currency[] wallet, ArrayList<Ticket> tickets,
			ArrayList<Ticket> cart, int age, int rewardPoints, 
			double discountRate, String ID) {
		super(username, password, email, wallet,
				tickets, cart, age, rewardPoints, discountRate);
		this.ID = ID;
	}
}
