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
	protected int ratingSum;
	protected int ratingNum;
	
	
	protected void setUp() {
		String name = "Frozen";
		String type = "movie";
		ArrayList<String> comments = new ArrayList<String>();
		ArrayList<String> actors = new ArrayList<String>();
		ratingSum = 0;
		ratingNum = 0;
		event = new Event(name, type, comments, actors);
		System.out.println("initalizing");
		
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
		String name2 = "Frozen";
		String type2 = "movie";
		ArrayList<String> comments2 = new ArrayList<String>();
		comments2.add("hated it");
		ArrayList<String> actors2 = new ArrayList<String>();
		actors2.add("Anna");
		actors2.add("Elsa");
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
	public void testSetName() {
		String name_ = "new name";
		event.setName(name_);
		assertEquals(event.getName(), name_);
	}
	@Test
	public void testSetType() {
		String type_ = "new Type";
		event.setType(type_);
		assertEquals(event.getType(), type);
	}
	@Test
	public void testSetComments() {
		ArrayList<String> comments_ = new ArrayList<String>();
		event.setComments(comments_);
		assertEquals(event.getComments(), comments_);
	}
	@Test
	public void testSetActors() {
		ArrayList<String> actors_ = new ArrayList<String>();
		event.setActors(actors_);
		assertEquals(event.getActors(), actors_);

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
		actors = new ArrayList<String>();
		actors.add(null);
		assertNull(event.getActors());
	}
	@Test
	public void testGetRatingSum() {
		assertEquals( event.getRatingSum(), ratingSum);
	}
	@Test
	public void testSetRatingSum() {
		int newSum = 10;
		event.setRatingSum(newSum);
		assertEquals(event.getRatingSum(), newSum);

	}
	@Test
	public void testGetRatingNum() {
		assertEquals(event.getRatingNum(), ratingNum);

	}
	@Test
	public void testSetRatingNum() {
		event.setRatingNum(ratingNum);
		assertEquals(event.getRatingNum(), ratingNum);

	}
}
