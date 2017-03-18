import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	
	
	FullTimeEmployee f1 = new FullTimeEmployee("AAAA",5000.0);
	FullTimeEmployee f2 = new FullTimeEmployee("YYYY",6000.0);
	public void test() {
		
		assertTrue(f1.getSalary() > f2.getSalary());
		
	}

}
