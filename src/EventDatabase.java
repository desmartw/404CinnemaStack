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
	
	public EventDatabase() {
		eventList = new JSONArray();
		scan = new Scanner(System.in);
	}
	
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
		eventDetails.put("dates ", dates );
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
	
	public String validateName() {
		String name = "";
		while(true) {
			System.out.println("Enter the name of your event:");
			name = scan.nextLine();
			if (name.length() == 0) {
				System.out.println("The name of your event cannot be empty.");
				continue;
			}
			System.out.println("Event name added.");
			break;
		}
		return name;
	}
	
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
			
	public void readAllEvents() {
		// reading
        JSONParser jsonParser = new JSONParser();
        JSONArray readEventList = readEventList();
        try (FileReader reader = new FileReader("users.json"))
        {
            System.out.println(readEventList);
            //Iterate over user array
            readEventList.forEach( event -> parseEventObject( (JSONObject) event ) );
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
	
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
	
}