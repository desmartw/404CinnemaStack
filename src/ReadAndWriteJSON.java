
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ReadAndWriteJSON {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//TODO: Streamline this process with methods
		
		// writing
		JSONObject userDetails = new JSONObject();
		userDetails.put("username", "johndoe123");
		userDetails.put("password", "password123");
		JSONObject userObject = new JSONObject();
		userObject.put("user", userDetails);
		
		JSONObject userDetails2 = new JSONObject();
		userDetails2.put("username", "batman420");
		userDetails2.put("password", "iambrucewayne6969");
		JSONObject userObject2 = new JSONObject();
		userObject2.put("user", userDetails2);
		
		JSONArray userList = new JSONArray();
		userList.add(userObject);
		userList.add(userObject2);
		
        try (FileWriter file = new FileWriter("users.json")) {
 
            file.write(userList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // reading
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("users.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray readUserList = (JSONArray) obj;
            System.out.println(readUserList);
             
            //Iterate over user array
            readUserList.forEach( emp -> parseUserObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	private static void parseUserObject(JSONObject user) 
    {
        JSONObject userObject = (JSONObject) user.get("user");
         
        String username = (String) userObject.get("username");    
        System.out.println(username);
         
        String password = (String) userObject.get("password");  
        System.out.println(password);
    }

}
