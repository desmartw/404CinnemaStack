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
	        String password = validatePassword();
	        int seatingRows = validateSeatingRows();
	        int seatingCols = validateSeatingCols();
	        int handicapStartSeat = validateHandicapStartSeat();
	        //checks that there are hanciapped seats 
	        if(handicapStartSeat !=  -1) {
	        	int handicapEndSeat = validateHandicapEndSeat();
	        } else {
	        	int handicapEndSeat = 0;
	        }
	        ArrayList<Showtime> showtimes = new ArrayList<Showtime>();
	        
	        org.json.JSONObject locationDetails = new JSONObject();
	        
	        locationDetails.put("Name",  name);
	        locationDetails.put("Description", description);
	        locationDetails.put("Password", password);
	        locationDetails.put("SeatRows", seatingRows);
	        locationDetails.put("SeatCols", seatingCols);
	        locationDetails.put("HandicapStartSeat", handicapStartSeat);
	        locationDetails.put("HandicapEndSeat", handicapStartSeat);
	        locationDetails.put("Showtimes", showtimes);
	        
	        JSONObject locationObject = new JSONObject();
	        locationObject.put("Location", locationDetails);
	        
	        locationList = readLocationList();
	        locationList.add(locationObject);
	    }
	    
	    private int validateHandicapStartSeat() {
			// TODO Auto-generated method stub
	    	int hStartSeat = 0;
	    	System.out.println("If you would like to add handicapped seats, enter a starting seat number (between 1-5). \n"
	    			+ "If not, hit 0.");
	    	hStartSeat = scan.nextInt();
	    	if(hStartSeat == 0) {
	    		return -1;
	    	} else if(hStartSeat > 1 && hStartSeat <= 5) {
	    		return hStartSeat;
	    	}
			return hStartSeat;
		}
		private int validateHandicapEndSeat() {
			int hEndSeat = 0;
			System.out.println("Where would you like the handicapped seating to stop? enter a seat number (between 1-5). \n");
			while(true) {
			hEndSeat = scan.nextInt();
			if(hEndSeat < 1 || hEndSeat >= 5) {
				System.out.println("Invalid number, try again");
			} else {
				System.out.println("End seat added");
				
			}
			break;
			}
			return hEndSeat;
		}
		
		private int validateSeatingCols() {
			 int seatCols = 0;
		        while(true) {
		        	System.out.println("Enter the seat col you would like in range 1-25: ");
		        	seatCols = scan.nextInt();
		        	if(seatCols == 0 || seatCols> 25) {
		        		System.out.println("Your seat col number is out of range");
		        		continue;
		        	}
		        	System.out.println("number of Cols added");
		        	break;
		        }
		        return seatCols;
		}
		private String validatePassword() {
			// TODO Auto-generated method stub
			String pwd;
			while(true) {
	        	System.out.println("Enter your desired password, between 3-10 char: ");
	        	pwd = scan.nextLine();
	        	if(pwd.length() == 0 || pwd.length() > 10) {
	        		System.out.println("Your password is too long or too short, try again");
	        	} 
	        	System.out.println("Password saved.");
	        	break;
		}
		  	return pwd;
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
	    public int validateSeatingRows() {
	        int seatRows = 0;
	        while(true) {
	        	System.out.println("Enter the seat rows you would like in range 1-25: ");
	        	seatRows = scan.nextInt();
	        	if(seatRows == 0 || seatRows> 25) {
	        		System.out.println("Your seat row number is out of range");
	        		continue;
	        	}
	        	System.out.println("number of rows added");
	        	break;
	        }
	        return seatRows;
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
	    
	



