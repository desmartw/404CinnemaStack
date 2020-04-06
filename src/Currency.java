/**
 * @author wilsdesmarteau
 * Currency class, User has-a currency
 * Types of currency are: Cash, Debit/Credit, Gift card
 */
public class Currency {
	private String type;
	private double ammount;
	
	/**
	 * default constructor
	 */
	public Currency() {
		type = "cash";
		ammount = 69.99;
	}
	/**
	 * @param type
	 * @param ammount
	 */
	public Currency(String type, double ammount) {
		this.type = type;
		this.ammount = ammount;
	}
	
}

