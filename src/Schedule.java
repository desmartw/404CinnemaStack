import java.util.*;

public class Schedule {
	private ArrayList<Event> events; 
	private String genre; // of event list
	private int count; // number of events in list
	private String name; // name of venue
	// private ArrayList<Integer> reviews; removed because Event has rating already
	
	/**
	 * default constructor
	 */
	public Schedule() {
		events = null;
		genre = "comedy";
		count = 0;
		name = "Cinema 10";
	}
	/**
	 * paramaterized const
	 * @param events
	 * @param genre
	 * @param count
	 * @param name
	 */
	public Schedule(ArrayList<Event> events, String genre, int count, String name) {
		this.events = events;
		this.genre = genre;
		this.count = count;
		this.name =  name;
	}
	/**
	 * adds Event to arraylist
	 * @param event
	 */
	public void AddEvent(Event event) {
		this.events.add(event);
		this.count++;
	}
	
	public Schedule sort() {
		// What is this suppoesed to do?
		return null;
	}
	
	

}
