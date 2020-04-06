
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
	public MovieTicket(String name, String seatNumber,
			double price, int militaryTime, int ticketNumber) {
		this.name = name;
		this.seatNumber = seatNumber;
		this.price = price;
		this.militaryTime = militaryTime;
		this.ticketNumber = ticketNumber;
	}

}
