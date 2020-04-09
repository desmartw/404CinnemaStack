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
	ObjectMapper objectMapper = new ObjectMapper();
	
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
		
		Event event = new Event(name, militaryTimes, type, ratingSum, ratingCount, comments, dates, price);
		list.add(event);
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
	public void writeList() {
		try {
			//objectMapper.writeValue(new File("testOfArrayList.json"), list); // works
			/*
			ArrayList<Event> al = new ArrayList<Event>(); 
			Event e = new Event("test", new ArrayList<String>(), "movie", 0, 
			0, new ArrayList<String>(), new ArrayList<String>(), 0.0);
			al.add(e);
			String json = objectMapper.writeValueAsString(al);
			ArrayList<Event> el = objectMapper.readValue(json, new TypeReference<ArrayList<Event>>(){});
			el.get(0);
			*/
			
			/*
			Event e = new Event("test", new ArrayList<String>(), "movie", 0, 0, 
					new ArrayList<String>(), new ArrayList<String>(), 0.0);
			String json = objectMapper.writeValue(e);
			e = objectMapper.readValue(json, Event.class);
			System.out.println(e.getName());
			*/
			
			
			ObjectMapper mapper = new ObjectMapper();
			// TEST IF AL CAN BE WRITTIN AND READ
			ArrayList<Event> al = new ArrayList<Event>(); 
			Event e = new Event("test3", new ArrayList<String>(), "movie", 0, 
			0, new ArrayList<String>(), new ArrayList<String>(), 0.0);
			al.add(e);
			String json = mapper.writeValueAsString(al);
			
			//Event[] ea
			
			//al.mapper.writeValue(new File("testOfArrayList.json"), al);
			
			//ArrayList<Event> el = objectMapper.readValue(json, new TypeReference<ArrayList<Event>>(){});
		    //List<Event> events = Lists.newArrayList(e);
			
			/// WORKS!!!!!!!
			// TEST IF EVENT ARRAY CAN BE WRITTEN TO FILE: WORKS
			/*
			Event[] ea = new Event[1];
			ea[0] = new Event("test2", new ArrayList<String>(), "movie", 0, 0, new ArrayList<String>(), new ArrayList<String>(), 0.0);
			mapper.writeValue(new File("testOfArrayList.json"), ea);
			*/
			//String jsonArray = mapper.writeValueAsString(ea);
		    //Event[] readArray = mapper.readValue(jsonArray, Event[].class);
		    //asArray[0].printEvent();
			
			
			
			
		    // [{"stringValue":"a","intValue":1,"booleanValue":true},
		    // {"stringValue":"bc","intValue":3,"booleanValue":false}]
		 
		    
		    //assertThat(asArray[0], instanceOf(MyDto.class));
		    /*
		    List<Event> listOfEvents = Lists.newArrayList(
		      new MyDto("a", 1, true), new MyDto("bc", 3, false));
		    String jsonArray = mapper.writeValueAsString(listOfDtos);
		    */
		  
		    // [{"stringValue":"a","intValue":1,"booleanValue":true},
		    // {"stringValue":"bc","intValue":3,"booleanValue":false}]
		 
		    /*
		    MyDto[] asArray = mapper.readValue(jsonArray, MyDto[].class);
		    assertThat(asArray[0], instanceOf(MyDto.class));
			*/
		    
			//writeValueAsBytes(new File("testOfArrayList.json"), list);
		} catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
	
	public void readList() {
		try {
			//ArrayList<Event> events = objectMapper.readValue(new File("events.json"), new TypeReference<ArrayList<Event>>(){});
			//ArrayList<Event> events = objectMapper.readValue(objectMapper.readValue(new File("events.json"), ArrayList.class, new TypeReference<ArrayList<Event>>(){}));
			
			//ArrayList<Event> events = objectMapper.readValue(new File("events.json"), new TypeReference<ArrayList<Event>>(){});
			
			// WORKS!!!!
			/*
			Event[] events = objectMapper.readValue(new File("testOfArrayList.json"), Event[].class);
			events[0].printEvent();
			*/
			
			//String jsonInput = objectMapper.readValue(new File("events.json"), new TypeReference<ArrayList<Event>>(){});
			//JSONArray array = readEventList();
			//JSONParser jsonParser = new JSONParser();
			//String jsonArray = objectMapper.readValue()
			//ArrayList<Event> events = objectMapper.readValue(, new TypeReference<ArrayList<Event>>(){});
			//System.out.println(events);
		} catch(Exception e) {
			System.out.println("Error " + e);
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
}
