import java.util.Scanner;
import java.util.ArrayList;

public class Driver {

	public static User user;
	private static Scanner in;
	
	// Page construction
	Page homePage = new Page();
	
	// search pages
	Page searchPage = new Page();
	Page searchByTitlePage = new Page();
	Page searchByDatePage = new Page();
	Page searchByRatingPage = new Page();
	Page searchByActorPage = new Page();
	
	Page accountPage = new Page();
	Page eventsPage = new Page();
	
	// Page setup and initialization
	// homepage setup display and 
	public void setUpHomePage() {
		homePage.setDisplay("  *******************    ******************* \n" +
				 		 	"  *                 *    *                 * \n" +
				 		 	"  *    HOME PAGE    *    *    0: Search    * \n" +
				 		 	"  *                 *    *                 * \n" +
				 		 	"  *******************    ******************* \n" +
				 		 	"                                             \n" +
				 		 	"  *******************    ******************* \n" +
				 		 	"  *                 *    *       View      * \n" +
				 		 	"  * 1: View Account *    *   2: Popular    * \n" +
				 		 	"  *                 *    *      Events     * \n" +
				 		 	"  *******************    ******************* \n" +
				 		 	homePage.goToAdminOptions(user) + homePage.goToEmployeeOptions(user) + "\n");
		homePage.getLinks().add(searchPage);
		homePage.getLinks().add(accountPage);
		homePage.getLinks().add(eventsPage);
	}
	
	// searchpage setup display
	public void setUpSearchPage() {
		searchPage.setDisplay("  *******************    *******************    ******************* \n" +
	 		 				  "  *                 *    *                 *    *				 * \n" +
	 		 				  "  *   Search Page   *    *   0: By Title   *    *   1: By Date	 * \n" +
	 		 				  "  *                 *    *                 *    *				 * \n" +
	 		 				  "  *******************    *******************    ******************* \n" +
	 		 				  "                                             					   \n" +
	 		 				  "  *******************    *******************    ******************* \n" +
	 		 				  "  *                 *    * 			      *    *				 * \n" +
	 		 				  "  *   2: By Rating  *    *   3: By Actor   *    *  4: Home Page	 * \n" +
	 		 				  "  *                 *    * 			      *    *				 * \n" +
	 		 				  "  *******************    *******************    ******************* \n\n" +
	 		 				  "  Pick the number for the criteria you wish to search by: " +
	 		 				  homePage.goToAdminOptions(user) + homePage.goToEmployeeOptions(user) + "\n");
		homePage.getLinks().add(searchByTitlePage);
		homePage.getLinks().add(searchByDatePage);
		homePage.getLinks().add(searchByRatingPage);
		homePage.getLinks().add(searchByActorPage);
	}
	
	// welcomes the user with greeting messages
	private static void welcomeUser() {
		System.out.println("-------------------------------------------------------");
		System.out.println("                Welcome to CinemaStack!");
		System.out.println("-------------------------------------------------------");
		System.out.println("~~~ Please enjoy the fine services we have to offer ~~~\n");
	}
	
	public static void main(String[] args) {
		
		
		// create input stream
		in = new Scanner(System.in);
		
		// welcome user
		welcomeUser();
		
		// get the user to login or continue as guest
		user = GenerateUser.generateUser();
		
		if (!user.getType().equalsIgnoreCase("admin") && !user.getType().equalsIgnoreCase("employee")) {
			System.out.println("Hello " + user.getUsername() + " please enter the number of your next move:");
			System.out.println("1: View Account")
		}
		
		// close input stream
		in.close();
		
	}
}