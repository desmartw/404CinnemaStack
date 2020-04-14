import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import junit.framework.TestCase;

public class ShowtimeTest extends TestCase {

	Showtime defaultShowtime;
	Showtime paramShowtime1;
	Showtime paramShowtime2;
	String[][] seatingGrid1;
	String[][] seatingGrid2;
	String eventName;
	String militaryTime;
	String date;
	double price;
	int seatNumber1;
	int seatNumber2;
	int seatNumber3;
	
	protected void setUp() {
		paramShowtime1 = new Showtime(eventName, militaryTime, date, price, 3, 3, 3, 5);
		paramShowtime2 = new Showtime(eventName, militaryTime, date, price, seatingGrid1);
		defaultShowtime = new Showtime();
		seatingGrid1 = new String[][] {{"[000]", "[001]", "[002]"}, 
									   {"{003}", "{004}", "{005}"}, 
									   {"[006]", "[007]", "[008]"}};
		seatingGrid2 = new String[][] {{"[XXX]", "[001]"},
									   {"[002]", "[XXX]"}};
		eventName = "Event 1";
		militaryTime = "1400";
		date = "12122020";
		price = 30;
		seatNumber1 = 0;
		seatNumber2 = 16;
		seatNumber3 = 256;
	}
	
	@Test
	public void testDefaultShowtimeNotNull() {
		assertNotNull(defaultShowtime);
	}
	
	@Test
	public void testShowtimeWithValuesForSeats() {
		assertEquals(paramShowtime1.getSeatingGrid(), seatingGrid1);
	}
	
	@Test
	public void test1DigitSeatNumberFormatting() {
		assertEquals(Showtime.formattedSeatNumber(seatNumber1), "00" + seatNumber1);
	}
	
	@Test
	public void test2DigitSeatNumberFormatting() {
		assertEquals(Showtime.formattedSeatNumber(seatNumber2), "0" + seatNumber2);
	}
	
	@Test
	public void test3DigitSeatNumberFormatting() {
		assertEquals(Showtime.formattedSeatNumber(seatNumber3), "" + seatNumber3);
	}
	
	@Test
	public void testGetEvent() {
		assertEquals(defaultShowtime.getEvent().getClass(), Event.class);
	}
	
	@Test
	public void testCloseSeat() {
		defaultShowtime.setSeatingGrid(seatingGrid2);
		defaultShowtime.closeSeat(2);
		seatingGrid2[1][0] = "[XXX]";
		assertEquals(defaultShowtime.getSeatingGrid(), seatingGrid2);
	}
	
	@Test
	public void testOpenSeat() {
		defaultShowtime.setSeatingGrid(seatingGrid2);
		defaultShowtime.openSeat(0);
		seatingGrid2[0][0] = "[000]";
		assertEquals(defaultShowtime.getSeatingGrid(), seatingGrid2);
	}
	
	@Test
	public void testGridString() {
		String gridString = "[XXX][001]\n[002][XXX]";
		assertEquals(defaultShowtime.gridString(), gridString);
	}
	
	@Test
	public void testGetNumberOfSeats() {
		assertEquals(paramShowtime2.getNumberOfSeats(), 9);
	}
	
	@Test
	public void testGetSeatingGrid() {
		assertEquals(paramShowtime1.getSeatingGrid(), seatingGrid1);
	}
	
	@Test
	public void testSetSeatingGrid() {
		defaultShowtime.setSeatingGrid(seatingGrid1);
		assertEquals(defaultShowtime.getSeatingGrid(), seatingGrid1);
	}
	
	@Test
	public void testSetSeatingGridWithSeatValues() {
		defaultShowtime.setSeatingGrid(3, 3, 3, 5);
		assertEquals(defaultShowtime.getSeatingGrid(), seatingGrid1);
	}
	
	@Test
	public void testGetName() {
		assertEquals(paramShowtime1.getEventName(), eventName);
	}
	
	@Test
	public void testSetName() {
		defaultShowtime.setEventName(eventName);
		assertEquals(defaultShowtime.getEventName(), eventName);
	}
	
	@Test
	public void testGetTime() {
		assertEquals(paramShowtime1.getMilitaryTime(), militaryTime);
	}
	
	@Test 
	public void testSetTime() {
		defaultShowtime.setMilitaryTime(militaryTime);
		assertEquals(defaultShowtime.getMilitaryTime(), militaryTime);
	}
	
	@Test
	public void testGetDate() {
		assertEquals(paramShowtime1.getDate(), date);
	}
	
	@Test 
	public void testSetDate() {
		defaultShowtime.setDate(date);
		assertEquals(defaultShowtime.getDate(), date);
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(paramShowtime1.getPrice(), price);
	}
	
	@Test 
	public void testSetPrice() {
		defaultShowtime.setPrice(price);
		assertEquals(defaultShowtime.getPrice(), price);
	}
	
	@Test
	public void testGetSeatGrid() {
		assertEquals(paramShowtime2.getSeatingGrid(), militaryTime);
	}
	
	@Test 
	public void testSetSeatGrid() {
		defaultShowtime.setSeatingGrid(seatingGrid1);
		assertEquals(defaultShowtime.getSeatingGrid(), seatingGrid1);
	}
}
