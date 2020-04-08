import java.util.Scanner;
import java.util.ArrayList;

public class Driver {

	private static boolean done = false;
	public static User user;
	private static Scanner in;
	
	// all the services that the program will offer, to be used in different functions
	public enum Service {EXIT, SEARCH, LOGIN, VIEW_POPULAR, VIEW_ACCOUNT, SEARCH_BY_NAME,
				  		 SEARCH_BY_DATE, SEARCH_BY_RATING, BUY_TICKETS, VIEW_CART, 
				  		 EMPTY_CART, RENEW_LOOP, RENEW_CHOICE, GO_BACK}; 
	
	// holds the choice history of the user
	private static ArrayList<Service> choiceHistory = new ArrayList<Service>();
	
	// welcomes the user with greeting messages
	private static void welcomeUser() {
		System.out.println("-------------------------------------------------------");
		System.out.println("                Welcome to CinemaStack!");
		System.out.println("-------------------------------------------------------");
		System.out.println("~~~ Please enjoy the fine services we have to offer ~~~\n");
	}
	
	// Gives the user actions to take upon entering the app, or when the loop
	// starts over because they go back to the initial actions
	private static Service getTopChoice() {
		System.out.println("Please enter one of the numbers below corresponding to the action you wish to take...");
		if (user.getType() == "guest") {
			return getUserChoice(new Service[] {Service.EXIT, Service.LOGIN, Service.SEARCH, Service.VIEW_POPULAR});
		} else {
			return getUserChoice(new Service[] {Service.EXIT, Service.VIEW_ACCOUNT, Service.SEARCH, Service.VIEW_POPULAR});
		}
	}
	
	// helper method to get user input with a set of service options easier
	private static Service getUserChoice(Service[] options) {
		int choice = -1;
		int count = 0;
		while(choice < 0 || choice >= options.length) { 
			if (count > 0)
				System.out.println("Invalid input... please try again...");
			// enumerate the options
			for (int i = 0; i < options.length; i++) {
				System.out.println("~ " + i + " " + getServiceMessage(options[i]));
			}
			// capture user input
			choice = in.nextInt();
			in.nextLine();
			count++;
		}
		
		// return the chosen service
		return options[choice];
	}
	
	// helper method to return a message for each Service
	private static String getServiceMessage(Service service) {
		
		// translate service to corresponding message
				switch(service) {
					case RENEW_LOOP:
						return "Go to the front page";
					case EXIT:
						return "Exit the program";
					case SEARCH:
						return "Search for events";
					case LOGIN:
						return "Login or sign up for an account";
					case VIEW_POPULAR:
						return "View popular events";
					case VIEW_ACCOUNT:
						return "View your account information";
					case SEARCH_BY_NAME:
						return "Search for events by movie title";
					case SEARCH_BY_DATE:
						return "Search for events within a date range";
					case SEARCH_BY_RATING:
						return "Search for events by rating";
					case BUY_TICKETS:
						return "Purchase the tickets in your cart";
					case VIEW_CART:
						return "View the current tickets in your shopping cart";
					case EMPTY_CART:
						return "Empty your current shopping cart";
					case GO_BACK:
						return "Go back to previous page";
						default:
							return "An invalid Service has been used";
							
				}
	}
	
	// checks what choice the user made and acts appropriately
	private static void actOnChoice(Service choice) {
		
		// create choice history or add new choice to the current history
		addChoiceToHistory(choice);
		
		// translate choice to corresponding action
		switch(choice) {
			case RENEW_LOOP:
				Service aChoice = getTopChoice();
				actOnChoice(aChoice);
				break;
			case EXIT:
				System.exit(0);
				break;
			case SEARCH:
				initiateSearch();
				break;
			case LOGIN:
				user = GenerateUser.generateUser();
				goBackChoice();
				break;
			case VIEW_POPULAR:
				viewPopularEvents();
				break;
			case VIEW_ACCOUNT:
				viewAccount();
				break;
			case SEARCH_BY_NAME:
				searchByMovie();
				break;
			case SEARCH_BY_DATE:
				searchByDateRange();
				break;
			case SEARCH_BY_RATING:
				searchByRating();
				break;
			case BUY_TICKETS:
				purchaseTickets();
				break;
			case VIEW_CART:
				// TODO view cart
				
				goBackChoice();
				break;
			case EMPTY_CART:
				// TODO empty the whole cart 
				break;
			case RENEW_CHOICE:
				renewChoice();
				break;
			case GO_BACK:
				goBackChoice();
				break;
			// other functions should be set up so that this won't occur but 
			// any improper case will just go back
				default:
					goBackChoice();
		}
	}
	
	/** adds the given choice to the user's choice history 
	 *  @param choice - Service choice to be added on top of the history stack
	 */
	private static void addChoiceToHistory(Service choice) {
		choiceHistory.add(choice);
	}
	
	// deletes the latest choice and renews the previous choice
	private static void goBackChoice() {
		
		// check if at least two choices have been made
		if (choiceHistory.size() > 1) {
			// remove the latest choice and renew the choice
			choiceHistory.remove(choiceHistory.size()-1);
			renewChoice();
		} else if (choiceHistory.size() == 1) {
			// renew the choice
			renewChoice();
		} else {
			// choiceHistory shouldn't be empty but show top choices if so
			Service choice = getTopChoice();
			actOnChoice(choice);
		}
	}
	
	// re-calls the function associated to the latest choice, if none, go through the loop again
	private static void renewChoice() {
		
		// check if a choice has been made
		if (!choiceHistory.isEmpty()) {
			// save the latest choice
			Service latestChoice = choiceHistory.get(choiceHistory.size()-1);
			// delete the latest choice from history since actOnChoice will add it to the history
			choiceHistory.remove(choiceHistory.size()-1);
			actOnChoice(latestChoice);
		} else {
			// call top options if no choice has been made - should never happen
			Service choice = getTopChoice();
			actOnChoice(choice);
		}
	}
	
	//******************* FUNCTIONS CALLED AFTER SELECTING SEARCH ********************//
	
	private static void initiateSearch() {
		// TODO ask search by what - something like Service choice = getSearchChoice
		// TODO call proper search - actOnChoice(choice)
	}
	
	private static void searchByMovie() {
		// TODO search the database for any movie times given by the movie name
		// TODO display the results
		// TODO give next options
		
	}
	
	private static void searchByDateRange() {
		// TODO have user enter two dates
		// TODO search database for events within those dates
		// TODO give results in chronological order, same time events are given by rating
		// TODO give next options
	}
	
	private static void searchByDateRange(Event event) {
		// TODO have user enter two dates
		// TODO search database for events within those dates
		// TODO give results in chronological order, same time events are given by rating
		// TODO give next options
	}
	
	private static void searchByRating() {
		// TODO have user enter a rating
		// TODO get all results above or equal to entered rating
		// TODO display all the Events given a certain rating
		// TODO display next option e.g choose an event and see its schedule, go back, go to beginning
	}
	
	//******************* FUNCTIONS CALLED AFTER SELECTING VIEW_POPULAR ********************//
	
	private static void viewPopularEvents() {
		// TODO ask user how many popular events to show
		// TODO access ratings to show the top X events
		// TODO display the top events
		// TODO ask next options
		//(DatabaseDriver.returnEvent("Frozen 2")).printEvent();
		DatabaseDriver.displayAllEvents();
	}
	
	//****************** FUNCTIONS CALLED AFTER SELECTING VIEW_ACCOUNT ********************//
	
	private static void viewAccount() {
		// TODO show shopping cart, all account fields
	}
	
	//******************* FUNCTIONS CALLED AFTER SELECTING BUY_TICKET ********************//

	private static void purchaseTickets() {
		Currency[] userWallet = user.getWallet();
		
	}
	
	public static void main(String[] args) {
		UserDatabase db = new UserDatabase();
		
		// create input stream
		in = new Scanner(System.in);
		
		// welcome user
		welcomeUser();
		
		// get the user to login or continue as guest
		user = GenerateUser.generateUser();
			
		// request a service from the user
		Service choice = getTopChoice();
		actOnChoice(choice);
		
		// close input stream
		in.close();
		
	}
}
