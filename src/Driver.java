import java.util.Scanner;
import java.util.ArrayList;

public class Driver {

	public static User user;
	private static Scanner in;
	
	// starting page
	static Page homePage = new Page();
	
	// search pages and links
	static Page searchPage = new Page();
	
	// admin page
	static Page adminOptionsPage = new Page();
	
	// employee page
	static Page employeeOptionsPage = new Page();
	
	// account pages and links
	static Page accountPage = new Page();
	
	// view popular pages and links
	static Page eventsPage = new Page();
	
	/**
	 * helper method to easily validate user input for choices
	 * @param highestChoice
	 * @return int - value corresponding to a choice given to the user
	 */
	private static int getValidatedChoice(int highestChoice) {
		while (true) {
			String strChoice = in.nextLine();
			if (!strChoice.matches("[0-9]+")) {
				System.out.println("Error, please enter an integer value ...");
				continue;
			}
			int intChoice = Integer.parseInt(strChoice);
			if (intChoice < 0 || intChoice > highestChoice) {
				System.out.println("Error, please choose an integer within the range 0 to " + highestChoice + " inclusive");
				continue;
			}
			return intChoice;
		}
	}
	
	// Page setup and initialization
	// homepage setup display and 
	private static void setUpHomePage() {
		homePage.setDisplay("  *******************    ******************* 	 ******************* \n" +
				 		 	"  *                 *    *                 * 	 *				   * \n" +
				 		 	"  *    HOME PAGE    *    *    0: Search    * 	 * 1: View Account * \n" +
				 		 	"  *                 *    *                 *    *				   * \n" +
				 		 	"  *******************    *******************    ******************* \n" +
				 		 	"                                             						 \n" +
				 		 	"  *******************    ******************* 	 \n" +
				 		 	"  *                 *    *                 * 	 \n" +
				 		 	"  * 2: View Events  *    *     3: Exit     * 	 \n" +
				 		 	"  *                 *    *                 * 	 \n" +
				 		 	"  *******************    ******************* 	 \n" +
				 		 	"\n\n IF YOU ARE EMPLOYEE OR ADMIN --- 4: Go to your functionality");
	}
	private static void homePageManager() {
		// TODO display home page
		// TODO ask for user input
		
		// TODO 0 go to Search Page
		   // TODO done with that path
		// TODO 1 go to Account Page
			// TODO done with that path
		// TODO 2 go to EVents page
			// TODO done with that path
		// TODO 3 System.exit(0); we outcha
			// TODO done with that path
		// TODO 4 check admin or employee,
			// TODO go to page or stay and redo homePageManager()
	}
	
	// searchpage setup display
	private static void setUpSearchPage() {
		searchPage.setDisplay("  *******************    *******************    ******************* \n" +
	 		 				  "  *                 *    *                 *    *				 * \n" +
	 		 				  "  *   SEARCH PAGE   *    *   0: By Title   *    *   1: By Date	 * \n" +
	 		 				  "  *                 *    *                 *    *				 * \n" +
	 		 				  "  *******************    *******************    ******************* \n" +
	 		 				  "                                             					   \n" +
	 		 				  "  *******************    *******************    ******************* \n" +
	 		 				  "  *                 *    * 			      *    *				 * \n" +
	 		 				  "  *   2: By Rating  *    *   3: By Actor   *    *  4: Home Page	 * \n" +
	 		 				  "  *                 *    * 			      *    *				 * \n" +
	 		 				  "  *******************    *******************    ******************* \n");
	}
	private static void searchPageManager() {
		// TODO display search page
		// TODO get user imput 
		
		// TODO 0 use db stuff to search for showtimes by user specified title
			// TODO list these for the user if exists, redo searchPageManager if not
			// TODO ask if want to add it to cart
				// TODO if so, they enter the number of tickets for event
				// TODO if not, redo searchPageManager
		// TODO 1 use db stuff to search for showtimes on a specified date
			// TODO list these for user if exitsts, redo searchPageManager if not
				// TODO ask if user wants to add any showtimes to cart
		
	}
	
	// adminpage setup display
	private static void setUpAdminPage() {
		adminOptionsPage.setDisplay("  ****************************************** 	 \n" +
	 		 						"  *                                        * 	 \n" +
	 		 						"  *        ADMIN USER OPTIONS PAGE         * 	 \n" +
	 		 						"  *                                        *    \n" +
	 		 						"  ******************************************    \n" +
	 		 						"                                             	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *   0: Add User   *    * 1: Add Location * 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"                                                  " +
	 		 						"  ****************************************** 	 \n" +
	 		 						"  *                                        * 	 \n" +
	 		 						"  *        3: GO BACK TO HOME PAGE         * 	 \n" +
	 		 						"  *                                        *    \n" +
	 		 						"  ******************************************    ");
	}
	private static void adminPageManager() {
		// TODO display admin page
		// TODO get user input
	}
	
	// employee page setup display
	private static void setUpEventsPage() {
		eventsPage.setDisplay(      "  ****************************************** 	 \n" +
	 		 						"  *                                        * 	 \n" +
	 		 						"  *       EMPLOYEE USER OPTIONS PAGE       * 	 \n" +
	 		 						"  *                                        *    \n" +
	 		 						"  ******************************************    \n" +
	 		 						"                                             	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *     -     -     * 	 \n" +
	 		 						"  *  0: Add Event   *    *   ^        ^    * 	 \n" +
	 		 						"  *                 *    *     \\_____/     * 	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"                                                  " +
	 		 						"  ****************************************** 	 \n" +
	 		 						"  *                                        * 	 \n" +
	 		 						"  *        1: GO BACK TO HOME PAGE         * 	 \n" +
	 		 						"  *                                        *    \n" +
	 		 						"  ******************************************    "););
	}
	private static void eventPageManager() {
		// TODO display events page
		// TODO get user input
	}
	
	
	private static void setUpAccountPage() {
		accountPage.setDisplay(     
	 		 						"                                             	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *  0: View Wallet *    *  1: View Cart   * 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"                                             	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  * 2: Purchase Tix *    * 3: View Tickets * 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"                                                \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *  4: Empty Cart  *    *     5: Exit     * 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
									"  *******************    ******************* 	 \n");
	}
	private static void accountPageManager() {
		// TODO display account page
		// TODO get user input
	}
	
	// welcomes the user with greeting messages
	private static void welcomeUser() {
		System.out.println("-------------------------------------------------------");
		System.out.println("                Welcome to CinemaStack!");
		System.out.println("-------------------------------------------------------");
		System.out.println("~~~ Please enjoy the fine services we have to offer ~~~\n");
	}
	
	public static void main(String[] args) {
		
		setUpHomePage();
		setUpSearchPage();
		
		
		// create input stream
		in = new Scanner(System.in);
		
		// welcome user
		welcomeUser();
		
		// get the user to login or continue as guest
		user = GenerateUser.generateUser();
		
		// start user off on the home page
		homePageManager();
		
		// close input stream
		in.close();
		
	}
}