/**
 * 
 * @author wilsdesmarteau
 * Class: Event
 *
 */
import java.util.ArrayList;

public class Event {
	private String name;
	private ArrayList<Integer> militaryTimes;
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
		militaryTimes = new ArrayList<Integer>();
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
	 * @param militaryTimes
	 * @param type
	 * @param rating
	 * @param numOfRatings
	 * @param comments
	 * @param dates
	 * @param price
	 */
	public Event(String name, ArrayList<Integer> militaryTimes, String type, int rating, 
			int numOfRatings, ArrayList<String> comments, ArrayList<String> dates, 
			Double price) {
		this.name = name;
		this.militaryTimes = militaryTimes;
		this.type = type;
		this.rating = rating;
		this.numOfRatings = numOfRatings;
		this.comments = comments;
		this.dates = dates;
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
		System.out.println("\nDates: | ");
		dates.forEach(date ->{System.out.print(date + " | ");});
		System.out.println("\nPrice: " + price);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Integer> getMilitaryTimes() {
		return militaryTimes;
	}
	public String printMilitaryTimes() {
		return militaryTimes;
	}
	public void setMilitaryTimes(ArrayList<Integer> militaryTimes) {
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
	//TODO add notifications
	/*
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getMilitaryTime() {
		return militaryTime;
	}
	public void setMilitaryTime(int militaryTime) {
		this.militaryTime = militaryTime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public ArrayList<String> getActors() {
		return actors;
	}
	public void setActors(ArrayList<String> actors) {
		this.actors = actors;
	}
	*/
	
	

}
