import static org.junit.Assert.*;
import org.junit.runner.Result;

import static org.junit.runner.JUnitCore.runClasses;
import org.junit.*;

public class WrapperPowerTest {
	
	public static void main(String[] args){
		
		Result result = runClasses(WrapperPowerTest.class);
		
		System.out.println ("Tests run = " + 
                result.getRunCount() + "\nTests failed = " + result.getFailures());
		
		
	}

	

	@Test
	public void test() {
		assertEquals(1,WrapperPower.power(-5,0));
	}
	
	public void test1() {
		assertEquals("throw IllegalArgumentException",WrapperPower.power(5,-2));
	}
	
	public void test2() {
		assertEquals(25,WrapperPower.power(5,2));
	}
	
	public void test3() {
		assertEquals(32,WrapperPower.power(2,5));
	}
	
	public void test4() {
		assertEquals(-32,WrapperPower.power(-2,4));
	}
	
	public void test5() {
		assertEquals(1000000000L,WrapperPower.power(10,11));
	}
	
	
	







	

}
