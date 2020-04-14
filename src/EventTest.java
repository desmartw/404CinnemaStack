import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class EventTest {
	
	

	@Test
	public void testCreateEvent() {
		String name = "Frozen";
		String type = "movie";
		ArrayList<String> comments = new ArrayList<String>();
		comments.add("good film");
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("brad pitt");
		Event event = new Event(name, type, comments, actors);
		assertNotNull(event);
	}
	
	public void testGetName() {
		String name = "Frozen";
		String type = "movie";
		ArrayList<String> comments = new ArrayList<String>();
		comments.add("good film");
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("brad pitt");
		Event event = new Event(name, type, comments, actors);
		assertEquals(event.getName(), name);
	}
	
	public void testGetType() {
		String name = "Frozen";
		String type = "movie";
		ArrayList<String> comments = new ArrayList<String>();
		comments.add("good film");
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("brad pitt");
		Event event = new Event(name, type, comments, actors);
		assertEquals(event.getType(), type);
	}
	
	public void testGetComments() {
		String name = "Frozen";
		String type = "movie";
		ArrayList<String> comments = new ArrayList<String>();
		comments.add("good film");
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("brad pitt");
		Event event = new Event(name, type, comments, actors);
		assertEquals(event.getComments(), comments);
	}
	public void testGetActors() {
		String name = "Frozen";
		String type = "movie";
		ArrayList<String> comments = new ArrayList<String>();
		comments.add("good film");
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("brad pitt");
		Event event = new Event(name, type, comments, actors);
		assertEquals(event.getActors(), actors);
	}
	public void testAddComments() {
		String name = "Frozen";
		String type = "movie";
		String comment =  "test comment";
		ArrayList<String> comments = new ArrayList<String>();
		comments.add("good film");
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("brad pitt");
		Event event = new Event(name, type, comments, actors);
		event.addUserComment(comment);
		assertEquals(event.getComments(), comments);
	}
	public void testAddEmptyComments() {
		String name = "Frozen";
		String type = "movie";
		String comment =  null;
		ArrayList<String> comments = new ArrayList<String>();
		comments.add("good film");
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("brad pitt");
		Event event = new Event(name, type, comments, actors);
		event.addUserComment(comment);
		assertEquals(event.getComments(), comments);
	}


}
