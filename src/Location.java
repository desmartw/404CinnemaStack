import java.io.File;  // Import the File class
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class Location {
	public static final int ROWS = 5;
	public static final int COLUMNS = 5;
	public String name;
	public String description;
	public int seatNumber; // between 1 & rows*columns
	public String [][] seatingGrid;
	public ArrayList<Event> events;
	public int totalTickets;
	
	public Location() {
		name = "Mall";
		description = "A run-down old mall";
		seatNumber=1;
		seatingGrid = new String[ROWS][COLUMNS];
		events = new ArrayList<Event>();
		totalTickets = ROWS*COLUMNS;
	}

	//Simplified constructor for DB
	public Location(String name, String description, int seatNumber, ArrayList<Event> event) {
		this.name = name;
		this.description = description;
		this.events = event;
		this.seatNumber= seatNumber;
		seatingGrid = new String[ROWS][COLUMNS];
		
	}
	
	/*
	 * fills the seatGrid with [X] for display
	 */
	public void setSeatGrid() {
		for(int i =0; i < ROWS; i++) {
			for(int j =0; j < COLUMNS; j++) {
				seatingGrid[i][j] = "[X]";
			}
		}
	}
	/*
	 * prints the seat grid for seat selection
	 */
	public void showSeatGrid(String[][] seatGrid) {
		for(int i =0; i < ROWS; i++) {
			for(int j =0; j < COLUMNS; j++) {
				System.out.println(seatGrid[i][j]);
			}
		}
	}
	
	/*
	 *  creates a blank txt file to store users ticket into
	 */

	public void CreateTicketFile() {
		for(int i=0; i< 0; i++) {
	    try {
	      File myObj = new File(events.get(i).getName()+"Ticket.txt");
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	        totalTickets--;
	      } else {
	        System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		}
	 }
	 /**
	  * writes ticket information to ticket file
	  */
	 public void WriteTicket() {
		 for(int i=0; i< 0; i++) {
		try{
	      FileWriter myWriter = new FileWriter(events.get(i).getName()+"Ticket.txt");
	      myWriter.write
	      ("*********************"
	      +"**** Name: "+ events.get(i).getName()
	      +"**** Time: "+events.get(i).getMilitaryTimes()
	      +"**** Seat:  "+seatNumber
	      +"*********************");
	      myWriter.close();
	      System.out.println("Successfully made your ticket.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
		 }
	
	 
	 
	}
	
	

