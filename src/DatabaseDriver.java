import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatabaseDriver {
	public static Scanner scan = new Scanner(System.in);
	public static EventDatabaseReborn evr = new EventDatabaseReborn();
	public static LocationDatabase lv = new LocationDatabase();
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
	
	public static Location returnLocation(String name) {
		return lv.returnLocation(name);
	}
	
	// employee.getLocation() for location
	public static void enterShowtime(String location) {
		lv.enterShowtime(location);
	}
	
	public static Location returnLocationWithEvent(String event) {
		return lv.returnLocationWith(event);
		
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

}