/**
 * 
 * @author wilsdesmarteau && Ryan Henderson
 * Class: Event
 *
 */
import java.util.ArrayList;
import java.util.List;

public class Event {
	
	private String name;
	private String type;
	private int ratingSum;
	private int ratingNum;
	private ArrayList<String> comments;
	private ArrayList<String> dates;
	private ArrayList<String> actors;
	
	/**
     * Default Constructor - all attributes are set to empty, int values are 0
     */
	public Event()
	{
	    name = "";
	    type = "";
	    ratingSum = 0;
	    ratingNum = 0;
	    comments = new ArrayList<String>();
	    dates = new ArrayList<String>();
	    actors = new ArrayList<String>();
	}
	
	/**
     * Basic Parameterized Constructor - Initializes values that stay constant across venues
     * @param name
     * @param type
     * @param actors
     */
    public Event(String name, String type, ArrayList<String> comments, ArrayList<String> actors) {
        this.name = name;
        this.type = type;
        this.comments = comments;
        this.actors = actors;
    }
	
    /**
	 * Full Parameterized Constructor
	 * @param name
	 * @param type
	 * @param ratingSum
	 * @param ratingCount
	 * @param militaryTimes
	 * @param comments
	 * @param dates
	 * @param price
     */
	public Event(String name, String type, int ratingSum, int ratingNum, ArrayList<String> comments,
	             ArrayList<String> dates, ArrayList<String> actors) {
	    this.name = name;
	    this.type = type;
	    this.ratingSum = ratingSum;
	    this.ratingNum = ratingNum;
        this.comments = comments;
	    this.dates = dates; 	        
	    this.actors = actors;
	}
	
	// TODO for prettify stage
	/**
	 * printEvent method returns all attributes of this event 
	 *
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
	}*/
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRatingSum() {
		return ratingSum;
	}
	public void setRatingSum(int ratingSum) {
		this.ratingSum = ratingSum;
	}
	public int getRatingNum() {
		return ratingNum;
	}
	public void setRatingNum(int ratingNum) {
		this.ratingNum = ratingNum;
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
	public ArrayList<String> getActors() {
		return actors;
	}
	public void setActors(ArrayList<String> actors) {
		this.actors = actors;
	}
	
	/**
	 * This function adds a rating to the running average
	 * @param rating - new rating to be added to the average rating
	 */
	public void addUserRating(int ratingSum) {
		ratingSum += this.ratingSum;
		this.ratingNum++;
	}
	
	/**
	 * 
	 * @return double value of average rating 
	 */
	public double getAverageRating() {
		if (this.ratingNum == 0) return 0;
		return (double) (this.ratingSum/this.ratingNum);
	}
	
	/**
	 * Adds a user's comment to the list of comments held in this event
	 * @param user - User who makes the comment
	 * @param comment - String of what the user wants to comment
	 */
	public void addUserComment(User user, String comment) {
		comments.add("Posted by: "+ user.getUsername() + "\n" + comment);
	}
}