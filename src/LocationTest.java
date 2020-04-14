import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LocationTest {
	
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
		setUp();
		assertNotNull(loc);
		tearDown();
	}
	@Test
	public void testTwoLocationsNotEqual() {
		setUp();
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
		tearDown();
	}
	@Test
	public void testGetName() {
		setUp();
		assertEquals(name, loc.getName());
		tearDown();
	}
	@Test
	public void testGetDescription() {
		setUp();
		assertEquals(description, loc.getDescription());
		tearDown();
	}
	@Test
	public void testGetSeatingRows() {
		setUp();
		assertEquals(seatingRows, loc.getSeatingRows());
		tearDown();
	}
	@Test
	public void testGetSeatingCols() {
		setUp();
		assertEquals(seatingCols, loc.getSeatingCols());
		tearDown();
	}
	@Test
	public void testGetHandicapStartSeat() {
		setUp();
		assertEquals(handicapStartSeat, loc.getHandicapStartSeat());
		tearDown();
		
	}
	@Test
	public void testGetHandicapEndSeat() {
		setUp();
		assertEquals(handicapEndSeat, loc.getHandicapEndSeat());
		tearDown();
	}
	@Test
	public void testGetSbowtimes() {
		setUp();
		assertEquals(showtimes, loc.getShowtimes());
		tearDown();
	}
	
	@Test
	public void testWipeShowtimes() {
		setUp();
		loc.wipeShowtimes();
		assertNull(showtimes);
		tearDown();
	}
	@Test
	public void addNullShowtime() {
		setUp();
		loc.addShowtime(null);
		assertNull(showtimes);
		tearDown();
	}
	

}
