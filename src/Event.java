/**
 * 
 * @author wilsdesmarteau
 * Class: Event
 *
 */
import java.util.ArrayList; //Importing arraylist class
public class Event {
	private String name;
	private String location;
	private int militaryTime;
	private String genre;
	private ArrayList<String> actors;
	/**
	 * Default constructor
	 */
	public Event() {
		name = "mars movies";
		location = "mars";
		militaryTime = 1100;
		genre = "Comedy";
		actors = new ArrayList<String>();
	}
	/**
	 * Parameterized constructor
	 * @param name
	 * @param location
	 * @param militaryTime
	 * @param genre
	 * @param actors
	 */
	public Event(String name, String location,
			int militaryTime, String genre, 
			ArrayList<String> actors) {
		this.name = name;
		this.location = location;
		this.militaryTime = militaryTime;
		this.genre = genre;
		this.actors = actors;
	}
	/**
	 * ToString method returns all attributes of 
	 * event 
	 */
	public String toString() {
		return("Name of event: "+ name +
				"Location: "+ location+
				"Time (24hr): "+ militaryTime +
				"Genere: "+ genre +
				"Actors: "+ actors);
	}
	//TODO add notifications
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
	
	

}
