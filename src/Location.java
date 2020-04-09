import java.io.File;  // Import the File class
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class Location {
	
	public String name;
	public String description;
	public int seatNumber; // between 1 & rows*columns
	public ArrayList<Event> events;
	public int totalTickets;
	
	public Location() {
		name = "Mall";
		description = "A run-down old mall";
		seatNumber=1;
		events = new ArrayList<Event>();
		totalTickets = 0;
	}

	//Simplified constructor for DB
	public Location(String name, String description, int seatNumber, ArrayList<Event> events) {
		this.name = name;
		this.description = description;
		this.events = events;
		this.seatNumber= seatNumber;
	}
	/*
	 *  creates a blank txt file to store users ticket into
	 */

	public void CreateTicketFile() {
		for(int i=0; i< events.size(); i++) {
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
		 for(int i=0; i< events.size(); i++) {
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
	
	

