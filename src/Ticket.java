
/**
 * @author wilsdesmarteau
 * Abstract base class Ticket
 * Types of ticket: Movie, play, concert
 *
 */
public abstract class Ticket {
	public String name;
	public String seatNumber;
	public int militaryTime;
	public double price;
	protected int ticketNumber;
	
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
	
	public String toString() {
		return "Name: " + name + 
				"Seat number: " + seatNumber +
				"Price: " + price +
				"Time of show (24hr): "+militaryTime+
				"Ticket Number: "+ ticketNumber;
	}

}
