
/**
 * 
 * @author wilsdesmarteau
 * PlayTicket Class, extends ticket 
 * abstract base class
 */
public class PlayTicket extends Ticket {
	/**
	 * Default Constructor
	 */
	public PlayTicket() {
		name = "Frozen the Play";
		seatNumber = "1A";
		price = 39.99;
		militaryTime = 1200;
		ticketNumber = 00231;
	}
	/**
	 * Paramaterized Constructor
	 * @param name
	 * @param seatNumber
	 * @param price
	 * @param militaryTime
	 * @param ticketNumber
	 */
	public PlayTicket(String name, String seatNumber,
			double price, int militaryTime, int ticketNumber) {
		super(name, seatNumber,price, militaryTime,ticketNumber);
	}

	public String toString() {
		return super.toString(); // TODO add extra info for toString
	}
}