import java.util.ArrayList;

public class Location {
	
	private String name;
	private String description;
	private String password;
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
		password = "empty";
		showtimes = new ArrayList<Showtime>();
	}

	/**
	 * Full and Useful Parameterized Constructor
	 * @param name
	 * @param description
	 * @param password
	 * @param showtimes
	 */
	public Location(String name, String description, String password, ArrayList<Showtime> showtimes) {
		this.name = name;
		this.description = description;
		this.password = password;
		this.showtimes = showtimes;
	}
	
	// getters and setters
	public String getName() {
		return name;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	@JsonIgnore
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
	
	

