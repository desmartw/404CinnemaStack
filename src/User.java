
import java.util.ArrayList;
import java.util.Scanner;

public abstract class User {
	public static final double SALES_TAX = 0.07;
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
	public void addToCart(Ticket ticket) {
		cart.add(ticket);
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
	 * Sets the cart to an empty ArrayList<Ticket>
	 */
	public void emptyCart() {
		cart = new ArrayList<Ticket>(); 
	}
	
	/**
	 * Returns the type of the user
	 * @return String - type of the user
	 */
	public String getType() {
		UserDatabase db = new UserDatabase();
		return db.getType(this.username);
	}
	
	/**
	 * Returns a value for the total cost of the user's cart with discounts and tax included
	 * @return double - total cost of the cart
	 */
	public double getCartTotal() {
		double cost = 0;
		if (cart.isEmpty()) {
			return cost;
		} else {
			for (int i=0; i < cart.size(); i++) {
				cost += cart.get(i).getPrice();
			}
			return cost*(1.0-discountRate)*(1.0+SALES_TAX);
		}
	}
	
	/**
	 * Returns a value for the cost fo the user's cart before tax
	 */
	public double getCartSubTotal() {
		double cost = 0;
		if (cart.isEmpty()) {
			return cost;
		} else {
			for (int i=0; i < cart.size(); i++) {
				cost += cart.get(i).getPrice();
			}
			return cost*(1.0-discountRate);
		}
	}
	
	/**
	 * Prints out the account details of this user, including their wallet, cart, and purchased tickets
	 */
	public void viewAccount() {
		System.out.println("-------------------------------------------------------");
		System.out.println("          " + username);
		System.out.println("-------------------------------------------------------\n");
		System.out.println("Type of Account: " + this.getType());
		System.out.println("Email: " + email);
		System.out.println("Age: " + age);
		System.out.println("Cool Points " + rewardPoints + " Cool Points");
		System.out.println("Discount Rate: " + discountRate*100 + "%\n");
		viewWallet();
		System.out.println();
		viewCart();
		System.out.println();
		viewTickets();
		System.out.println();
	}
	
	/**
	 * Prints out any tickets within the user's shopping cart
	 */
	public void viewCart() {
		System.out.println("-------------------------------------------------------");
		System.out.println("                    Shopping Cart");
		System.out.println("-------------------------------------------------------\n");
		if (cart.isEmpty()) {
			System.out.println("Empty");
		}
		for (int i = 0; i < cart.size(); i++) {
			System.out.println("Ticket:");
			System.out.println(cart.get(i).toString());
		}
		System.out.println();
	}
	
	/**
	 * Prints out any purchased tickets the user owns
	 */
	public void viewTickets() {
		System.out.println("-------------------------------------------------------");
		System.out.println("                  Purchased Tickets");
		System.out.println("-------------------------------------------------------\n");
		if (tickets.isEmpty()) {
			System.out.println("Empty");
		}
		for (int i = 0; i < tickets.size(); i++) {
			System.out.println("Ticket:");
			System.out.println(tickets.get(i).toString());
		}
		System.out.println();
	}
	
	/**
	 * Prints out the card slots in the user's wallet
	 */
	public void viewWallet() {
		for (int i = 0; i < wallet.length; i++) {
			System.out.print("Slot " + i + ": ");
			if (wallet[i] == null) {
				System.out.println("Empty");
			} else {
				System.out.println(wallet[i]);
			}
		}
	}
	
	/** 
	 * Purchases whatever tickets are within the user's shopping cart
	 */
	public void purchaseTickets() {
		Scanner in = new Scanner(System.in);
		String cardNum = "";
		System.out.println("Purchasing your cart!!");
		System.out.println();
		System.out.println("Choose payment option, if you choose an empty slot, don't worry!");
		System.out.println("We will simply then ask for your payment information. Now enter\n"
				          +"the slot number you choose to proceed with:");
		viewWallet();
		int choice = Driver.getValidatedChoice(3);
		if(wallet[choice] != null) {
			printReceipt(choice);
		} else {
			System.out.println("You need to add a payment method! ");
			System.out.println("Enter your 16 digit card number with no spaces or dashes: ");
			while(true) {
				cardNum = in.nextLine();
				if(!(cardNum.length() == 16)) {
					System.out.println("Please enter exactly 16 digits of just the card's numbers");
					continue;
				}
				if(!(cardNum.matches("[0-9]+"))) {
					System.out.println("Please only enter numbers");
					continue;
				}
				printReceipt(choice);
				break;
			}
		}
		System.out.println("Success! Emptying your cart to tickets now ... ");
		tickets.addAll(cart);
		cart = new ArrayList<Ticket>();
	}
	private void printReceipt(int walletSlot) {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("~                       Printing Receipt        ~");
		System.out.println(" Charging card XXXX XXXX XXXX " + wallet[walletSlot].substring(wallet[walletSlot].length()-4));
		for (int i = 0; i < cart.size(); i++) {
			cart.get(i).toString();
		}
		System.out.println(" Cart subtotal: " + getCartSubTotal());
		System.out.println(" Cart total: " + getCartTotal());
		System.out.println("~                       Printing Done           ~");
		System.out.println("-----------------------------------------------------------------");
	}
}
