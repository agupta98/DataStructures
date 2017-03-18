import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class App {
	
	public static void main(String[] args){
		
		Part1 p1 = new Part1();
		p1.equality();
		Part11 p2 = new Part11();
		p2.Equality1();
		Result result = JUnitCore.runClasses(AppTest.class);
		System.out.println(result.wasSuccessful());
		
	}

}
