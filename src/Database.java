import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

import java.io.FileWriter;
import java.io.Console;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Driver.Service;


public class Database {
	JSONArray userList;
	FileWriter file;
	Scanner scan;
	
	public Database() {
		userList = new JSONArray();
		scan = new Scanner(System.in);
	}
	
	private static void parseUserObject(JSONObject user) 
    {
        JSONObject userObject = (JSONObject) user.get("user");
        
        String email = (String) userObject.get("email");    
        System.out.println(email);
         
        String username = (String) userObject.get("username");    
        System.out.println(username);
         
        String password = (String) userObject.get("password");  
        System.out.println(password);
    }
	
	private String parseUsername(JSONObject user) 
    {
        JSONObject userObject = (JSONObject) user.get("user");
        return (String) userObject.get("username");    
    }
	
	private String parsePassword(JSONObject user) 
    {
        JSONObject userObject = (JSONObject) user.get("user");
        return (String) userObject.get("password");    
    }
	
	private String parseEmail(JSONObject user)
	{
		JSONObject userObject = (JSONObject) user.get("user");
        return (String) userObject.get("email");   
	}
	
	public void enterUser() {
		String username = validateUsername();
		String password = validatePassword();
		String email = validateEmail();
		
		JSONObject userDetails = new JSONObject();
		userDetails.put("username", username);
		userDetails.put("password", password);
		userDetails.put("email", email);
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
