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
		wallet = new Currency[2];
		tickets = new ArrayList<Ticket>();
		cart =  null;
		age = 0;
		rewardPoints = 0;
		discountRate = 0; 
	}
	
	public GuestUser(int age, Currency[] wallet, ArrayList<Ticket> tickets) {
		this.age = age;
		this.wallet = wallet;
		this.tickets = tickets;
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> ccaaf57be8b03cf3b2e5a711f2684079bc491989
