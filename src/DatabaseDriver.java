
public class DatabaseDriver {

	public static void main(String[] args) {
		UserDatabase db = new UserDatabase();
		db.readAllCredentials();
		User user = GenerateUser.generateUser();
		db.readAllCredentials();
	}

}
