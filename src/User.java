
import java.util.ArrayList;

public abstract class User {
	protected String password;
	protected String username;
	protected String email;
	protected String[] wallet;
	protected ArrayList<Ticket> tickets;
	protected ArrayList<Ticket> cart;
	protected int age;
	protected int rewardPoints;
	protected double discountRate;
	
	/**
	 * Base user class
	 */
	public User() {
		username = "bob123";
		password = "password";
		email = "bob123@email.com";
		wallet = new String[3];
		tickets = new ArrayList<Ticket>();
		cart =  new ArrayList<Ticket>();
		age = 18;
		rewardPoints = 0;
		discountRate = .1;
	}
	/**
	 * Parameterized constructor
	 * @param username
	 * @param password
	 * @param email
	 * @param wallet
	 * @param tickets
	 * @param cart
	 * @param age
	 * @param rewardPoints
	 * @param discountRate
	 */
	public User(String username, String password, String email,
			String[] wallet, ArrayList<Ticket> tickets,
			ArrayList<Ticket> cart, int age, int rewardPoints, 
			double discountRate) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.wallet = wallet;
		this.tickets = tickets;
		this.cart =  cart;
		this.age = age;
		this.rewardPoints = rewardPoints;
		this.discountRate = discountRate;
	}
	
	//Getters and setters
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String[] getWallet() {
		return wallet;
	}
	public void setWallet(String[] wallet) {
		this.wallet = wallet;
	}
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public ArrayList<Ticket> getCart() {
		return cart;
	}
	public void setCart(ArrayList<Ticket> cart) {
		this.cart = cart;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	
	/**
	 * empties the array list cart
	 */
	public void emptyCart() {
		this.cart = null; 
	}
	
	/**
	 * Returns type of user
	 * @return
	 */
	public String getType() {
		UserDatabase db = new UserDatabase();
		return db.getType(this.username);
	}
	
	
}
