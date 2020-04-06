/**
 * 
 * @author wilsdesmarteau
 * ConcertTicket Class, extends ticket 
 * abstract base class
 */
public class ConcertTicket extends Ticket {
	/**
	 * Default Constructor
	 */
	public ConcertTicket() {
		name = "Shek Wes";
		seatNumber = "1A";
		price = 99.99;
		militaryTime = 1200;
		ticketNumber = 00231;
	}
	public ConcertTicket(String name, String seatNumber,
			double price, int militaryTime, int ticketNumber) {
		this.name = name;
		this.seatNumber = seatNumber;
		this.price = price;
		this.militaryTime = militaryTime;
		this.ticketNumber = ticketNumber;
	}


}