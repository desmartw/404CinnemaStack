import java.util.ArrayList;
public class StandardUser extends User{
	public String ID;
	/**
	 * User with no discount rate
	 * does not fit in any other category
	 */
	public StandardUser() {
		username = "";
		password = "";
		email = "";
		wallet = new String[3];
		tickets = new ArrayList<Ticket>();
		cart =  new ArrayList<Ticket>();
		age = 0;
		rewardPoints = 0;
		discountRate = 0;
		ID = "";
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
	 * @param ID
	 */
	public StandardUser(String username, String password, String email,
			String[] wallet, ArrayList<Ticket> tickets,
			ArrayList<Ticket> cart, int age, int rewardPoints, 
			double discountRate, String ID) {
		super(username, password, email, wallet,
				tickets, cart, age, rewardPoints, discountRate);
		this.ID = ID;
	}
}
