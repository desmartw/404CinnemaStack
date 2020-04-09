/**
 * 
 * @author wilsdesmarteau
 * Class: Event
 *
 */
import java.util.ArrayList;
import java.util.List;

public class Event {
	public static final int ROWS = 5;
	public static final int COLUMNS = 5;
	private String name;
	private ArrayList<String> militaryTimes;
	private String type;
	private int rating = 0;
	private int numOfRatings = 0;
	private ArrayList<String> comments;
	private ArrayList<String> dates; //MMDDYYYY
	private double price;
	private String [][] seatingGrid;

	/**
	 * Default constructor
	 */
	public Event() {
		name = "";
		militaryTimes = new ArrayList<String>();
		type = "";
		rating = 0;
		numOfRatings = 0;
		comments = new ArrayList<String>();
		dates = new ArrayList<String>();
		price = 0.0;
		seatingGrid = new String[COLUMNS][ROWS];
	}
	
	/**
	 * Parameterized constructor
	 * @param name
	 * @param militaryTimes2
	 * @param type
	 * @param rating
	 * @param numOfRatings
	 * @param comments2
	 * @param dates2
	 * @param price
	 */
	public Event(String name, ArrayList<String> militaryTimes, String type, int rating, 
			int numOfRatings, ArrayList<String> comments2, ArrayList<String> dates2, 
			double price) {
		this.name = name;
		this.militaryTimes = militaryTimes;
		this.type = type;
		this.rating = rating;
		this.numOfRatings = numOfRatings;
		this.comments = comments2;
		this.dates = dates2;
		this.price = price;
		this.seatingGrid = new String[COLUMNS][ROWS];

	}
	
	/**
	 * printEvent method returns all attributes of this event 
	 */
	public void printEvent() {
		System.out.println("\nName of event: "+ name);
		System.out.print("Times: | ");
		militaryTimes.forEach(militaryTime ->{System.out.print(militaryTime + " | ");});
		System.out.println("\nType: " + type);
		System.out.println("Rating: " + rating);
		System.out.println("Number of ratings: " + numOfRatings);
		System.out.println("Rating: " + rating);
		System.out.print("Comments: | ");
		comments.forEach(comment ->{System.out.print(comment + " | ");});
		System.out.print("\nDates: | ");
		dates.forEach(date ->{System.out.print(date + " | ");});
		System.out.println("\nPrice: " + price);
	}
	
	/**
	 * This function prints out the times the event is happening in military time
	 */
	public void printMilitaryTimes() {
		for(int i =0; i<militaryTimes.size(); i++) {
			System.out.println(militaryTimes.get(i)+"\n");
		}
	}
	
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getMilitaryTimes() {
		return militaryTimes;
	}
	public void setMilitaryTimes(ArrayList<String> militaryTimes) {
		this.militaryTimes = militaryTimes;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getNumOfRatings() {
		return numOfRatings;
	}
	public void setNumOfRatings(int numOfRatings) {
		this.numOfRatings = numOfRatings;
	}
	public ArrayList<String> getComments() {
		return comments;
	}
	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}
	public ArrayList<String> getDates() {
		return dates;
	}
	public void setDates(ArrayList<String> dates) {
		this.dates = dates;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * This function adds a rating to the running average
	 * @param rating - new rating to be added to the average rating
	 */
	public void addUserRating(int rating) {
		rating += this.rating;
		this.numOfRatings++;
	}
	// returns the average rating of event
	public int getEventRating() {
		if (this.numOfRatings == 0) return 0;
		return this.rating/this.numOfRatings;
	}
	
	/**
	 * Adds a user's comment to the list of comments held in this event
	 * @param user - User who makes the comment
	 * @param comment - String of what the user wants to comment
	 */
	public void addUserComment(User user, String comment) {
		comments.add("Posted by: "+ user.getUsername() + "\n" + comment);
	}
	
	/*
	 * fills the seatGrid with [X] for display
	 */
	public void setSeatGrid() {
		for(int i =0; i < ROWS; i++) {
			for(int j =0; j < COLUMNS; j++) {
				seatingGrid[i][j] = "[X]";
			}
		}
	}
	/*
	 * prints the seat grid for seat selection
	 */
	public void showSeatGrid(String[][] seatGrid) {
		for(int i =0; i < ROWS; i++) {
			for(int j =0; j < COLUMNS; j++) {
				System.out.println(seatGrid[i][j]);
			}
		}
	}
	
	

}