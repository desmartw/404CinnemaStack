import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class LocationDatabaseTest extends TestCase{
	protected LocationDatabase db;
	protected String cinema;
	protected String movie;
	protected int none;
	
	protected void setUp() throws Exception {
		db = new LocationDatabase();
		cinema = "Cinema 1";
		movie = "Frozen 2";
		none = -1;
	}

	@Test
	public void testingLocationDatabaseConstructor() {
		LocationDatabase db2 = new LocationDatabase();
		assertNotNull(db2);
	}
	
	@Test
	public void testingLocationList() {
		assertEquals(db.getList(), new ArrayList<Location>());
	}
	
	@Test
	public void testingObjectMapper() {
		assertNotNull(db.getMapper());
	}
	
	@Test
	public void testingGetNone() {
		assertEquals(db.getNone(), none);
	}
	
	@Test
	public void testingRefreshList() {
		db.refreshList();
		assertNotNull(db.getList());
	}
	
	@Test
	public void testingReturnLocationValid() {
		assertEquals(db.returnLocation(cinema).getName(), cinema);
	}
	
	@Test
	public void testingReturnLocationInvalid() {
		assertNull(db.returnLocation(""));
	}
	
	@Test
	public void testingGetAllNames() {
		assertNotNull(db.getAllNames());
	}
	
	@Test
	public void testingReturnLocationWithValid() {
		assertEquals(db.returnLocationWith(movie).getName(), cinema);
	}
	
	@Test
	public void testingReturnLocationWithInvalid() {
		assertNull(db.returnLocationWith(null));
	}
}
