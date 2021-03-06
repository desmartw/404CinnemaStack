import java.util.ArrayList;

public class GuestUser extends User {
	
	/**
	 * Guest user is anonymous
	 * Only has age wallet and purchased tickets
	 */
	public GuestUser() {
		username = null;
		password = null;
		email = null;
		wallet = new String[3];
		tickets = new ArrayList<Ticket>();
		cart =  null;
		age = 0;
		rewardPoints = 0;
		discountRate = 0; 
	}
	
	/**
	 * Sets up a guest user account
	 * @param age
	 * @param wallet
	 * @param tickets
	 */
	public GuestUser(int age, String[] wallet, ArrayList<Ticket> tickets) {
		this.age = age;
		this.wallet = wallet;
		this.tickets = tickets;
	}
	/**
	 * returns type 
	 */
	public String getType() {
		return "guest";
	}

}