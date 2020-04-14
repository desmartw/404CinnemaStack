/**
 * 
 * @author Ryan Henderson
 * Helper class holding functionality and structure for the Driver
 * that is why most things are public // TODO maybe change this line
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Page {
	
	String display;
	
	/**
	 * Default Constructor
	 */
	public Page() {
		display = "";
	}
	
	/**
	 * Parameterized Constructor
	 * @param display - String value that displays page information in text format for the user
	 */
	public Page(String display) {
		this.display = display;
	}
	
	// getters and setters
	public String getDisplay() {
		return display;
	}
	
	public void setDisplay(String display) {
		this.display = display;
	}
	public void showDisplay() {
		System.out.println(this.display);
	}
}
