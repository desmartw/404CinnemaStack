import junit.framework.*;

import java.io.FileWriter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

public class UserDatabaseTest extends TestCase{
	protected UserDatabase db;
	String user;
	String invalidUser;
	JSONObject userDetails;
	JSONObject userObject;
	JSONObject invalidObject;

	// assigning the values
	protected void setUp(){
		db = new UserDatabase();
		user = "shayon";
		invalidUser = "null";
		
		userDetails = new JSONObject();
		userDetails.put("username", "test");
		userDetails.put("password", "Password123");
		userDetails.put("email", "test@gmail.com");
		userDetails.put("age", "25");
		userDetails.put("points", "0");
		userDetails.put("type", "employee");
		userDetails.put("ID", "12345");
		userDetails.put("discount", ".1");
		userDetails.put("location", "theater");
		userObject = new JSONObject();
		userObject.put("user", userDetails);
		invalidObject = new JSONObject();
	}   
	
	@Test
	public void testingUserDatabaseConstructor() {
		UserDatabase db2 = new UserDatabase();
		assertNotNull(db2);
	}
	
	@Test
	public void testingUserList() {
		assertEquals(db.getUserList(), new JSONArray());
	}
	
	@Test
	public void testingAdminPass() {
		assertEquals(db.getAdminPassword(), "admin123");
	}
	
	@Test
	public void testingEmployeePass() {
		assertEquals(db.getEmployeePassword(), "emp123");
	}
	
	@Test
	public void testingFindUserValid() {
		assertNotNull(db.findUser(user));
	}
	
	@Test
	public void testingFindUserInvalid() {
		assertNull(db.findUser(invalidUser));
	}
	
	@Test
	public void testingGetUserPasswordValid() {
		assertEquals(db.getUserPassword(user), "Password123");
	}
	
	@Test
	public void testingGetUserPasswordInvalid() {
		assertNull(db.getUserPassword(invalidUser));
	}
	
	@Test
	public void testingGetUserTypeValid() {
		assertEquals(db.getType(user), "employee");
	}
	
	@Test
	public void testingGetUserTypeInvalid() {
		assertNull(db.getType(invalidUser));
	}
	
	@Test
	public void testingParseUsernameValid() {
		assertEquals(db.parseUsername((JSONObject) userObject), "test");		
	}
	
	@Test
	public void testingParseUsernameInvalid() {
		assertNull(db.parseUsername((JSONObject) invalidObject));		
	}
	
	@Test
	public void testingParsePasswordValid() {
		assertEquals(db.parsePassword((JSONObject) userObject), "Password123");		
	}
	
	@Test
	public void testingParsePasswordInvalid() {
		assertNull(db.parsePassword((JSONObject) invalidObject));		
	}
	
	@Test
	public void testingParseEmailValid() {
		assertEquals(db.parseEmail((JSONObject) userObject), "test@gmail.com");		
	}
	
	@Test
	public void testingParseEmailInvalid() {
		assertNull(db.parseEmail((JSONObject) invalidObject));		
	}
	
	@Test
	public void testingParseAgeValid() {
		assertEquals(db.parseAge((JSONObject) userObject), "25");		
	}
	
	@Test
	public void testingParseAgeInvalid() {
		assertNull(db.parseAge((JSONObject) invalidObject));		
	}
	
	@Test
	public void testingParsePointsValid() {
		assertEquals(db.parsePoints((JSONObject) userObject), "0");		
	}
	
	@Test
	public void testingParsePointsInvalid() {
		assertNull(db.parsePoints((JSONObject) invalidObject));		
	}
	
	@Test
	public void testingParseIDValid() {
		assertEquals(db.parseID((JSONObject) userObject), "12345");		
	}
	
	@Test
	public void testingParseIDInvalid() {
		assertNull(db.parseID((JSONObject) invalidObject));		
	}
	
	@Test
	public void testingParseDiscountValid() {
		assertEquals(db.parseDiscount((JSONObject) userObject), ".1");		
	}
	
	@Test
	public void testingParseDiscountInvalid() {
		assertNull(db.parseDiscount((JSONObject) invalidObject));
	}
	
	@Test
	public void testingParseTypeValid() {
		assertEquals(db.parseType((JSONObject) userObject), "employee");
	}
	
	@Test
	public void testingParseTypeInvalid() {
		assertNull(db.parseType((JSONObject) invalidObject));
	}
	
	@Test
	public void testingParseLocationValid() {
		assertEquals(db.parseLocation((JSONObject) userObject), "theater");
	}
	
	@Test
	public void testingParseLocationInvalid() {
		assertNull(db.parseLocation((JSONObject) invalidObject));
	}
	
	@Test
	public void testingValidateDiscountEmployeeValid() {
		assertEquals(db.validateDiscount("employee"), ".1");
	}
	
	@Test
	public void testingValidateDiscountStudentValid() {
		assertEquals(db.validateDiscount("student"), ".1");
	}
	
	@Test
	public void testingValidateDiscountVeteranValid() {
		assertEquals(db.validateDiscount("veteran"), ".1");
	}
	
	@Test
	public void testingValidateDiscountTeacherValid() {
		assertEquals(db.validateDiscount("teacher"), ".1");
	}
	
	@Test
	public void testingValidateDiscountHandicappedValid() {
		assertEquals(db.validateDiscount("handicapped"), ".1");
	}
	
	@Test
	public void testingValidateDiscountStandardValid() {
		assertEquals(db.validateDiscount("standard"), "0");
	}
	
	@Test
	public void testingValidateDiscountInvalid() {
		assertEquals(db.validateDiscount(null), "0");
	}
	
	@Test
	public void testingGetAllUsernames() {
		assertNotNull(db.getAllUsernames());
	}
	
	@Test
	public void testingGetAllPasswords() {
		assertNotNull(db.getAllPasswords());
	}
	
	@Test
	public void testingGetAllEmails() {
		assertNotNull(db.getAllEmails());
	}
	
	@Test
	public void testingReadUserList() {
		assertNotNull(db.readUserList());
	}
}
