
/**
 * @author wilsdesmarteau
 * Abstract base class Ticket
 * Types of ticket: Movie, play, concert
 *
 */
public abstract class Ticket {
	public String name;
	public String seatNumber;
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
	
	public String toString() {
		return "Name: " + name + 
				"Seat number: " + seatNumber +
				"Price: " + price +
				"Ticket Number: "+ ticketNumber;
	}

}
