
public class DatabaseDriver {
	public static EventDatabase ev = new EventDatabase();
	
	// print all the attributes of all events
	public static void printAllEvents() {
		ev.readAllEvents();
	}
	
	public static void enterNewEvent() {
		ev.enterEvent();
	}
	
	public static void wipeDatabase() {
		ev.wipeDatabase();
	}
	
	public static Event returnEvent(String name) {
		return ev.returnEventObjectByName(name);
	}
	
	// find an event based on its name, return an Event object
	
	
	public static void main(String[] args) {
		//UserDatabase db = new UserDatabase();
		//db.readAllCredentials();
		//User user = GenerateUser.generateUser();
		//db.readAllCredentials();
		//printAllEvents();
		//enterNewEvent();
		printAllEvents();
		(returnEvent("Frozen 2")).printEvent();;
		
	}

}
