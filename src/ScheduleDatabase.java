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

public class ScheduleDatabase {
		//public Schedule(ArrayList<Event> events, String genre, int count, String name) {


	    JSONArray scheduleList;
	    FileWriter file;
	    Scanner scan;
	    /**
	     * default constructor
	     */
	    public ScheduleDatabase() {
	        scheduleList = new JSONArray();
	        scan = new Scanner(System.in);
	    }
	    /**
	     * allows creation of new schedules
	     */
	    public void enterSchedule() {
	        System.out.println();
	        ArrayList<Event> events = validateArrayList();
	        String genre = validateGenre();
	        int count = validateCount();
	        String name = validateName();
	        
	        
	        JSONObject scheduleDetails = new JSONObject();
	        
	        scheduleDetails.put("Events",  events);
	        scheduleDetails.put("Name",  name);
	        scheduleDetails.put("Genre", genre);
	        scheduleDetails.put("Count", count);
	        
	        JSONObject scheduleObject = new JSONObject();
	        scheduleObject.put("schedule", scheduleDetails);
	        
	        scheduleList = readScheduleList();
	        scheduleList.add(scheduleObject);
	    }
	    /**
	     * reads a list of schedules and retuns JSON array
	     * @return
	     */
	    public JSONArray readScheduleList() {
			JSONParser jsonParser = new JSONParser();
	        JSONArray readScheduleList = new JSONArray();
	        
	        try (FileReader reader = new FileReader("schedule.json"))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	            readScheduleList = (JSONArray) obj;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
	        return readScheduleList;
		}
	    /**
	     * Makes sure name of Schedule is valid
	     * @return
	     */
	    public String validateName() {
	        String name = "";
	        while (true) {
	            System.out.println("Enter the name of the schedule:");
	            name = scan.nextLine();
	            if (name.length() == 0) {
	                System.out.println("The name of your event cannot be empty");
	                continue;
	            }
	            System.out.println("Schedule name added");
	            break;
	        }
	        return name;
	    }
	    /**
	     * Makes sure genre of Schedule is valid
	     * @return
	     */
	    public String validateGenre() {
	        String genre = "stop";
	        while(true) {
	        	System.out.println("Enter the genre of event: "+
	        "Your oprions are Play, Concert, Movie");
	        	genre = scan.nextLine();
	        	if(genre.toLowerCase() != "play" || genre.toLowerCase() != "concert" || genre.toLowerCase() != "movie") {
	        		System.out.println("Your genre selection is invalid, "+
	        	"be sure to spell correctly!!");
	        		continue;
	        	}
	        	System.out.println("Genre selected");
	        	break;
	        }
	        return genre;
	    }
	    /**
	     * Makes sure count of schedule is valid
	     * @return
	     */
	    public int validateCount() {
	    	int count = -1;
	    	while(true) {
	    		System.out.println("Enter a count of events in the schedule: ");
	    		count = scan.nextInt();
	    		if(count < 0 || count >= 500) {
	    			System.out.println("Your count is either too little or too large,"
	    					+ " please make sure its between 1 and 500 inclusive.");
	    			continue;
	    		}
	    		System.out.println("Description added");
	    		break;
	    		}
	    	return count;
	    }
	    	
	    /**
	     * reads and prints all schedules to console
	     */
	    public void readAllSchedules() {
			// reading
	        JSONParser jsonParser = new JSONParser();
	        JSONArray readScheduleList = readScheduleList();
	        try (FileReader reader = new FileReader("users.json"))
	        {
	            System.out.println(readScheduleList);
	            //Iterate over user array
	            readScheduleList.forEach( schedule -> parseScheduleObject( (JSONObject) schedule ) );
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
		}
		/**
		 * reads from JSONobject and prints attributes
		 * @param schedule
		 */
		public void parseScheduleObject(JSONObject schedule) {
			JSONObject scheduleObject = (JSONObject) schedule.get("schedule");
			System.out.println("\nScheduleList: "+ (Event) scheduleObject.get("events"));
	        System.out.println("\nGenre: " + (String) scheduleObject.get("genre")); 
	        System.out.println("\nCount: " + (Integer) scheduleObject.get("count")); 
	        System.out.println("\nName: " + (String) scheduleObject.get("name")); 
		}
	    
	}



