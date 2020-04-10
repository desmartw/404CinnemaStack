import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Ryan Henderson
 * Showtime class holds the location-time-date specific information for Events
 */

public class Showtime {

	private static final int DEFAULT_SEAT_ROWS = 10;
	private static final int DEFAULT_SEAT_COLS = 10;
	
	private String[][] seatingGrid;
	private String eventName;
	private String militaryTime;
	private String date;
	private double price;
	
	/**
	 * Default Constructor
	 */
	public Showtime() {
		eventName = "";
		militaryTime = "";
		date = "";
		price = 0;
		seatingGrid = new String[DEFAULT_SEAT_ROWS][DEFAULT_SEAT_COLS];
	}
	
	/**
	 * Useful Parameterized Constructor
	 * @param eventName
	 * @param militaryTime
	 * @param date
	 * @param price
	 * @param seatingRows
	 * @param seatingCols
	 */
	public Showtime(String eventName, String militaryTime, String date, double price, int seatingRows, int seatingCols,
					int handicapStartSeat, int handicapEndSeat) {
		this.eventName = eventName;
		this.militaryTime = militaryTime;
		this.date = date;
		this.price = price;
		this.setSeatingGrid(seatingRows, seatingCols, handicapStartSeat, handicapEndSeat);
	}
	
	/**
	 * Full Parameterized Constructor
	 * @param eventName
	 * @param militaryTime
	 * @param date
	 * @param price
	 * @param seatingGrid
	 */
	public Showtime(String eventName, String militaryTime, String date, double price, String[][] seatingGrid) {
		this.eventName = eventName;
		this.militaryTime = militaryTime;
		this.date = date;
		this.price = price;
		this.seatingGrid = seatingGrid;
	}
	
	
	/**
	 * Helper method for setSeatingGrid(int,int,int,int)
	 * @param seatNumber - Number of the current seat
	 * @return Formatted String of a seatNumber 
	 */
	private static String formattedSeatNumber(int seatNumber) {
		if (seatNumber < 10) {
			return "00" + seatNumber;
		} else if (seatNumber < 100) {
			return "0" + seatNumber;
		} else {
			return "" + seatNumber;
		}
	}
	public void printShowtime() {
		String ret =  "Name: " + eventName +
				"\nTime: " + militaryTime +
				"\nDate: " + date +
				"\nPrice: "+ price +
				"\nSeating Grid: \n"+
				gridString();
		System.out.println(ret);
	}
	
	public String gridString() {
		String[][] sg = getSeatingGrid();
		String grid = "";
		for (int x = 0; x < sg.length; x++) {
			for (int y = 0; y < sg[x].length; y++) {
				grid += sg[x][y];
			}
			grid += "\n";
		}
		return grid;
	}
	// getters and setters
	// TODO search through event db to get event 
	@JsonIgnore
	public Event getEvent() {
		return new Event();
	}
	// TODO methods to return relevant Event fields corresponding to eventName
	@JsonIgnore
	public int getNumberOfSeats() {
		return seatingGrid[0].length*seatingGrid.length;
	}
	public String[][] getSeatingGrid() {
		return seatingGrid;
	}
	public void setSeatingGrid(String[][] seatingGrid) {
		this.seatingGrid = seatingGrid;
	}
	public void setSeatingGrid(int seatingRows, int seatingCols, int handicapStartSeat, int handicapEndSeat) {
		seatingGrid = new String[seatingRows][seatingCols];
		int seatNumber = 0;
		for (int y = 0; y < seatingRows; y++) {
			for (int x = 0; x < seatingCols; x++) {
				if (seatNumber >= handicapStartSeat && seatNumber <= handicapEndSeat) {
					seatingGrid[y][x] = "{" + formattedSeatNumber(seatNumber) + "}";
				} else {
					seatingGrid[y][x] = "[" + formattedSeatNumber(seatNumber) + "]";
				}
				seatNumber++;
			}
		}
	}
	public void closeSeat(int seatNumber) {
		int seatX = seatNumber % seatingGrid[0].length;
		int seatY = (seatNumber - seatX) / seatingGrid[0].length;
		seatingGrid[seatY][seatX] = seatingGrid[seatX][seatY].substring(0,1) + "XXX" + seatingGrid[seatX][seatY].substring(4);
	}
	public void openSeat(int seatNumber) {
		
	}
	// TODO String returnSeat(seatnumber)
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getMilitaryTime() {
		return militaryTime;
	}
	public void setMilitaryTime(String militaryTime) {
		this.militaryTime = militaryTime;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public static void main(String[] args) {
		Showtime showtime = new Showtime("name", "time", "date", 40, 10, 10, 5, 10);
		showtime.printShowtime();
		showtime.closeSeat(10);
		showtime.closeSeat(3);
		showtime.printShowtime();
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
