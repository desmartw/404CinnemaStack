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
	private int rating = 0;
	private int numOfRatings = 0;
	private ArrayList<String> comments;
	private ArrayList<String> dates; //MMDDYYYY
	private Double price;
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
			Double price) {
		this.name = name;
		this.militaryTimes = militaryTimes;
		this.type = type;
		this.rating = rating;
		this.numOfRatings = numOfRatings;
		this.comments = comments2;
		this.dates = dates2;
		this.price = price;
	}
	/**
	 * printEvent method returns all attributes of event 
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
	
	// returns time one element per line
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	// keeps a runnning total of rating
	public void addUserRating(int rating) {
		rating += this.rating;
		this.numOfRatings++;
	}
	// returns the average rating of event
	public int getEventRating() {
		return this.rating/this.numOfRatings;
	}
	// allows user to post a comment to be stored in an arraylist
	public void addUserComment(User user, String comment, ArrayList<String> comments) {
		comments.add("Posted by: "+ user.getUsername() + "\n" + comment);
	}
	
	

}