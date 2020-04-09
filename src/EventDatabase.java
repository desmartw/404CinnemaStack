import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

import java.io.FileWriter;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EventDatabase {
	public static final String[] EVENT_TYPES = {"movie", "play", "concert"};
	
	JSONArray eventList;
	FileWriter file;
	Scanner scan;
	
	/*
	 * Constructor for EventDatabase
	 */
	public EventDatabase() {
		eventList = new JSONArray();
		scan = new Scanner(System.in);
	}
	/**
	 * enables user to add an event to the eventList
	 */
	public void enterEvent(Location loc) {
		System.out.println();
		String name = validateName();
		String militaryTimes = validateMilitaryTimes();
		String type = validateType();
		String rating = "0";
		String numOfRatings = "0";
		String comments = "";
		String dates = validateDates();
		String price = validatePrice();
		
		JSONObject eventDetails = new JSONObject();
		
		eventDetails.put("name", name);
		eventDetails.put("militaryTimes", militaryTimes);
		eventDetails.put("type", type);
		eventDetails.put("rating", rating);
		eventDetails.put("numOfRatings", numOfRatings);
		eventDetails.put("comments", comments);
		eventDetails.put("dates", dates);
		eventDetails.put("price", price);
		
		JSONObject eventObject = new JSONObject();
		eventObject.put("event", eventDetails);
		
		eventList = readEventList();
		eventList.add(eventObject);
		
		try (FileWriter file = new FileWriter("events.json")) {
			 
            file.write(eventList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        } 
		
		//add event to location
		//Event newEvent = returnEventObjectByName(name);
		
		ArrayList<String> militaryTimes2 = new ArrayList<String>();
		militaryTimes2.addAll(Arrays.asList(militaryTimes.toLowerCase().split(" ")));
		int rating2 = Integer.parseInt(rating);
		int numOfRatings2 = Integer.parseInt(numOfRatings);
		ArrayList<String> comments2 = new ArrayList<String>();
		comments2.addAll(Arrays.asList(comments.toLowerCase().split(" ")));
		ArrayList<String> dates2 = new ArrayList<String>();
		dates2.addAll(Arrays.asList(dates.toLowerCase().split(" ")));
		Double price2 = Double.parseDouble(price);
		loc.events.add(new Event(name, militaryTimes2, type, rating2, numOfRatings2, comments2, dates2, price2));
		System.out.println("Event added to your location!");
	}
	
	/**
	 * enables user to add an event to the eventList
	 */
	public void enterEvent() {
		System.out.println();
		String name = validateName();
		String militaryTimes = validateMilitaryTimes();
		String type = validateType();
		String rating = "0";
		String numOfRatings = "0";
		String comments = "";
		String dates = validateDates();
		String price = validatePrice();
		
		JSONObject eventDetails = new JSONObject();
		
		eventDetails.put("name", name);
		eventDetails.put("militaryTimes", militaryTimes);
		eventDetails.put("type", type);
		eventDetails.put("rating", rating);
		eventDetails.put("numOfRatings", numOfRatings);
		eventDetails.put("comments", comments);
		eventDetails.put("dates", dates);
		eventDetails.put("price", price);
		
		JSONObject eventObject = new JSONObject();
		eventObject.put("event", eventDetails);
		
		eventList = readEventList();
		eventList.add(eventObject);
		
		try (FileWriter file = new FileWriter("events.json")) {
			 
            file.write(eventList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        } 
		
	}
	
	/**
	 * Makes sure name of event is valid
	 * @return name - string
	 */
	public String validateName() {
		String name = "";
		ArrayList<String> names = getAllEventNames();
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
	public String validateMilitaryTimes() {
		String times = "";
		String time = "";
		while(true) {
			System.out.println("Enter the military time of a single showtime:");
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
			System.out.println("Would you like to add more times? Enter yes or no:");
			String response = scan.nextLine();
			if ((response.toLowerCase()).equals("yes")) {
				times += (time + " ");
				continue;
			}
			else {
				times += time;
			}
			break;
		}
		return times;
	}
	/**
	 * Makes sure type of event is valid
	 * @return type - String
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
	 * Makes sure date of event is valid
	 * @return dates - string
	 */
	public String validateDates() {
		String dates = "";
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
			System.out.println("Would you like to add more dates? Enter yes or no:");
			String response = scan.nextLine();
			if ((response.toLowerCase()).equals("yes")) {
				dates += (date + " ");
				continue;
			}
			else {
				dates += date;
			}
			break;
		}
		return dates;
	}
	/**
	 * Makes sure price of event is valid
	 * @return price- string
	 */
	public String validatePrice() {
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
		return Integer.toString(price);
	}
	/**
	 *  reads Array list of events 
	 * @return list of events- JSONArray
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
	 * reads all events and prints to console
	 */
	public void readAllEvents() {
		// reading
        JSONParser jsonParser = new JSONParser();
        JSONArray readEventList = readEventList();
        try (FileReader reader = new FileReader("events.json"))
        {
            //System.out.println(readEventList);
            //Iterate over event array
            readEventList.forEach( event -> parseEventObject( (JSONObject) event ) );
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * reads all events and prints to the user's screen
	 */
	public void readAllEventsForUser() {
		// reading
        JSONParser jsonParser = new JSONParser();
        JSONArray readEventList = readEventList();
        try (FileReader reader = new FileReader("events.json"))
        {
            //System.out.println(readEventList);
            //Iterate over event array
            readEventList.forEach( event -> parseEventObjectForUser( (JSONObject) event ) );
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/*
	 * 
	 */
	public ArrayList<Event> returnAllEventsAsArrayList() {
		ArrayList<Event> events = new ArrayList<Event>();
		
		JSONParser jsonParser = new JSONParser();
        JSONArray readEventList = readEventList();
        try (FileReader reader = new FileReader("events.json"))
        {
            //System.out.println(readEventList);
            //Iterate over event array
            readEventList.forEach( event -> {
            	JSONObject currEvent = (JSONObject) event;
            	String name = parseName(currEvent);
            	Event eventObject = returnEventObjectByName(name);
            	events.add(eventObject);
            });
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return events;
	}
	
	// Parse methods find and return respective variables
	public String parseName(JSONObject event) 
    {
        JSONObject eventObject = (JSONObject) event.get("event");
        return (String) eventObject.get("name");    
    }
	
	/**
	 * Searches for a specific event
	 * @param user
	 * @return
	 */
	public JSONObject findEventByName(String name) {
		eventList = readEventList();
		Iterator i = eventList.iterator();
        while (i.hasNext()) {
        	JSONObject eventObject = (JSONObject) i.next();
        	eventObject = (JSONObject) eventObject.get("event");
        	String currentName = (String) eventObject.get("name");
        	if (name.equals(currentName))
        		return eventObject;
        }
        return null;
	}
	/**
	 * searches for an event and returns info based on a name
	 * @param name
	 * @return event 
	 */
	public Event returnEventObjectByName(String name) {
		JSONObject eventObject = findEventByName(name);
		if (eventObject != null) {
			String times = (String) eventObject.get("militaryTimes");
			ArrayList<String> militaryTimes = new ArrayList<String>();
			militaryTimes.addAll(Arrays.asList(times.toLowerCase().split(" ")));
			
			
			String type = (String) eventObject.get("type");
			int rating = Integer.parseInt((String) eventObject.get("rating"));
			int numOfRatings = Integer.parseInt((String) eventObject.get("numOfRatings"));
			
			String coms = (String) eventObject.get("comments");
			ArrayList<String> comments = new ArrayList<String>();
			comments.addAll(Arrays.asList(coms.toLowerCase().split(" ")));
			
			String datesString = (String) eventObject.get("dates");
			ArrayList<String> dates = new ArrayList<String>();
			dates.addAll(Arrays.asList(datesString.toLowerCase().split(" ")));
			
			Double price = Double.parseDouble((String) eventObject.get("price"));
			
			return new Event(name, militaryTimes, type, rating, numOfRatings, comments, dates, price);
		} else {
			return null;
		}
	}
	
	public ArrayList<String> getAllEventNames() {
		ArrayList<String> names = new ArrayList<String>();
		JSONParser jsonParser = new JSONParser();
        JSONArray readEventList = readEventList();
        
        //JSONObject eventObject = new JSONObject();
        try (FileReader reader = new FileReader("events.json"))
        {
        	readEventList.forEach( event -> names.add(parseName((JSONObject) event)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return names;
	}
	
	public void addCommentToEvent(String name, String comment) {
		
		JSONObject eventObject = findEventByName(name);
		String coms = (String) eventObject.get("comments");
		coms += comment + " ";
		eventObject.put("comments", coms);
	}
	
	/**
	 * clears data from database JSON file
	 */
	public void wipeDatabase() {
		eventList = new JSONArray();
		try (FileWriter file = new FileWriter("events.json")) {
            file.write(eventList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
	/**
	 * parses event form json object
	 * @param event
	 */
	public void parseEventObject(JSONObject event) {
		JSONObject eventObject = (JSONObject) event.get("event");
        System.out.println("\nName: " + (String) eventObject.get("name"));  
        System.out.println("Showtimes in military time: " + (String) eventObject.get("militaryTimes"));
        System.out.println("Type: " + (String) eventObject.get("type"));
        System.out.println("Rating: " + (String) eventObject.get("rating"));
        System.out.println("Number of ratings: " + (String) eventObject.get("numOfRatings"));
        System.out.println("Comments: " + (String) eventObject.get("comments"));
        System.out.println("Dates: " + (String) eventObject.get("dates"));
        System.out.println("Price: " + (String) eventObject.get("price"));
	}
	
	/**
	 * parses event from json object and sets up the display for the user
	 * @param event
	 */
	public void parseEventObjectForUser(JSONObject event) {
		JSONObject eventObject = (JSONObject) event.get("event");
		/*
		String type = (String) eventObject.get("type");
		String output = type.substring(0, 1).toUpperCase() + type.substring(1);
		System.out.println("\n" + output + "\n-----");
		*/
		String name = (String) eventObject.get("name");
		String dash = new String(new char[name.length()+3]).replace("\0", "-");
		//System.out.println("\n");
		System.out.println(" " + dash);
		System.out.println(("| "+name+"  |")); 
		System.out.println(" " + dash);
		//System.out.println("CinemaStack audience rating: " + (String) eventObject.get("rating"));
	}
	
	
}