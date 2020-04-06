
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
	
	public PlayTicket(String name, String seatNumber,
			double price, int militaryTime, int ticketNumber) {
		this.name = name;
		this.seatNumber = seatNumber;
		this.price = price;
		this.militaryTime = militaryTime;
		this.ticketNumber = ticketNumber;
	}

}