import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class EventTest extends TestCase{
	protected String name;
	protected String type;
	protected ArrayList<String> comments;
	protected ArrayList<String> actors;
	protected Event event;
	
	protected void setUp() {
		String name = "Frozen";
		String type = "movie";
		ArrayList<String> comments = new ArrayList<String>();
		ArrayList<String> actors = new ArrayList<String>();
	}
	protected void tearDown() {
		String name = null;
		String type = null;
		ArrayList<String> comments = null;
		ArrayList<String> actors = null;
	}
	@Test
	public void testCreateEvent() {
		event = new Event(name, type, comments, actors);
		assertNotNull(event);
	}
	@Test
	public void testTwoEventsArentEqual() {
		comments.add("good film");
		actors.add("brad pitt");
		event = new Event(name, type, comments, actors);
		
		String name2 = "Frozen";
		String type2 = "movie";
		ArrayList<String> comments2 = new ArrayList<String>();
		comments.add("hated it");
		ArrayList<String> actors2 = new ArrayList<String>();
		actors.add("Anna");
		actors.add("Elsa");
		Event event2 = new Event(name2, type2, comments2, actors2);
		assertNotEquals(event, event2);
	}
	@Test
	public void testCreateNullEvent() {
		name = null;
		type = null;
		comments = null;
		actors = null;
		event = new Event(name, type, comments, actors);
		assertNull(event);
	}
	@Test
	public void testGetName() {
		assertEquals(event.getName(), name);
	}
	@Test
	public void testGetType() {
		assertEquals(event.getType(), type);
	}
	@Test
	public void testGetComments() {

		assertEquals(event.getComments(), comments);
	}
	@Test
	public void testGetActors() {

		assertEquals(event.getActors(), actors);

	}
	@Test
	public void testAddComments() {

		String comment = "User comment";
		event.addUserComment(comment);
		assertEquals(event.getComments(), comments);
	}
	@Test
	public void testAddEmptyComments() {

		String comment = null;
		event.addUserComment(comment);
		assertEquals(event.getComments(), comments);
	}
	@Test
	public void testAddNullActors() {

		actors.add(null);
		assertNull(event.getActors());
	}


}
