import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class EventDatabaseReborn {
	private ArrayList<Event> list = new ArrayList<Event>();
	public static final Scanner scan = new Scanner(System.in);
	private File file = new File("events.json");
	private ObjectMapper mapper = new ObjectMapper();
	
	// initialize event object
	public void enterEvent() {
		
		// LAZY FIX ME
		EventDatabase ev = new EventDatabase();
		
		String name = ev.validateName();
		//ArrayList<String> militaryTimes = validateTimes();
		String type = ev.validateType();
		int ratingSum = 0;
		int ratingNum = 0;
		ArrayList<String> comments = new ArrayList<String>();
		ArrayList<String> dates = validateDates();
		ArrayList<String> actors = validateActors();
		//ArrayList<String> actors = validateActors();
		//int price = validatePrice();
		
		refreshList();
		Event event = new Event(name, type, ratingSum, ratingNum, comments, dates, actors);
		writeList(event);
	}
	
	/*
	public int validatePrice() {
		Integer price = null;
		while(true) {
			boolean running = true;
			while(running) {
				try {
					System.out.println("Enter the price of your event as a whole number:");
					price = Integer.parseInt(scan.nextLine());
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
	*/
	/*
	
	public ArrayList<String> validateTimes() {
		String time = "";
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("Enter the military time of a single showtime:");
		time = scan.nextLine();
		while(true) {
			if (time.length() != 4) {
				System.out.println("The military time must have 4 digits.");
				continue;
			}
			if (!(time.matches("[0-9]+"))) {
				System.out.println("The military time must only contain numbers");
				continue;
			}
			list.add(time);
			System.out.println("Event time added.");
			System.out.println("Enter another military time or type [Enter] to finish.");
			time = scan.nextLine();
			if ((time.toLowerCase()).equals("")) {
				return list;
			}
		}
	}
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
	
	// arraylist to pretty json
	public void writeList(Event event) {
		try {
			list.add(event);
			mapper.writeValue(new File("testOfArrayList.json"), this.list);
		} catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
	
	// arraylist to pretty json
	public void writeList() {
		try {
			mapper.writeValue(new File("testOfArrayList.json"), this.list);
		} catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
	
	public void readList() {
		this.list.forEach(event->event.printEvent());
	}
	
	
	public void refreshList() {
		try {
			this.list = mapper.readValue(new File("testOfArrayList.json"), new TypeReference<ArrayList<Event>>(){});
		} catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
	
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
		event.setRatingNum((event.getRatingNum()) + rating);
		event.setRatingSum((event.getRatingSum()) + 1);
		
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
		Iterator it = events.iterator(); 
	    while (it.hasNext()) {
	    	event = ((Event) it.next());
	    	if ((event.getName()).equals(name)) {
	    		return ((Event) it.next());
	    	}
	    }
	    return event;
	}
	
	public ArrayList<String> getAllNames() {
		ArrayList<String> names = new ArrayList<String>();
		this.list.forEach(event->names.add(event.getName()));
		return names;
	}
	
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
}
