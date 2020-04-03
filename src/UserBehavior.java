/**
 * @author Ryan Henderson
 * Specifies the general functionalities that each UserClass should have that
 * will be made specific in their implementation
 */
public interface UserBehavior {

	/**
	 * Specifies the functionality of user classes to empty their
	 * current shopping cart
	 */
	public void emptyCart();
	
	/**
	 * Specifies the functionality of user classes to purchase tickets
	 * @param ticket - ticket to be purchased
	 * @param currency - currency used for purchase
	 * @return boolean value - true if successful purchase, false if unsuccessful
	 */
	public boolean purchaseTicket(Ticket ticket, Currency currency);
	
	/**
	 * Specifies the functionality of user classes to have their
	 * information described as a String
	 * @return Description of the user class
	 */
	public String toString();
}