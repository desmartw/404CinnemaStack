import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import junit.framework.TestCase;

public class UsersTest extends TestCase {
	
	// User itself cannot be instantiated
	AdminUser admin;
	String adminID;
	
	EmployeeUser employee;
	String employeeID;
	Location location;
	
	TeacherUser teacher;
	String teacherID;
	
	StudentUser student;
	String studentID;
	
	VeteranUser veteran;
	String militaryID;
	
	HandicappedUser hUser;
	String handicappedTagNum;
	
	StandardUser standard;
	String ID;
	
	GuestUser guest;
	
	String username;
	String password;
	String email;
	String[] wallet;
	ArrayList<Ticket> tickets;
	ArrayList<Ticket> cart;
	Ticket ticket1;
	Ticket ticket2;
	int age;
	int rewardPoints;
	double discountRate1;
	double discountRate2;
	
	
	protected void setUp() {
		username = "testuser";
		password = "testpassword";
		email = "test@gmail.com";
		wallet = new String[] {"1111222233334444", "0000111100001111", "2222333322225555"};
		tickets = new ArrayList<Ticket>();
		cart =  new ArrayList<Ticket>();
		ticket1 = new Ticket("Event1", 10, "1200","09012020", 30);
		ticket2 = new Ticket("Event2", 20, "1800", "10012020", 40);
		age = 18;
		rewardPoints = 0;
		discountRate1 = .1;
		discountRate2 = 0;
		adminID = "admin123";
		employeeID = "empl123";
		location = new Location();
		teacherID = "teacher123";
		studentID = "student123";
		militaryID = "military123";
		handicappedTagNum = "TagNum123";
		ID = "standard123";
		admin = new AdminUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate1,adminID);
		employee = new EmployeeUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate1, employeeID, location);
		teacher = new TeacherUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate1, teacherID);
		student = new StudentUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate1, studentID);
		veteran = new VeteranUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate1, militaryID);
		hUser = new HandicappedUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate1, handicappedTagNum);
		standard = new StandardUser(username, password, email, wallet, tickets, cart, age, rewardPoints, discountRate1, ID);
		guest = new GuestUser(age, wallet, tickets);
	}
	
	@Test
	public void testAdminNotNull() {
		assertNotNull(admin);
	}
	@Test
	public void testEmployeeNotNull() {
		assertNotNull(employee);
	}
	@Test
	public void testTeacherNotNull() {
		assertNotNull(teacher);
	}
	@Test
	public void testStudentNotNull() {
		assertNotNull(student);
	}
	@Test
	public void testVeteranNotNull() {
		assertNotNull(veteran);
	}
	@Test
	public void testHandicapNotNull() {
		assertNotNull(hUser);
	}
	@Test
	public void testStandardNotNull() {
		assertNotNull(standard);
	}
	@Test
	public void testGuestNotNull() {
		assertNotNull(guest);
	}
	@Test
	public void testGetUsername() {
		assertEquals(admin.getUsername(), username);
	}
	@Test
	public void testGetPassword() {
		assertEquals(admin.getPassword(), password);
	}
	@Test
	public void testGetEmail() {
		assertEquals(admin.getEmail(), email);
	}
	@Test
	public void testGetWallet() {
		assertEquals(admin.getWallet(), wallet);
	}
	@Test
	public void testGetTickets() {
		assertEquals(admin.getTickets(), tickets);
	}
	@Test
	public void testGetCart() {
		assertEquals(admin.getCart(), cart);
	}
	@Test
	public void testGetAge() {
		assertEquals(admin.getAge(), age);
	}
	@Test
	public void testGetRewardPoints() {
		assertEquals(admin.getRewardPoints(), rewardPoints);
	}
	@Test
	public void testGetAdminID() {
		assertEquals(admin.getAdminID(), adminID);
	}
	@Test
	public void testGetEmployeeID() {
		assertEquals(employee.getEmployeeID(), employeeID);
	}
	@Test
	public void testGetEmployeeLocation() {
		assertEquals(employee.getLocation(), location);
	}
	@Test
	public void testGetTeacherID() {
		assertEquals(teacher.getTeacherID(), teacherID);
	}
	@Test
	public void testGetStudentID() {
		assertEquals(student.getStudentID(), studentID);
	}
	@Test
	public void testGetMilitaryID() {
		assertEquals(veteran.getMilitaryID(), militaryID);
	}
	@Test
	public void testGetHandicappedTagNum() {
		assertEquals(hUser.getHandicappedTagNum(), handicappedTagNum);
	}
	@Test
	public void testGetStandardID() {
		assertEquals(standard.getID(), ID);
	}
	@Test
	public void testSetUsername() {
		admin.setUsername("test");
		assertEquals(admin.getUsername(), "test");
	}
	@Test
	public void testSetPassword() {
		admin.setPassword("test");
		assertEquals(admin.getPassword(), "test");
	}
	@Test
	public void testSetEmail() {
		admin.setUsername("test");
		assertEquals(admin.getEmail(), "test");
	}
	@Test
	public void testSetWallet() {
		admin.setWallet(new String[] {"1111000011110000"});
		assertEquals(admin.getWallet(), new String[] {"1111000011110000"});
	}
	@Test
	public void testSetCart() {
		cart.add(ticket1);
		assertEquals(admin.getCart(), cart);
	}
	@Test
	public void testSetTickets() {
		tickets.add(ticket1);
		
		assertEquals(admin.getTickets(), tickets);
	}
	@Test
	public void testSetAge() {
		admin.setAge(5);
		assertEquals(admin.getAge(), 5);
	}
	@Test
	public void testSetRewardPoints() {
		admin.setRewardPoints(10);
		assertEquals(admin.getRewardPoints(), 10);
	}
	@Test
	public void testSetDiscountRate() {
		admin.setDiscountRate(.5);
		assertEquals(admin.getDiscountRate(), .5);
	}
	@Test
	public void testSetAdminID() {
		admin.setAdminID("testing");
		assertEquals(admin.getAdminID(), "testing");
	}
	@Test
	public void testSetEmployeeID() {
		employee.setEmployeeID("testing");
		assertEquals(employee.getEmployeeID(), "testing");
	}
	@Test
	public void testSetEmployeeLocation() {
		employee.getLocation().setName("testing");
		location.setName("testing");
		assertEquals(employee.getLocation(), location);
	}
	@Test
	public void testSetTeacherID() {
		teacher.setTeacherID("testing");
		assertEquals(teacher.getTeacherID(), "testing");
	}
	@Test
	public void testSetStudentID() {
		student.setStudentID("testing");
		assertEquals(student.getStudentID(), "testing");
	}
	@Test
	public void testSetMilitaryID() {
		veteran.setMilitaryID("testing");
		assertEquals(veteran.getMilitaryID(), "testing");
	}
	@Test
	public void testSetHandicappedTagNum() {
		hUser.setHandicappedTagNum("testing");
		assertEquals(hUser.getHandicappedTagNum(), "testing");
	}
}
