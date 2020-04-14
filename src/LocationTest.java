import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LocationTest {

	@Test
	public void testLocationCreation() {
		String name = "Cinema 1";
		String description = "New Cinema";
		int seatingRows = 5;
		int seatingCols = 5;
		int handicapStartSeat =0;
		int handicapEndSeat = 0;
		ArrayList<Showtime> showtimes = new ArrayList<Showtime>();
		Location loc = new Location(name, description, seatingRows, 
				seatingCols, handicapStartSeat, handicapEndSeat, showtimes);
		assertNotNull(loc);
	}
	public void testTwoLocationsNotEqual() {
		String name = "Cinema 1";
		String description = "New Cinema";
		int seatingRows = 5;
		int seatingCols = 5;
		int handicapStartSeat =0;
		int handicapEndSeat = 0;
		ArrayList<Showtime> showtimes = new ArrayList<Showtime>();
		Location loc = new Location(name, description, seatingRows, 
				seatingCols, handicapStartSeat, handicapEndSeat, showtimes);
		String name2 = "Cinema 0";
		String description2 = "No Cinema";
		int seatingRows2 = 0;
		int seatingCols2 = 0;
		int handicapStartSeat2 =0;
		int handicapEndSeat2 = 0;
		ArrayList<Showtime> showtimes2 = new ArrayList<Showtime>();
		Location loc2 = new Location(name2, description2, seatingRows2, 
				seatingCols2, handicapStartSeat2, handicapEndSeat2, showtimes2);
		assertNotEquals(loc, loc2);
	}

}
