
/**
 * 
 * @author wilsdesmarteau
 * MovieTicket Class, extends ticket 
 * abstract base class
 */
public class MovieTicket extends Ticket {
	/**
	 * Default Constructor
	 */
	public MovieTicket() {
		name = "Frozen 3";
		seatNumber = "1A";
		price = 9.99;
		militaryTime = 1200;
		ticketNumber = 00231;
	}
	/**
	 * Paramaterized constructor
	 * @param name
	 * @param seatNumber
	 * @param price
	 * @param militaryTime
	 * @param ticketNumber
	 */
	public MovieTicket(String name, String seatNumber,
			double price, int militaryTime, int ticketNumber) {
		super(name, seatNumber,price, militaryTime,ticketNumber);
	}

	public String toString() {
		return super.toString(); // TODO add extra info for toString
	}
}
