import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import junit.framework.TestCase;

public class PageTest extends TestCase {

	String display1;
	String display2;
	Page page;
	Page pageWithParam;
	
	protected void setUp() {
		display1 = "display1\ndisplay1";
		display2 = "display2";
		page = new Page();
		pageWithParam = new Page(display1);
	}
	
	@Test
	public void testDefaultPageNotNull() {
		assertNotNull(page);
	}
	
	@Test
	public void testGetDisplay() {
		assertEquals(pageWithParam.getDisplay(), display1);
	}
	
	@Test
	public void testSetDisplay() {
		pageWithParam.setDisplay(display2);
		assertEquals(page.getDisplay(), display2);
	}
}
