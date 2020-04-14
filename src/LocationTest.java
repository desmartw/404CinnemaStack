import static org.junit.Assert.*;
import junit.framework.*;
import java.util.ArrayList;

import org.junit.Test;

public class LocationTest extends TestCase {
	
	protected String name;
	protected String description;
	protected int seatingRows;
	protected int seatingCols;
	protected int handicapStartSeat =0;
	protected int handicapEndSeat = 0;
	protected ArrayList<Showtime> showtimes;
	protected Location loc = new Location();
	
	protected void setUp() {
		name = "Cinema 1";
		description = "New Cinema";
		seatingRows = 5;
		seatingCols = 5;
		handicapStartSeat =0;
		handicapEndSeat = 0;
		showtimes = new ArrayList<Showtime>();
		Location loc = new Location(name, description, seatingRows, 
				seatingCols, handicapStartSeat, handicapEndSeat, showtimes);
	}
	protected void tearDown() {
		name = null;
		description = null;
		seatingRows = 0;
		seatingCols = 0;
		handicapStartSeat =0;
		handicapEndSeat = 0;
		showtimes = null;
	}
	@Test
	public void testLocationCreation() {
		assertNotNull(loc);
		tearDown();
	}
	@Test
	public void testTwoLocationsNotEqual() {
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
	@Test
	public void testGetName() {
		assertEquals(name, loc.getName());
	}
	@Test
	public void testGetDescription() {
		assertEquals(description, loc.getDescription());
	}
	@Test
	public void testGetSeatingRows() {
		assertEquals(seatingRows, loc.getSeatingRows());
	}
	@Test
	public void testGetSeatingCols() {
		assertEquals(seatingCols, loc.getSeatingCols());
	}
	@Test
	public void testGetHandicapStartSeat() {
		assertEquals(handicapStartSeat, loc.getHandicapStartSeat());
		
	}
	@Test
	public void testGetHandicapEndSeat() {
		assertEquals(handicapEndSeat, loc.getHandicapEndSeat());

	}
	@Test
	public void testGetSbowtimes() {
		assertEquals(showtimes, loc.getShowtimes());
	}
	
	@Test
	public void testWipeShowtimes() {
		loc.wipeShowtimes();
		assertNull(showtimes);
	}
	@Test
	public void addNullShowtime() {
		loc.addShowtime(null);
		assertNull(showtimes);
	}
	

}
