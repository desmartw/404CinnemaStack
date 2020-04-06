
public class AdminUser extends User {
	public String adminID;
	
	public AdminUser() {
		username = "adminBob123";
		password = "password";
		email = "adminBob123@email.com";
		wallet = new Currency[3];
		tickets = new ArrayList<Ticket>();
		cart =  new ArrayList<Ticket>();
		age = 18;
		rewardPoints = 0;
		discountRate = .1;
		adminID= "123LoveToAdmin";
	}
	
	public AdminUser(String username, String password, String email,
			Currency[] wallet, ArrayList<Ticket> tickets,
			ArrayList<Ticket> cart, int age, int rewardPoints, 
			double discountRate, String adminID) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.wallet = wallet;
		this.tickets = tickets;
		this.cart =  cart;
		this.age = age;
		this.rewardPoints = rewardPoints;
		this.discountRate = discountRate;
		this.adminID = adminID;
	}
	
	//TODO admin abilities :
	// add/delete venue, user, event

}
