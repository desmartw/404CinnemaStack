import java.util.Scanner;
import java.util.Stack;

public class Driver {

	private static boolean done = false;
	public static User user;
	private static Scanner in;
	
	// all the services that the program will offer, to be used in different functions
	public enum Service {EXIT, SEARCH, LOGIN, VIEW_POPULAR, VIEW_ACCOUNT, SEARCH_BY_MOVIE, SEARCH_BY_ACTOR,
				  		  SEARCH_BY_DATE, SEARCH_BY_SHOWTIME, SEARCH_BY_RATING, BUY_TICKETS, VIEW_OTHER_USER,
				  		  VIEW_CART, EMPTY_CART, RENEW_LOOP, RENEW_CHOICE, GO_BACK_A_CHOICE}; 
	
	// holds the choice history of the user
	private static Stack<Service> choiceHistory = new Stack<Service>();
	
	// welcomes the user with greeting messages
	private static void welcomeUser() {
		System.out.println("Welcome to Portiango ... :D");
		System.out.println("Please enjoy the fine services we have to offer...\n");
	}
	
	// function to end or continue the program loop
	// ends if done is true, continues if done is false
	private static boolean done() {
		return done;
	}
	
	// Gives the user actions to take upon entering the app, or when the loop
	// starts over because they go back to the initial actions
	private static Service getTopChoice() {
		System.out.println("Please enter one of the numbers below corresponding to the action you wish to take...");
		if (user == null) { // TODO this check for guest user is invalid must be changed
			// display options
			System.out.println("0: Exit");
			System.out.println("1: Login to an account");
			System.out.println("2: Search for events");
			System.out.println("3: View popular events");
			
			// get choice as an integer
			int intChoice = in.nextInt();
			
			// translate integer choice to the Service enum
			switch(intChoice) {
				case 0: return Service.EXIT;
				case 1: return Service.LOGIN;
				case 2: return Service.SEARCH;
				case 3: return Service.VIEW_POPULAR;
				default:
					// renew the prompt by going through the loop again
					return Service.RENEW_LOOP; // TODO this service may cause dysfunctionality and need to be changed so remove todo if it doesn't
			}
		} else {
			// display options
			System.out.println("0: Exit");
			System.out.println("1: View your account");
			System.out.println("2: Search for events");
			System.out.println("3: View popular events");
			
			//get choice as an integer
			int intChoice = in.nextInt();
			
			// translate integer choice to the Service enum
			switch(intChoice) {
				case 0: return Service.EXIT;
				case 1: return Service.VIEW_ACCOUNT;
				case 2: return Service.SEARCH;
				case 3: return Service.VIEW_POPULAR;
				default:
					// renew the prompt
					return Service.RENEW_LOOP; // TODO this service may cause dysfunctionality and need to be changed so remove todo if it doesn't
			}
		}
	}
	
	// TODO helper method to return a message for each Service
	private static String getServiceMessage(Service service) {
		return "";
	}
	
	// TODO helper method to make displaying user options easy
	private static void displayOptions(Service[] options) {
		
	}
	
	// checks what choice the user made and acts appropriately
	private static void actOnChoice(Service choice) {
		
		// create choice history or add new choice to the current history
		addChoiceToHistory(choice);
		
		// translate choice to corresponding action
		switch(choice) {
			case RENEW_LOOP:
				// does nothing so the loop reruns
				break;
			case EXIT:
				done = true;
				break;
			case SEARCH:
				initiateSearch();
				break;
			case LOGIN:
				login();
				break;
			case VIEW_POPULAR:
				viewPopularEvents();
				break;
			case VIEW_ACCOUNT:
				viewAccount();
				break;
			case SEARCH_BY_MOVIE:
				searchByMovie();
				break;
			case SEARCH_BY_ACTOR:
				searchByActor();
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
			case VIEW_OTHER_USER:
				// TODO add a way to request a user, probs just username
				// TODO String uname = requestUsername(); 
				User otherUser = db.getUser(uname);
				viewAccount(otherUser);
				break;
			case VIEW_CART:
				// TODO view cart
				break;
			case EMPTY_CART:
				// TODO empty the whole cart - this is not a purchase but will be called after a purchase
				break;
			case RENEW_CHOICE:
				renewChoice();
				break;
			case GO_BACK_A_CHOICE:
				goBackToPreviousChoice();
				break;
			// other functions should be set up so that this won't occur but 
			// any improper case will just go back
				default:
					goBackToPreviousChoice();
		}
	}
	
	/** adds the given choice to the user's choice history 
	 *  @param choice - Service choice to be added on top of the history stack
	 */
	private static void addChoiceToHistory(Service choice) {
		choiceHistory.push(choice);
	}
	
	// deletes the latest choice and renews the previous choice
	private static void goBackToPreviousChoice() {
		
		// checks if the history is empty - this shouldn't happen but should be checked
		if (choiceHistory.peek() == null) {
			
			// displays the initial options
			actOnChoice(Service.RENEW_LOOP);
		} else {
			
			// removes the latest choice
			choiceHistory.pop();
			
			// checks if the choice popped was the first choice made
			if (choiceHistory.peek() == null) {
				actOnChoice(Service.RENEW_LOOP); 
			} else {
				actOnChoice(choiceHistory.peek());
			}
		}
	}
	
	// re-calls the function associated to the latest choice, if none, go through the loop again
	private static void renewChoice() {
		
		// makes sure a choice has been made - this should always be the case but should be checked anyways
		if (choiceHistory.peek() != null) {
			actOnChoice(choiceHistory.peek());
		} else {
			
			// if no choice in history, display the initial options
			actOnChoice(Service.RENEW_LOOP); // just reruns the loop
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
	
	private static void searchByActor() {
		// TODO search the database for any event with specified actor times given by the movie name
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
	
	//******************* FUNCTIONS CALLED AFTER SELECTING LOGIN ********************//
	
	private static void login() {
		// TODO prompt user for login
		// TODO return a successful or unsuccessful account, place it into user
		// TODO if successful, viewAccount(user) and then go back to their previous choice
	    // TODO if unsuccessful, continue as guest and tell user and go back to their previous choice		
	}
	
	//******************* FUNCTIONS CALLED AFTER SELECTING VIEW_POPULAR ********************//
	
	private static void viewPopularEvents() {
		// TODO ask user how many popular events to show
		// TODO access ratings to show the top X events
		// TODO display the top events
		// TODO ask next options
	}
	
	//****************** FUNCTIONS CALLED AFTER SELECTING VIEW_ACCOUNT ********************//
	
	private static void viewAccount() {
		// TODO show shopping cart, all account fields
	}
	
	// used when a user has been searched for and to be viewed by another user
	private static void viewAccount(User user) {
		// TODO show ALL user information from the logged in account
	}
	
	//******************* FUNCTIONS CALLED AFTER SELECTING BUY_TICKET ********************//

	private static void purchaseTickets() {
		// TODO access user cart
		// TODO access currency, if guest ask for currency
		// TODO display receipt of transaction
		// TODO go to top options
	}
	
	public static void main(String[] args) {
		UserDatabase db = new UserDatabase();
		
		// create input stream
		in = new Scanner(System.in);
		
		// welcome user
		welcomeUser();
		
		// get the user to login or continue as guest
		user = db.generateUser();
		
		// start program loop
		while(!done()) {
			
			// request a service from the user
			Service choice = getTopChoice();
			actOnChoice(choice);
		}
		
		// close input stream
		in.close();
	}
}