import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class Location {
	public static final int ROWS = 20;
	public static final int COLUMNS = 20;
	public String name;
	public String description;
	public int rowNumber;
	public int seatNumber;
	public String [][] seatingGrid;
	public Event event;
	public int totalTickets;
	
	public Location() {
		name = "Mall";
		description = "A run-down old mall";
		rowNumber = 1;
		seatNumber=1;
		seatingGrid = new String[20][20];
		event = new Event();
		totalTickets = ROWS*COLUMNS;
	}
	public Location(String name, String description, int rowNumber, int seatNumber, String[][] seatGrid, Event event) {
		this.name = name;
		this.description=description;
		this.rowNumber =rowNumber;
		this.seatNumber = seatNumber;
		this.seatingGrid= seatGrid;
		this.event = event;
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
	    try {
	      File myObj = new File(event.getName()+"Ticket.txt");
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
	 /**
	  * writes ticket information to ticket file
	  */
	 public void WriteTicket() {
		try{
	      FileWriter myWriter = new FileWriter(event.getName()+"Ticket.txt");
	      myWriter.write
	      ("*********************"
	      +"**** Name: "+ event.getName()
	      +"**** Time: "+event.getMilitaryTime()
	      +"**** Seat: "+rowNumber+" "+seatNumber
	      +"*********************");
	      myWriter.close();
	      System.out.println("Successfully made your ticket.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
	 
	 
	}
	
	

