import java.util.Scanner;

public class Driver {

	private boolean done = false;
	private User user;
	private Scanner in;
	
	// all the services that the program will offer, to be used in different functions
	private enum Service {EXIT, SEARCH, LOGIN, VIEW_POPULAR, VIEW_ACCOUNT, SEARCH_BY_MOVIE, SEARCH_BY_ACTOR,
				  		  SEARCH_BY_DATE, SEARCH_BY_SHOWTIME, SEARCH_BY_RATING, BUY_TICKET}; 
	private ArrayList<Service> choiceHistory;
	
	// welcomes the user with greeting messages
	private void welcomeUser() {
		System.out.println("Welcome to Portiango ... :D");
		System.out.println("Please enjoy the fine services we have to offer...\n");
	}
	
	// function to end or continue the program loop
	// ends if done is true, continues if done is false
	private boolean done() {
		return done;
	}
	
	// Gives the user actions to take upon entering the app, or when the loop
	// starts over because they go back to the initial actions
	private Service getTopChoice() {
		System.out.println("Please enter one of the numbers below corresponding to the action you wish to take...");
		if (user == null) {
			// display options
			System.out.println("0: Exit");
			System.out.println("1: Login to an account");
			System.out.println("2: Search for events");
			System.out.println("3: View popular events");
			
			// get choice as an integer
			int intChoice = in.getNextInt();
			
			// translate integer choice to the Service enum
			switch(intChoice) {
				case 0: return Service.EXIT;
				case 1: return Service.LOGIN;
				case 2: return Service.SEARCH;
				case 3: return Service.VIEW_POPULAR;
				case default:
					// renew the prompt by going through the loop again
					continue;
			}
		} else {
			// display options
			System.out.println("0: Exit");
			System.out.println("1: View your account");
			System.out.println("2: Search for events");
			System.out.println("3: View popular events");
			
			//get choice as an integer
			int intChoice = in.getNextInt();
			
			// translate integer choice to the Service enum
			switch(intChoice) {
				case 0: return Service.EXIT;
				case 1: return Service.VIEW_ACCOUNT;
				case 2: return Service.SEARCH;
				case 3: return Service.VIEW_POPULAR;
				case default:
					// renew the prompt by going through the loop again
					continue;
			}
		}
	}
	
	// checks what choice the user made and acts appropriately
	private void actOnChoice(Service choice) {
		
		// create choice history or add new choice to the current history
		addChoiceToHistory(choice);
		
		// translate choice to corresponding action
		switch(choice) {
			case Service.EXIT:
				done = true;
				continue;
			case Service.SEARCH:
				initiateSearch();
				break;
			case Service.LOGIN:
				initiateLogin();
				break;
			case Service.VIEW_POPULAR:
				initiateViewPopular();
				break;
			case Service.VIEW_ACCOUNT:
				initiateViewAccount();
				break;
			case Service.SEARCH_BY_MOVIE:
				searchByMovie();
				break;
			case Service.SEARCH_BY_ACTOR:
				searchByActor();
				break;
			case Service.SEARCH_BY_DATE:
				searchByDate();
				break;
			case Service.SEARCH_BY_SHOWTIME:
				searchByShowtime();
				break;
			case Service.SEARCH_BY_RATING:
				searchByRating();
				break;
			case Service.BUY_TICKET:
				initiateTicketPurchase();
				break;
			// other functions should be set up so that this won't occur but 
			// any improper case will just go back
				case default:
					goBackToPreviousChoice();
		}
	}
	
	private void goBackToPreviousChoice() {
		
	}
	
	private void renewChoice() {
		
	}
	
	/******************* FUNCTIONS CALLED AFTER SELECTING SEARCH ********************/
	
	/******************* FUNCTIONS CALLED AFTER SELECTING LOGIN ********************/
	
	/******************* FUNCTIONS CALLED AFTER SELECTING VIEW_POPULAR ********************/
	
	/******************* FUNCTIONS CALLED AFTER SELECTING VIEW_ACCOUNT ********************/
	
	/******************* FUNCTIONS CALLED AFTER SELECTING BUY_TICKET ********************/

	
	
	public static void main(String[] args) {
		Database database = new Database();
		/*
		database.readAllCredentials();
		System.out.println();
		database.wipeDatabase();
		database.readAllCredentials();
		System.out.println();
		*/
		//database.validateUsername();
		database.enterUser();
		database.readAllCredentials();
		
		// create input stream
		in = new Scanner(System.in);
		
		// welcome user
		welcomeUser();
		
		// start program loop
		while(!done()) {
			
			// ask for service
			Service choice = getTopChoice();
			actOnChoice(choice);
		}
		
		// close input stream
		in.close();
	}
}
