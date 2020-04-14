import java.util.ArrayList;

public class VeteranUser extends User {
	private String militaryID;
	
	/**
	 * vertertan user
	 */
	public VeteranUser() {
		username = "vetBob123";
		password = "password";
		email = "vetBob123@email.com";
		wallet = new String[3];
		tickets = new ArrayList<Ticket>();
		cart =  new ArrayList<Ticket>();
		age = 18;
		rewardPoints = 0;
		discountRate = .1;
		militaryID = "123LovetoShoot";
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
	 * @param militaryID
	 */
	public VeteranUser(String username, String password, String email,
			String[] wallet, ArrayList<Ticket> tickets,
			ArrayList<Ticket> cart, int age, int rewardPoints, 
			double discountRate, String militaryID) {
		super(username, password, email, wallet,
				tickets, cart, age, rewardPoints, discountRate);
		this.militaryID = militaryID;
	}
	
	// getters and setters
	public String getMilitaryID() {
		return militaryID;
	}
	public void setMilitaryID(String militaryID) {
		this.militaryID = militaryID;
	}

}
