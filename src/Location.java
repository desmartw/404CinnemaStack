/**
 * @author Ryan Henderson
 * Location class 
 */

import java.util.ArrayList;

public class Location {
	
	private String name;
	private String description;
	private int seatingRows;
	private int seatingCols;
	private int handicapStartSeat;
	private int handicapEndSeat;
	private ArrayList<Showtime> showtimes;
	
	/**
	 * Default Constructor - empty attributes except password = "empty"
	 */
	public Location() {
		name = "";
		description = "";
		showtimes = new ArrayList<Showtime>();
	}

	/**
	 * Full and Useful Parameterized Constructor
	 * @param name
	 * @param description
	 * @param password
	 * @param showtimes
	 */
	public Location(String name, String description, int seatingRows, int seatingCols, 
			int handicapStartSeat, int handicapEndSeat, ArrayList<Showtime> showtimes) {
		this.name = name;
		this.description = description;
		this.seatingRows = seatingRows;
		this.seatingCols = seatingCols; 
		this.handicapStartSeat = handicapStartSeat;
		this.handicapEndSeat = handicapEndSeat;
		this.showtimes = showtimes;
	}
	/*
	public Location(String name, String description, ArrayList<Showtime> showtimes) {
		this.name = name;
		this.description = description;
		this.showtimes = showtimes;
	}
	*/
	
	public void printLocation() {
		System.out.println("Name: " + name);
		System.out.println("Description: " + description);
		System.out.println("Seat Rows: " + seatingRows);
		System.out.println("Seat Cols: " + seatingCols);
		System.out.println("Starting Handicap Seat: " + handicapStartSeat);
		System.out.println("Ending Handicap Seat: " + handicapEndSeat);
		System.out.print("Showtimes: | ");
		showtimes.forEach(st ->{System.out.print(st + " | ");});
		System.out.println("\n");
	}
	
	// getters and setters
	
	
	public String getName() {
		return name;
	}
	public int getSeatingRows() {
		return seatingRows;
	}

	public void setSeatingRows(int seatingRows) {
		this.seatingRows = seatingRows;
	}

	public int getSeatingCols() {
		return seatingCols;
	}

	public void setSeatingCols(int seatingCols) {
		this.seatingCols = seatingCols;
	}

	public int getHandicapStartSeat() {
		return handicapStartSeat;
	}

	public void setHandicapStartSeat(int handicapStartSeat) {
		this.handicapStartSeat = handicapStartSeat;
	}

	public int getHandicapEndSeat() {
		return handicapEndSeat;
	}

	public void setHandicapEndSeat(int handicapEndSeat) {
		this.handicapEndSeat = handicapEndSeat;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Showtime> getShowtimes() {
		return showtimes;
	}
	public void setShowtimes(ArrayList<Showtime> showtimes) {
		this.showtimes = showtimes;
	}
	
	/**
	 * Adds the passed Showtime to the Location's showtime array list
	 * @param showtime
	 */
	public void addShowtime(Showtime showtime) {
		showtimes.add(showtime);
	}
	
	/**
	 * Clears the showtime array in the Location class
	 */
	public void wipeShowtimes() {
		showtimes = new ArrayList<Showtime>();
	}
	
	/**
	 * Creates a Showtime Object using specified event, time, date, and price and the class's seat values
	 * @param event
	 * @param militaryTime
	 * @param date
	 * @param price
	 * @return Newly created Showtime Object
	 */
	public Showtime createShowtime(Event event, String militaryTime, String date, double price) {
		return (new Showtime(event.getName(), militaryTime, date, price, seatingRows, 
							 seatingCols, handicapStartSeat, handicapEndSeat));
	}
	
	/**
	 * Creates a Showtime Object using specified event, time, date, and price and the class's seat value, then
	 * it adds it to the class's Showtime ArrayList
	 * @param event
	 * @param militaryTime
	 * @param date
	 * @param price
	 */
	public void createAndAddShowtime(Event event, String militaryTime, String date, double price) {
		this.addShowtime(createShowtime(event, militaryTime, date, price));
	}
}
	
	

