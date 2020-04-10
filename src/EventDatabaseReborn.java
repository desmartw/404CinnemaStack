import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
private String name;
private String type;
private int ratingSum;
private int ratingNum;
private ArrayList<String> comments;
private ArrayList<String> actors;
*/

public class EventDatabaseReborn {
	public static final String[] EVENT_TYPES = {"movie", "play", "concert"};
	private ArrayList<Event> list = new ArrayList<Event>();
	public static final Scanner scan = new Scanner(System.in);
	private File file = new File("events.json");
	private ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * makes sure that data is good before adding to DB
	 */
	public void enterEvent() {
		System.out.println();
		String name = validateName();
		String type = validateType();
		int ratingSum = 0;
		int ratingNum = 0;
		ArrayList<String> comments = new ArrayList<String>();
		ArrayList<String> dates = validateDates();
		ArrayList<String> actors = validateActors();
		
		refreshList();
		Event event = new Event(name, type, comments, actors);
		writeList(event);
	}
	
	/**
	 * checks that dates entered fit format
	 * @return list of dates -ArrayList<String>
	 */
	public ArrayList<String> validateDates() {
		String date = "";
		ArrayList<String> list = new ArrayList<String>();
		while(true) {
			System.out.println("Dates are stored as MMDDYYYY. Enter the date of a single showtime:");
			date = scan.nextLine();
			if (date.length() != 8) {
				System.out.println("Dates must have exactly 8 digits.");
				continue;
			}
			if (!(date.matches("[0-9]+"))) {
				System.out.println("Dates must only contain numbers");
				continue;
			}
			list.add(date);
			System.out.println("Date added.");
			System.out.println("Enter another date or type [Enter] to finish.");
			date = scan.nextLine();
			if ((date.toLowerCase()).equals("")) {
				return list;
			}
		}
	}
	
	public String validateDate() {
		String date = "";
		while(true) {
			System.out.println("Dates are stored as MMDDYYYY. Enter the date of a single showtime:");
			date = scan.nextLine();
			if (date.length() != 8) {
				System.out.println("Dates must have exactly 8 digits.");
				continue;
			}
			if (!(date.matches("[0-9]+"))) {
				System.out.println("Dates must only contain numbers");
				continue;
			}
			System.out.println("Date added.");
			return date;
		}
	}
	
	/**
	 * Makes sure price of event is valid
	 * @return price- string
	 */
	public Double validatePrice() {
		Double price = null;
		while(true) {
			boolean running = true;
			while(running) {
				try {
					System.out.println("Enter the price of your event as a whole number:");
					price = Double.parseDouble(scan.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Prices must only be integer numbers please.");
					continue;
				}
				running = false;
			}
			if (price < 0) {
				System.out.println("You cannot have a negative price.");
				continue;
			}
			System.out.println("Event price added.");
			break;
		}
		return price;
	}
	
	/**
	 * checks that actors entered name is long enough
	 * @return list of actors -ArrayList<String>
	 */
	public ArrayList<String> validateActors() {
		String actor = "";
		ArrayList<String> list = new ArrayList<String>();
		while(true) {
			System.out.println("Enter the full of name of an actor in the event.");
			actor = scan.nextLine();
			if (actor.length() <= 1) {
				System.out.println("Invalid name.");
				continue;
			}
			list.add(actor);
			System.out.println("Actor added.");
			System.out.println("Enter another date or type [Enter] to finish.");
			actor = scan.nextLine();
			if ((actor.toLowerCase()).equals("")) {
				return list;
			}
		}
	}
	/**
	 * Ensures that whatever name is entered is a valid one
	 * @return name - String - validated name
	 */
	public String validateName() {
		String name = "";
		ArrayList<String> names = getAllNames();
		while(true) {
			System.out.println("Enter the name of your event:");
			name = scan.nextLine();
			if (names.contains(name)) {
				System.out.println("Event name already exists.");
				continue;
			}
			if (name.length() == 0) {
				System.out.println("The name of your event cannot be empty.");
				continue;
			}
			System.out.println("Event name added.");
			break;
		}
		return name;
	}
	
	/**
	 * Makes sure time of event is valid
	 * @return time- string
	 */
	public String validateMilitaryTime() {
		String time = "";
		while(true) {
			System.out.println("Enter the military time of the showtime:");
			time = scan.nextLine();
			if (time.length() != 4) {
				System.out.println("The military time must have 4 digits.");
				continue;
			}
			if (!(time.matches("[0-9]+"))) {
				System.out.println("The military time must only contain numbers");
				continue;
			}
			System.out.println("Event time added.");
			break;
		}
		return time;
	}
	
	/**
	 * Checks that the type of event user enters is actually an event type
	 * @return type -  String - verified type of event
	 */
	public String validateType() {
		String type = "";
		List<String> types = new ArrayList<String>();
		types = Arrays.asList(EVENT_TYPES); 
		while(true) {
			System.out.println("Enter the type of your event:");
			type = scan.nextLine();
			if(!(types.contains(type))) {
				System.out.println("You may only enter one of the following types.");
				System.out.println(Arrays.toString(types.toArray()));
				continue;
			}
			System.out.println("Event type added.");
			break;
		}
		return type;
	}
	/**
	 * Writes from JSON file to list
	 * @param event
	 */
	public void writeList(Event event) {
		try {
			list.add(event);
			mapper.writeValue(new File("testOfArrayList.json"), this.list);
		} catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
	
	/**
	 * Writes from JSON file to list
	 */
	public void writeList() {
		try {
			mapper.writeValue(new File("testOfArrayList.json"), this.list);
		} catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
	
	/**
	 * reads list and prints 
	 */
	public void readList() {
		refreshList();
		this.list.forEach(event->event.printEvent());
	}
	
	/**
	 * updates list from JSON file
	 */
	public void refreshList() {
		try {
			this.list = mapper.readValue(new File("testOfArrayList.json"), new TypeReference<ArrayList<Event>>(){});
		} catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
	
	/**
	 * adds a raitng to event 
	 * @return void
	 */
	public void addRating() {
		Event event = returnEventObjectByName();
		int rating;
		do {
			System.out.println("Enter a rating between 0 and 5.");
			while (!scan.hasNextInt()) {
	            String input = scan.next();
	            System.out.printf("\"%s\" is not a valid number.\n", input);
			}
			rating = scan.nextInt();
			scan.nextLine();
		} while (rating < 0 || rating > 5);
		
		refreshList();
		/*
		event.setRatingNum((event.getRatingNum()) + rating);
		event.setRatingSum((event.getRatingSum()) + 1);
		*/
		event.addUserRating(rating);
		// For Loop for iterating ArrayList 
        for (int i = 0; i < this.list.size(); i++)  {
        	Event temp = list.get(i);
        	if ((temp.getName()).equals(event.getName())) {
        		this.list.set(i, event);
        		writeList();
        		refreshList();
        	}
        }
	}
	/**
	 * enables adding comments to list
	 */
	public void addComment() {
		Event event = returnEventObjectByName();
		String comment;
		//ArrayList<String> coms = 
		while(true) {
			System.out.println("Enter your comment:");
		    comment = scan.nextLine();
		    if (comment.length() <= 0) {
		    	System.out.println("Comment invalid.");
		    	continue;
			}
			break;
		}
		refreshList();
		event.addUserComment(comment);
		// For Loop for iterating ArrayList 
        for (int i = 0; i < this.list.size(); i++)  {
        	Event temp = list.get(i);
        	if ((temp.getName()).equals(event.getName())) {
        		this.list.set(i, event);
        		writeList();
        		refreshList();
        	}
        }
	}
	/**
	 * returns event object after asking user for the name
	 * @return Event
	 */
	public Event returnEventObjectByName() {
		String name = "";
		refreshList();
		ArrayList<String> names = getAllNames();
		ArrayList<Event> events = this.list;
		Event event = null;
		while(true) {
			System.out.println("Enter the name of your event:");
			name = scan.nextLine();
			if (name.length() == 0) {
				System.out.println("The name of your event cannot be empty.");
				continue;
			}
			if (names.contains(name)) {
				break;
			}
			else {
				System.out.println("Event does not exist.");
				continue;
			}
		}
		for (int i = 0; i < this.list.size(); i++)  {
			Event currEvent = ((Event) this.list.get(i));
			if ((currEvent.getName()).equals(name)) {
	    		event = currEvent;
	    	}
		}
		return event;
	}
	/**
	 * searches arraylist and returns names of all events
	 * @return
	 */
	public ArrayList<String> getAllNames() {
		ArrayList<String> names = new ArrayList<String>();
		this.list.forEach(event->names.add(event.getName()));
		return names;
	}
	/**
	 * reads list of events and returns a JSONArray
	 * @return readEventList-JSONArray
	 */
	public JSONArray readEventList() {
		JSONParser jsonParser = new JSONParser();
        JSONArray readEventList = new JSONArray();
        
        try (FileReader reader = new FileReader("events.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            readEventList = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return readEventList;
	}
	/**
	 * clears the database 
	 */
	public void wipeDatabase() {
		this.list = new ArrayList<Event>();
		writeList();
	}
}