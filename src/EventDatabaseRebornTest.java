import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.TestCase;

public class EventDatabaseRebornTest extends TestCase{
	protected EventDatabaseReborn db;
	
	protected void setUp() throws Exception {
		db = new EventDatabaseReborn();
	}

	@Test
	public void testingEventDatabaseRebornConstructor() {
		EventDatabaseReborn db2 = new EventDatabaseReborn();
		assertNotNull(db2);
	}
	
	@Test
	public void testingEventList() {
		assertEquals(db.getList(), new ArrayList<Event>());
	}
	
	@Test
	public void testingObjectMapper() {
		assertNotNull(db.getMapper());
	}
	
	@Test
	public void testingGetEventTypes() {
		assertNotNull(db.getEventTypes());
	}
	
	@Test
	public void testingRefreshList() {
		db.refreshList();
		assertNotNull(db.getList());
	}
	
	@Test
	public void testingGetAllNames() {
		assertNotNull(db.getAllNames());
	}
	
	@Test
	public void testingReadEventList() {
		assertNotNull(db.readEventList());
	}

}
