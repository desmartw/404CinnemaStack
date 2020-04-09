/**
 * 
 * @author wilsdesmarteau
 * Class: Event
 *
 */
import java.util.ArrayList;
import java.util.List;

public class Event {
	
	private String name;
	private ArrayList<String> militaryTimes;
	private String type;
	private int sumOfRatings;
	private int numOfRatings;
	private ArrayList<String> comments;
	private ArrayList<String> dates; //MMDDYYYY
	private double price;
	private int numRows;
	private int numCols;
	//@someignorething dont know it yet
	private String [][] seatingGrid;
	
	/**
	 * Parameterized Constructor
	 * @param name
	 * @param militaryTimes
	 * @param type
	 * @param sumOfRatings
	 * @param numOfRatings
	 * @param comments
	 * @param dates2
	 * @param price
	 */
	
	 public Event()
	    {
	     super();
	    }
	public Event(String name, ArrayList<String> militaryTimes, String type, int sumOfRatings, 
			int numOfRatings, ArrayList<String> comments, ArrayList<String> dates2, 
			double price) {
		this.name = name;
		this.militaryTimes = militaryTimes;
		this.type = type;
		this.sumOfRatings = sumOfRatings;
		this.numOfRatings = numOfRatings;
		this.comments = comments;
		this.dates = dates2;
		this.price = price;
		this.seatingGrid = new String[numCols][numRows];

	}
	
	public void setSumOfRatings(int sumOfRatings) {
		this.sumOfRatings = sumOfRatings;
	}
	public int getNumRows() {
		return numRows;
	}
	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}
	public int getNumCols() {
		return numCols;
	}
	public void setNumCols(int numCols) {
		this.numCols = numCols;
	}
	public String[][] getSeatingGrid() {
		return seatingGrid;
	}
	public void setSeatingGrid(String[][] seatingGrid) {
		this.seatingGrid = seatingGrid;
	}
	/**
	 * printEvent method returns all attributes of this event 
	 */
	public void printEvent() {
		System.out.println("\nName of event: "+ name);
		System.out.print("Times: | ");
		militaryTimes.forEach(militaryTime ->{System.out.print(militaryTime + " | ");});
		System.out.println("\nType: " + type);
		System.out.println("Rating: " + sumOfRatings);
		System.out.println("Number of ratings: " + numOfRatings);
		System.out.println("Rating: " + sumOfRatings);
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
		return sumOfRatings;
	}
	public void setRating(int sumOfRatings) {
		this.sumOfRatings = sumOfRatings;
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
	public void addUserRating(int sumOfRatings) {
		sumOfRatings += this.sumOfRatings;
		this.numOfRatings++;
	}
	// returns the average rating of event
	public int getSumOfRatings() {
		if (this.numOfRatings == 0) return 0;
		return this.sumOfRatings/this.numOfRatings;
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
	 * fills the seatGrid with [X] for display, middle row is always reserved for handicap
	 */
	public void setSeatGrid() {
		for(int y =0; y < numRows; y++) {
			for(int x =0; x < numCols; x++) {
				if(y == numCols/2) 
					seatingGrid[x][y] = "[H]";
				seatingGrid[x][y] = "[X]";
			}
		}
	}
	
	/*
	 * prints the seat grid for seat selection
	 */
	public void showSeatGrid(String[][] seatGrid) {
		for(int y =0; y < numRows; y++) {
			for(int x =0; x < numCols; x++) {
				System.out.print(seatingGrid[x][y]);
			}
			System.out.println();
		}
	}
}