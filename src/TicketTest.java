import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TicketTest extends TestCase{
	Ticket t1;
	Ticket t2;
	String name;
	int seatNumber;
	String militaryTime;
	String date;
	double price;
	String ticket;

	@Before
	public void setUp() throws Exception {
		name = "test";
		seatNumber = 0;
		militaryTime = "0000";
		date = "05052020";
		price = 9.9;
		t1 = new Ticket();
		t2 = new Ticket(name, seatNumber, militaryTime, date, price);
		ticket = "_______________________________________________________" +
				   "\n*~*                  -Ticket-                       *~*"+
					"\n---- Name: " + name + 
					"\n---- Seat number: "+ seatNumber  +
					"\n---- Price: " + price  +
					"\n---- Time of show (24hr): " + militaryTime +
					"\n____________________________________________________";
	}

	@Test
	public void testingDefaultConstrutor() {
		assertNotNull(t1);
	}
	
	@Test
	public void testingParamterizedConstrutor() {
		assertNotNull(t2);
	}
	
	@Test
	public void testingGetName() {
		assertEquals(t2.getName(), name);
	}

	@Test
	public void testingGetSeatNumber() {
		assertEquals(t2.getSeatNumber(), seatNumber);
	}
	
	@Test
	public void testingGetPrice() {
		assertEquals(t2.getPrice(), price);
	}
	
	@Test
	public void testingGetMilitaryTime() {
		assertEquals(t2.getMilitaryTime(), militaryTime);
	}
	
	@Test
	public void testingGetDate() {
		assertEquals(t2.getDate(), date);
	}
	
	@Test
	public void testingSetName() {
		t1.setName(name);
		assertEquals(t1.getName(), name);
	}
	
	@Test
	public void testingSetSeatNumber() {
		t1.setSeatNumber(seatNumber);
		assertEquals(t1.getSeatNumber(), seatNumber);
	}
	
	@Test
	public void testingSetPrice() {
		t1.setPrice(price);
		assertEquals(t1.getPrice(), price);
	}
	
	@Test
	public void testingSetMilitaryTime() {
		t1.setMilitaryTime(militaryTime);
		assertEquals(t1.getMilitaryTime(), militaryTime);
	}
	
	@Test
	public void testingSetDate() {
		t1.setDate(date);
		assertEquals(t1.getDate(), date);
	}
	
	@Test
	public void testingToString() {
		assertEquals(t2.toString(), ticket);
	}
}
