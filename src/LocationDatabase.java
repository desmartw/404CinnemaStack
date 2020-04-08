// TODO delete unused imports
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

public class LocationDatabase {
		//	public Location(String name, String description, int seatNumber, Event event) {

	    JSONArray locationList;
	    FileWriter file;
	    Scanner scan;
	    /**
	     * default constructor
	     */
	    public LocationDatabase() {
	        locationList = new JSONArray();
	        scan = new Scanner(System.in);
	    }
	    /**
	     * Allows creation of new locations
	     */
	    public void enterLocation() {
	        System.out.println();
	        String name = validateName();
	        String description = validateDescription();
	        int seatNumber = validateSeatNumber();
	        ArrayList<Event> events = validateEvents();
	        
	        JSONObject locationDetails = new JSONObject();
	        
	        locationDetails.put("Name",  name);
	        locationDetails.put("SeatNumber", seatNumber);
	        locationDetails.put("Events", events);
	        
	        JSONObject locationObject = new JSONObject();
	        locationObject.put("Location", locationDetails);
	        
	        locationList = readLocationList();
	        locationList.add(locationObject);
	    }
	    /**
	     * returns a JSONarray of locations
	     * @return
	     */
	    public JSONArray readLocationList() {
			JSONParser jsonParser = new JSONParser();
	        JSONArray readLocationList = new JSONArray();
	        
	        try (FileReader reader = new FileReader("location.json"))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	            readLocationList = (JSONArray) obj;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
	        return readLocationList;
		}
	    /**
	     * checks name is valid
	     * @return
	     */
	    public String validateName() {
	        String name = "";
	        while (true) {
	            System.out.println("Enter the name of the location:");
	            name = scan.nextLine();
	            if (name.length() == 0) {
	                System.out.println("The name of your event cannot be empty");
	                continue;
	            }
	            System.out.println("Location name added");
	            break;
	        }
	        return name;
	    }
	    /**
	     *  Makes sure seatNumber of location is valid
	     * @return
	     */
	    public int validateSeatNumber() {
	        int seatNum = 0;
	        while(true) {
	        	System.out.println("Enter the seat number you would like in range 1-25: ");
	        	seatNum = scan.nextInt();
	        	if(seatNum == 0 || seatNum > 25) {
	        		System.out.println("Your seat selection is out of range");
	        		continue;
	        	}
	        	System.out.println("Seat selected");
	        	break;
	        }
	        return seatNum;
	    }
	    /**
	     * Makes sure description of location is valid
	     * @return
	     */
	    public String validateDescription() {
	    	String description = "";
	    	while(true) {
	    		System.out.println("Enter a description of the location: ");
	    		description = scan.nextLine();
	    		if(description == null || description.length() >= 500) {
	    			System.out.println("Your description is either too long or empty,"
	    					+ " please make sure its between 1 and 500 characters inclusive.");
	    			continue;
	    		}
	    		System.out.println("Description added");
	    		break;
	    		}
	    	return description;
	    }
	    	
	
	    public ArrayList<Event> validateEvents() {
	        //TODO validate event
	    	
	    	return null;
	    }
	    
	    /**
	     * reads and prints locations to console
	     */
	    public void readAllLocations() {
			// reading
	        JSONParser jsonParser = new JSONParser();
	        JSONArray readLocationList = readLocationList();
	        try (FileReader reader = new FileReader("users.json"))
	        {
	            System.out.println(readLocationList);
	            //Iterate over user array
	            readLocationList.forEach( location -> parseLocationObject( (JSONObject) location ) );
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
		}
		/**
		 * creates a location from a JSON object
		 * @param location
		 */
		public void parseLocationObject(JSONObject location) {
			JSONObject locationObject = (JSONObject) location.get("Location");
	        System.out.println("\nName: " + (String) locationObject.get("Name")); 
	        System.out.println("\nDescription: "+ (String) locationObject.get("Description"));
	        System.out.println("\nSeat Number: "+ (int) locationObject.get("SeatNumber"));
	        System.out.println("\nEvents: "+ (Event) locationObject.get("Events"));
	        }
		}
	    
	



