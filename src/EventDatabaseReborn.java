import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.IOException;
import java.util.ArrayList;
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
	ArrayList<Event> list = new ArrayList<Event>();
	public static Scanner scan = new Scanner(System.in);
	File file = new File("events.json");
	ObjectMapper mapper = new ObjectMapper();
	
	// initialize event object
	public void enterEvent() {
		
		// LAZY FIX ME
		EventDatabase ev = new EventDatabase();
		
		String name = ev.validateName();
		ArrayList<String> militaryTimes = validateTimes();
		String type = ev.validateType();
		int ratingSum = 0;
		int ratingCount = 0;
		ArrayList<String> comments = new ArrayList<String>();
		ArrayList<String> dates = validateDates();
		//ArrayList<String> actors = validateActors();
		int price = validatePrice();
		
		refreshList();
		Event event = new Event(name, militaryTimes, type, ratingSum, ratingCount, comments, dates, price);
		writeList(event);
	}
	
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
	
	public ArrayList<String> validateDates() {
		String date = "";
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("Dates are stored as MMDDYYYY. Enter the date of a single showtime:");
		date = scan.nextLine();
		while(true) {
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
	
	// arraylist to pretty json
	public void writeList(Event event) {
		try {
			list.add(event);
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
	
	public void addComment() {
		String name = "";
		ArrayList<String> names = getAllNames();
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
		//ev.addRatingToEvent(name, ratingStr);
		System.out.println("Rating saved.");
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
