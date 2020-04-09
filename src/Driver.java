import java.util.Scanner;
import java.util.ArrayList;

public class Driver {

	public static User user;
	private static Scanner in;
	
	// all the services that the program will offer, to be used in different functions
	public enum Service {EXIT, SEARCH, LOGIN, VIEW_POPULAR, VIEW_ACCOUNT, SEARCH_BY_NAME,
				  		 SEARCH_BY_DATE, SEARCH_BY_RATING, BUY_TICKETS, VIEW_CART, 
				  		 EMPTY_CART, RENEW_FRONT, RENEW_CHOICE, GO_BACK, ADD_EVENT,
				  		 ADD_LOCATION, ADD_USER, SELECT_TICKET, RATE_EVENT}; 
	
	// holds the choice history of the user
	private static ArrayList<Service> choiceHistory = new ArrayList<Service>();
	
	// welcomes the user with greeting messages
	private static void welcomeUser() {
		System.out.println("-------------------------------------------------------");
		System.out.println("                Welcome to CinemaStack!");
		System.out.println("-------------------------------------------------------");
		System.out.println("~~~ Please enjoy the fine services we have to offer ~~~\n");
	}
	
	// displays a farewell upon exiting the application
	private static void displayFarewell() {
		// TODO add cool farewell with dope text image
	}
	
	// Gives the user actions to take upon entering the app, or when the loop
	// starts over because they go back to the initial actions
	private static Service getTopChoice() {
		System.out.println("Please enter one of the numbers below corresponding to the action you wish to take...");
		if (user.getType() == "guest") {
			return getUserChoice(new Service[] {Service.EXIT, Service.LOGIN, Service.SEARCH, Service.VIEW_POPULAR});
		} else if (user.getType() == "employee") {
			return getUserChoice(new Service[] {Service.EXIT, Service.VIEW_ACCOUNT, Service.SEARCH, Service.VIEW_POPULAR,
												Service.ADD_EVENT});
		} else if (user.getType() == "admin") {
			return getUserChoice(new Service[] {Service.EXIT, Service.VIEW_ACCOUNT, Service.SEARCH, Service.VIEW_POPULAR,
												Service.ADD_EVENT, Service.ADD_LOCATION, Service.ADD_USER});
		} else {
			return getUserChoice(new Service[] {Service.EXIT, Service.VIEW_ACCOUNT, Service.SEARCH, Service.VIEW_POPULAR});
		}
	}
	
	// helper method to get user input with a set of service options easier
	private static Service getUserChoice(Service[] options) {
		
		// present the options
		for (int i = 0; i < options.length; i++) {
			System.out.println("~ " + i + " " + getServiceMessage(options[i]));
		}
		
		// capture user choice
		int intChoice = getValidatedChoice(options.length);
		
		// return the chosen service
		return options[intChoice];
	}
	
	// helper method that validates user has entered in an integer corresponding to options presented
	public static int getValidatedChoice(int numOptions) {
		String choice = "";
		int intChoice = -1;
		while(true) {
			choice = in.nextLine();
			// validate choice is an integer
			if (!(choice.matches("[0-9]+") || choice.length() == 0)) {
				System.out.println("Choice must be an integer");
				continue;
			}
			intChoice = Integer.parseInt(choice);
			if (intChoice < 0 || intChoice >= numOptions) {
				System.out.println("Choice must be an integer corresponding to an action");
				continue;
			}
			break;
		}
		return intChoice;
	}
	
	// helper method to return a message for each Service
	private static String getServiceMessage(Service service) {
		
		// translate service to corresponding message
				switch(service) {
					case RENEW_FRONT:
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
					case ADD_EVENT:
						return "Add an event to the database";
					case SELECT_TICKET:
						return "Add an event from the list to your shopping cart";
					case RATE_EVENT:
						return "Rate an event from the list";
						default:
							return "An invalid Service has been used";
							
				}
	}
	
	// checks what choice the user made and acts appropriately
	private static void actOnChoice(Service choice) {
		
		// create choice history or add new choice to the current history
		addChoiceToHistory(choice);
		
		// translate choice to corresponding action
		// all choices that do not lead to more options are followed by goBackChoice()
		switch(choice) {
			case RENEW_FRONT:
				Service aChoice = getTopChoice();
				actOnChoice(aChoice);
				break;
			case EXIT:
				displayFarewell();
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
				user.viewAccount();
				Service aChoice = getUserChoice(new Service[] {Service.EXIT, Service.BUY_TICKETS, Service.EMPTY_CART});
				actOnChoice(aChoice);
				break;
			case SEARCH_BY_NAME:
				searchByName();
				break;
			case SEARCH_BY_DATE:
				searchByDateRange();
				break;
			case SEARCH_BY_RATING:
				searchByRating();
				break;
			case BUY_TICKETS:
				user.purchaseTickets();
				goBackChoice();
				break;
			case VIEW_CART:
				user.viewCart();
				Service aChoice = getUserChoice();
				actOnChoice(aChoice);
				break;
			case EMPTY_CART:
				user.emptyCart();
				System.out.println("Cart emptied ... reloading previous page ...");
				goBackChoice();
				break;
			case RENEW_CHOICE:
				// remove the choice taken to RENEW_CHOICE
				choiceHistory.remove(choiceHistory.size()-1);
				renewChoice();
				break;
			case GO_BACK:
				// remove the choice taken to GO_BACK
				choiceHistory.remove(choiceHistory.size()-1);
				goBackChoice();
				break;
			case ADD_EVENT:
				
				break;
			case ADD_LOCATION:
				// TODO
				break;
			case ADD_USER:
				// TODO
				break;
			case SELECT_TICKET:
				// TODO
				break;
			case RATE_EVENT:
				// TODO
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
		System.out.println("Select the criteria you wish to search by: \n");
		Service choice = getUserChoice(new Service[] {Service.EXIT, Service.SEARCH_BY_DATE, Service.SEARCH_BY_NAME,
													  Service.SEARCH_BY_RATING, Service.GO_BACK});
		actOnChoice(choice);
	}
	
	private static void searchByName() {
		System.out.println("Enter the event name you wish to search: ");
		String name = in.nextLine();
		Event event = DatabaseDriver.returnEvent(name);
		if (event == null) {
			System.out.println("No event by that name found ... reloading Search page");
			goBackChoice();
		} else {
			System.out.println("Event found ... loading Event information ...\n");
			event.printEvent();
		}
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
		// TODO access ratings to show the top events
		// TODO display the top events
		// TODO ask next options
		//(DatabaseDriver.returnEvent("Frozen 2")).printEvent();
		DatabaseDriver.displayAllEvents();
		Service choice = getUserChoice(new Service[] {Service.EXIT, Service.SELECT_TICKET, Service.RATE_EVENT, Service.GO_BACK});
		actOnChoice(choice);
	}
	
	private static void enterEventToLocation(Location loc) {
		DatabaseDriver.enterNewEvent(user.getLocation());
	}
	
	public static void main(String[] args) {
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
