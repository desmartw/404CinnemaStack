
/**
 * @author wilsdesmarteau
 * Abstract base class Ticket
 * Types of ticket: Movie, play, concert
 *
 */
public class Ticket {
	private String name;
	private int seatNumber;
	private String militaryTime;
	private String date;
	private double price;
	
	/**
	 * default const
	 */
	public Ticket() {
		name = "";
		seatNumber= 0;
		militaryTime= "";
		date = "";
		price = 0;
	}	
	/**
	 * Paramaterized constructor
	 * @param name
	 * @param seatNumber
	 * @param price
	 * @param militaryTime
	 * @param ticketNumber
	 */
	public Ticket(String name, int seatNumber, String militaryTime, String date, double price) {
		this.name = name;
		this.seatNumber=seatNumber;
		this.price = price;
		this.militaryTime = militaryTime;
	}
	// Getters and setters
	public String getName() {
		return name;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public double getPrice() {
		return price;
	}
	public String getMilitaryTime() {
		return militaryTime;
	}
	public String getDate() {
		return date;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public void setTicketPrice(double price) {
		this.price = price;
	}
	public void setMilitaryTime(String militaryTime) {
		this.militaryTime = militaryTime;
	}
	public void setDate() {
		this.date = date;
	}
	
	/**
	 * ToString
	 */
	public String toString() {
		return "--------------" + "\nName: " + name + "--------------" +
				"\nSeat number: " + seatNumber +
				"\nPrice: " + price +
				"\nTime of show (24hr): "+militaryTime;
	}

}
