
public class Driver {

	public static void main(String[] args) {
		Database database = new Database();
		database.readAllCredentials();
		database.enterUser();
		database.readAllCredentials();
	}
	
	

}
