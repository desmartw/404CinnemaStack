import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatabaseDriver {
	public static Scanner scan = new Scanner(System.in);
	public static EventDatabase ev = new EventDatabase();
	public static EventDatabaseReborn evr = new EventDatabaseReborn(); ///
	public static LocationDatabase lv = new LocationDatabase();
	public static ScheduleDatabase sv = new ScheduleDatabase();
	public static UserDatabase uv = new UserDatabase();
	
	/***** NEW STUFF ***/
	
	/**
	 * static method to manipulate Event database reborn
	 */
	public static void enterEvent() {
		evr.enterEvent();
	}
	/**
	 * static method to return all Events and their attributes
	 */
	public static void readAllEvents() {
		evr.readList();
	}
	/**
	 * static method to manipulate Event database reborn
	 */
	public static void addRating() {
		evr.addRating();
	}
	/**
	 * static method to manipulate Event database reborn
	 */
	
	public static void addComment() {
		evr.addComment();
	}
	/**
	 * static method to wipe Event database reborn
	 */
	public static void wipeEventDatabase() {
		evr.wipeDatabase();
	}
	
	public static Event returnEvent() {
		return evr.returnEventObjectByName();
	}
	
	public static String returnEventName() {
		return (evr.returnEventObjectByName()).getName();
	}
	
	public static String validateMilitaryTime() {
		return evr.validateMilitaryTime();
	}
	
	public static String validateDate() {
		return evr.validateDate();
	}
	
	public static Double validatePrice() {
		return evr.validatePrice();
	}
	/**
	 * allows new location to be created in LDB
	 */
	public static void enterLocation() {
		lv.enterLocation();
	}
	/**
	 * reads all location from LDB
	 */
	public static void readAllLocations() {
		lv.readList();
	}
	
	public static Location enterNameAndReturnLocation() {
		return lv.enterNameAndReturnLocation();
	}
	
	// employee.getLocation() for location
	public static void enterShowtime(String location) {
		lv.enterShowtime(location);
	}
	
	public static Location returnLocationWithEvent(String event) {
		return lv.returnLocationWith(event);
		
	}
	
	/***** END NEW STUFF ***/
	
	// print all the attributes of all events
	public static void printAllEvents() {
		ev.readAllEvents();
	}
	/**
	 * @return arraylist of events
	 */
	public static ArrayList<Event> returnAllEventsAsArrayList() {
		return ev.returnAllEventsAsArrayList();
	}
	
	/**
	 *  allows creation of event in event DB
	 */
	public static void enterNewEvent() {
		ev.enterEvent();
	}
	/**
	 * creates an event with a new location in EvnetDB
	 * @param loc
	 */
	public static void enterNewEventWithLocation(String loc) {
		
		ev.enterEvent(loc);
	}
	
	/*
	/**
	 * clears EVDB
	 *
	public static void wipeEventDatabase() {
		ev.wipeDatabase();
	}
	*/
	
	/**
	 * returns event by name
	 * @param name
	 * @return
	 */
	public static Event returnEvent(String name) {
		return ev.returnEventObjectByName(name);
	}
	
	/**
	 * prints events from EVBD
	 */
	public static void displayAllEvents() {
		ev.readAllEventsForUser();
	}
	
	/**
	 * adds a comment to the EVDB
	 * @param eventName
	 * @param comment
	 */
	public static void enterComment(String eventName, String comment) {
		ev.addCommentToEvent(eventName, comment);
		System.out.println("Comment saved.");
	}
	
	/**
	 * allows rating to be entered to eventDB
	 */
	public static void enterRating() {
		String name = "";
		ArrayList<String> names = ev.getAllEventNames();
		while(true) {
			System.out.println("Enter the name of your event:");
			name = scan.nextLine();
			if (names.contains(name)) 
				break;
			else 
				System.out.println("Event does not exist.");
		}
		int rating;
		do {
			System.out.println("Enter a number between 0 and 5 to rate " + name + ".");
			while (!scan.hasNextInt()) {
	            String input = scan.next();
	            System.out.printf("\"%s\" is not a valid number.\n", input);
			}
			rating = scan.nextInt();
			scan.nextLine();
		} while (rating < 0 || rating > 5);
		String ratingStr = String.valueOf(rating);
		ev.addRatingToEvent(name, ratingStr);
		System.out.println("Rating saved.");
	}
	
	/**
	 * allows creation of new schedule in SDB
	 */
	public static void enterNewSchedule() {
		sv.enterSchedule();
	}
	/**
	 * prints all schedules in SDB
	 */
	public static void printAllSchedules() {
		sv.readAllSchedules();
	}
	
	/**
	 * allos adding new user to UDB
	 */
	public static void addUser() {
		uv.enterUser();
	}
	/**
	 * wipes UDB
	 */
	public static void wipeUserDatabase() {
		uv.wipeDatabase();
	}
	/**
	 * prints credentials
	 */
	public static void printCredentials() {
		uv.readAllCredentials();
	}

	
	
	
	// find an event based on its name, return an Event object
	public static void main(String[] args) {
		//wipeDatabase();
		//enterEvent();
		
		//readList();
		//addRating();
		
		
		//evr.returnEventObjectByName();
		//addRating();
		//addRating();
		//readList();
		//addComment();
		//readList();
		
		//location
		//enterLocation();
		//readAllLocations();
		
		//user
		//uv.wipeDatabase();
		//addUser();
		//printCredentials();
		
		//readAllLocations();
		enterLocation();
		enterShowtime("Cinema 12");
		enterShowtime("Cinema 12");
		//readAllLocations();
		
		//System.out.println(returnLocationWithEvent("Batman").getName());
		
		//wipeEventDatabase();
		
		//enterEvent();
		//enterEvent();
		//enterEvent();
		
		//readAllEvents();
	}

}