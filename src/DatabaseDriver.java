
public class DatabaseDriver {
	public static EventDatabase ev = new EventDatabase();
	public static LocationDatabase lv = new LocationDatabase();
	public static ScheduleDatabase sv = new ScheduleDatabase();
	public static UserDatabase uv = new UserDatabase();
	
	
	// print all the attributes of all events
	public static void printAllEvents() {
		ev.readAllEvents();
	}
	
	public static void enterNewEvent() {
		ev.enterEvent();
	}
	
	public static void wipeEventDatabase() {
		ev.wipeDatabase();
	}
	
	public static Event returnEvent(String name) {
		return ev.returnEventObjectByName(name);
	}
	
	public static void enterNewLocation() {
		lv.enterLocation();
	}
	public static void readAllLocations() {
		lv.readAllLocations();
	}
	
	public static void enterNewSchedule() {
		sv.enterSchedule();
	}
	public static void printAllSchedules() {
		sv.readAllSchedules();
	}
	
	public static void addUser() {
		uv.enterUser();
	}
	public static void wipeUserDatabase() {
		uv.wipeDatabase();
	}
	public static void printCredentials() {
		uv.readAllCredentials();
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
		Event event = returnEvent("Frozen 2");
		event.printEvent();
		
		
		
	}

}
