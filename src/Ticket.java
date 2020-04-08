
/**
 * @author wilsdesmarteau
 * Abstract base class Ticket
 * Types of ticket: Movie, play, concert
 *
 */
public abstract class Ticket {
	private String name;
	private String seatNumber;
	private int militaryTime;
	private double price;
	protected int ticketNumber;
	
	/**
	 * default const
	 */
	public Ticket() {
		name = "";
		seatNumber="";
		militaryTime= 0;
		price = 0;
		ticketNumber = 0;
	}	
	/**
	 * Paramaterized constructor
	 * @param name
	 * @param seatNumber
	 * @param price
	 * @param militaryTime
	 * @param ticketNumber
	 */
	public Ticket(String name, String seatNumber, double price, 
			int militaryTime,int ticketNumber) {
		this.name = name;
		this.seatNumber=seatNumber;
		this.price = price;
		this.militaryTime = militaryTime;
		this.ticketNumber = ticketNumber;
	}
	// Getters and setters
	public String getName() {
		return name;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public double getPrice() {
		return price;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public int getMilitaryTime() {
		return militaryTime;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public void setTicketPrice(double price) {
		this.price = price;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public void setMilitaryTime(int militaryTime) {
		this.militaryTime = militaryTime;
	}
	
	/**
	 * ToString
	 */
	public String toString() {
		return "--------------" + "\nName: " + name + "--------------" +
				"\nSeat number: " + seatNumber +
				"\nPrice: " + price +
				"\nTime of show (24hr): "+militaryTime+
				"\nTicket Number: "+ ticketNumber;
	}

}
