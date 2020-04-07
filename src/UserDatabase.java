import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

import java.io.FileWriter;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UserDatabase {
	public static final String ADMIN_PASSWORD = "admin123";
	public static final String EMPLOYEE_PASSWORD = "emp123";
	JSONArray userList;
	FileWriter file;
	Scanner scan;
	
	public UserDatabase() {
		userList = new JSONArray();
		scan = new Scanner(System.in);
	}
	
	private void parseUserObject(JSONObject user) 
    {
        JSONObject userObject = (JSONObject) user.get("user");
        System.out.println("\nEmail: " + (String) userObject.get("email"));  
        System.out.println("Username: " + (String) userObject.get("username"));
        System.out.println("Password: " + (String) userObject.get("password"));
        System.out.println("Age: " + (String) userObject.get("age"));
        System.out.println("Cool Points: " + (String) userObject.get("points"));
        System.out.println("ID: " + (String) userObject.get("ID"));
        System.out.println("Type: " + (String) userObject.get("type"));
        System.out.println("Discount: " + (String) userObject.get("discount"));
    }
	
	public JSONObject findUser(String user) {
		userList = readUserList();
		Iterator i = userList.iterator();
        while (i.hasNext()) {
        	JSONObject userObject = (JSONObject) i.next();
        	userObject = (JSONObject) userObject.get("user");
        	String username = (String) userObject.get("username");
        	if (user.equals(username))
        		return userObject;
        }
        return null;
	}
	
	public String getUserPassword(String user) {
		JSONObject userObject = findUser(user);
		return (String) userObject.get("password");
	}
	
	public String getType(String user) {
		JSONObject userObject = findUser(user);
		return (String) userObject.get("type");
	}

	public String parseUsername(JSONObject user) 
    {
        JSONObject userObject = (JSONObject) user.get("user");
        return (String) userObject.get("username");    
    }
	
	public String parsePassword(JSONObject user) 
    {
        JSONObject userObject = (JSONObject) user.get("user");
        return (String) userObject.get("password");    
    }
	
	public String parseEmail(JSONObject user)
	{
		JSONObject userObject = (JSONObject) user.get("user");
        return (String) userObject.get("email");   
	}
	
	public String parseAge(JSONObject user) {
		JSONObject userObject = (JSONObject) user.get("user");
        return (String) userObject.get("age");   
	}
	
	public String parsePoints(JSONObject user) {
		JSONObject userObject = (JSONObject) user.get("user");
		return (String) userObject.get("points");  
	}
	
	public String parseID(JSONObject user) {
		JSONObject userObject = (JSONObject) user.get("user");
		return (String) userObject.get("ID");  
	}
	
	public String parseDiscount(JSONObject user) {
		JSONObject userObject = (JSONObject) user.get("user");
		return (String) userObject.get("discount");  
	}
	
	public String parseType(JSONObject user) {
		JSONObject userObject = (JSONObject) user.get("user");
		return (String) userObject.get("type");  
	}
	
	public void enterUser() {
		System.out.println();
		String username = validateUsername();
		String password = validatePassword();
		String email = validateEmail();
		String age = validateAge();
		String points = "0";
		System.out.println("\nWe need some more information about you.");
		System.out.println("For each question, please enter the number corresponding to the answer choice that fits you.\n");
		String type = validateType();
		String ID = validateID(type);
		String discount = validateDiscount(type);
		JSONObject userDetails = new JSONObject();
		userDetails.put("username", username);
		userDetails.put("password", password);
		userDetails.put("email", email);
		userDetails.put("age", age);
		userDetails.put("points", points);
		userDetails.put("type", type);
		userDetails.put("ID", ID);
		userDetails.put("discount", discount);
		JSONObject userObject = new JSONObject();
		userObject.put("user", userDetails);
		
		userList = readUserList();
		userList.add(userObject);
		
		try (FileWriter file = new FileWriter("users.json")) {
			 
            file.write(userList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
	
	public String validateUsername() {
		String username = "";
		ArrayList<String> users = getAllUsernames();
		while(true) {
			System.out.println("Enter a username:");
			username = scan.nextLine();
			
			if (users.contains(username)) {
				System.out.println("Username already exists.");
				continue;
			}
			if (username.length() == 0) {
				System.out.println("Your username cannot be empty.");
				continue;
			}
			System.out.println("Username added.");
			break;
		}
		return username;
	}
	
	public String validateEmail() {
		String email = "";
		ArrayList<String> emails = getAllEmails();
		while(true) {
			System.out.println("Enter an email address:");
			email = scan.nextLine();
			if (emails.contains(email)) {
				System.out.println("Email address already exists.");
				continue;
			}
			if (email.length() == 0) {
				System.out.println("Your email adddress cannot be empty.");
				continue;
			}
			if ((!(email.contains(".")) || !(email.contains("@"))) || email.length() < 5) {
				System.out.println("Please enter a valid email address.");
				continue;
			}
			System.out.println("Email added.");
			break;
		}
		return email;
	}
	
	public String validatePassword() {
		String password = "";
		System.out.println("\nPassword Setup\n--------------");
		System.out.println("Please make sure this window is not in fullscreen mode.");
		System.out.println("A popup window is about to appear to record your password.");
		System.out.println("\nA password must have:");
		System.out.println("- at least 6 characters in total");
		System.out.println("- at least 1 uppercase character");
		System.out.println("- at least 1 lowercase character");
		System.out.println("\nPress the ENTER to continue...");
		scan.nextLine();
		while(true) {
			password = readPassword();
			
			if (password.length() < 6) {
				System.out.println("Your password must be at least 6 characters.");
				continue;
			}
			if (password.equals(password.toLowerCase())) {
				System.out.println("Your password must contain at least 1 uppercase character.");
				continue;
			}
			if (password.equals(password.toUpperCase())) {
				System.out.println("Your password must contain at least 1 lowercase character.");
				continue;
			}
			System.out.println("\nPassword added.");
			break;
		}
		return password;
	}
	
	public String validateAge() {
		int age = 0;
		while(true) {
			System.out.println("Enter your current age:");
			age = scan.nextInt();
			scan.nextLine();
			
			if (age < 18) {
				System.out.println("Please register this account with someone that is 18 or older.");
				continue;
			}
			if (age > 130) {
				System.out.println("That age is invalid.");
				continue;
			}
			else {
				System.out.println("Age added.");
				break;
			}
		}
		return String.valueOf(age);
	}
	
	public String validateID(String type) {
		String ID = "";
		String message = "";
		if (type.equals("handicapped"))
			message = "Enter your handicap tag number:";
		else if (type.equals("student") || type.equals("veteran") || type.equals("teacher"))
			message = "Enter your " + type + " ID number:";
		else if (type.equals("admin")) {
			System.out.println("Enter the admin password in the popup window.");
			String answer = readPassword();
			while(!answer.equals(ADMIN_PASSWORD)) {
				System.out.println("Incorrect password.");
				answer = readPassword();
			}
			message = "Enter your company ID number:";
		}
		else if (type.equals("employee")) {
			System.out.println("Enter the employee password in the popup window.");
			String answer = readPassword();
			while(!answer.equals(EMPLOYEE_PASSWORD)) {
				System.out.println("Incorrect password.");
				answer = readPassword();
			}
			message = "Enter your company ID number:";
		}
		else if (type.equals("none"))
			return type;
		
		while(true) {
			System.out.println(message);
			ID = scan.nextLine();
			if (ID.length() < 0) {
				System.out.println("ID invalid.");
				continue;
			}
			else {
				System.out.println("ID added.");
				break;
			}
		}
		return ID;
	}
	
	public String validateDiscount(String type) {
		if (type.equals("student") || type.equals("veteran") || type.equals("teacher") || type.equals("employee") || type.equals("handicapped"))
			return ".1";
		else
			return "0";
	}
	
	public String validateType() {
		System.out.println("Do you have a disability?");
		System.out.println("1. Yes\n2. No");
		int response = scan.nextInt();
		scan.nextLine();
		while(response != 1 && response != 2) {
			System.out.println("Please enter either 1 or 2.");
			response = scan.nextInt();
			scan.nextLine();
		}
		if (response == 1) {
			return "handicapped";
		}
		System.out.println("\nAre you currently one of these?");
		System.out.println("1. A student\n2. A veteran\n3. A teacher\n4. An employee\n5. An adminstrator");
		response = scan.nextInt();
		scan.nextLine();
		while(response != 1 && response != 2 && response != 3 && response != 4 && response != 5) {
			System.out.println("Please enter 1, 2, 3, 4, or 5.");
			response = scan.nextInt();
			scan.nextLine();
		}
		if (response == 1)
			return "student";
		if (response == 2)
			return "veteran";
		if (response == 3)
			return "teacher";
		if (response == 4)
			return "employee";
		if (response == 5)
			return "admin";
		else
			return "standard";
	}
	
	
	public String readPassword() {
		final String password, message = "Enter password";
		if (System.console() == null ) {
		  final JPasswordField pf = new JPasswordField(); 
		  password = JOptionPane.showConfirmDialog( null, pf, message,
		    JOptionPane.OK_CANCEL_OPTION,
		    JOptionPane.QUESTION_MESSAGE ) == JOptionPane.OK_OPTION ? 
		      new String( pf.getPassword() ) : "";
		}
		else 
		  password = new String( System.console().readPassword( "%s> ", message ) );
		return password;
	}
	
	public ArrayList<String> getAllUsernames() {
		ArrayList<String> users = new ArrayList<String>();
		JSONParser jsonParser = new JSONParser();
        JSONArray readUserList = readUserList();
        
        //JSONObject userObject = new JSONObject();
        try (FileReader reader = new FileReader("users.json"))
        {
        	readUserList.forEach( user -> users.add(parseUsername((JSONObject) user)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return users;
	}
	
	public ArrayList<String> getAllPasswords() {
		ArrayList<String> passwords = new ArrayList<String>();
		JSONParser jsonParser = new JSONParser();
        JSONArray readUserList = readUserList();
        
        try (FileReader reader = new FileReader("users.json"))
        {
        	readUserList.forEach( user -> passwords.add(parsePassword((JSONObject) user)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passwords;
	}
	
	public ArrayList<String> getAllEmails() {
		ArrayList<String> emails = new ArrayList<String>();
		JSONParser jsonParser = new JSONParser();
        JSONArray readUserList = readUserList();
        
        try (FileReader reader = new FileReader("users.json"))
        {
        	readUserList.forEach( user -> emails.add(parseEmail((JSONObject) user)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emails;
	}
	
	public void wipeDatabase() {
		userList = new JSONArray();
		try (FileWriter file = new FileWriter("users.json")) {
            file.write(userList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
	
	public JSONArray readUserList() {
        JSONParser jsonParser = new JSONParser();
        JSONArray readUserList = new JSONArray();
        
        try (FileReader reader = new FileReader("users.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            readUserList = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return readUserList;
	}
	
	public void readAllCredentials() {
		// reading
        JSONParser jsonParser = new JSONParser();
        JSONArray readUserList = readUserList();
        try (FileReader reader = new FileReader("users.json"))
        {
            System.out.println(readUserList);
            //Iterate over user array
            readUserList.forEach( emp -> parseUserObject( (JSONObject) emp ) );
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
}
