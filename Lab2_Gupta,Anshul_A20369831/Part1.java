
import java.util.Comparator;
public class Part1 implements Comparator<FullTimeEmployee> {
	
	public void equality(){
		boolean flag1;
		boolean flag2;
		boolean flag3;
		
		FullTimeEmployee f1 = new FullTimeEmployee("AAAA",7000.0);
		FullTimeEmployee f2 = new FullTimeEmployee("AAAA",6000.0);
		FullTimeEmployee f3 = new FullTimeEmployee("AAAA",5000.0);
		FullTimeEmployee f4 = new FullTimeEmployee("AAAA",5000.0);
		FullTimeEmployee f5 = null;
		/*
		 * Reflexivity
		 */
		System.out.println("Reflexivity");
		flag1 = f1.equals(f1);
		System.out.println(flag1);
		
		/*
		 * Symmetry
		 */
		System.out.println("Symmetry");
		flag1 = f1.equals(f2);
		flag2 = f2.equals(f1);
		System.out.println(flag1);
		System.out.println(flag2);
		
		
		
		/*
		 * Transitivity
		 */
		
		System.out.println("Transitivity");
		flag1 = f1.equals(f3);
		flag2 = f3.equals(f4);
		flag3 = f4.equals(f1);
		System.out.println(flag1);
		System.out.println(flag2);
		System.out.println(flag3);
		
		/*
		 * Consistency
		 */
		System.out.println("Consistency");
		flag1 = f1.equals(f2);
		System.out.println(flag1);
		
		/*
		 * Actuality
		 */
		System.out.println("Actuality");
		flag1 = f1.equals(f5);
		System.out.println(flag1);
		
		
		
		
		System.out.println(compare(f1, f2));
	}

	@Override
	public int compare(FullTimeEmployee f1, FullTimeEmployee f2) {
		
		
		// TODO Auto-generated method stub
		int res;
		if (f1.getName() == f2.getName() && f1.getSalary() == f1.getSalary()){
			res =0;
		}
		else if(f1.getSalary() > f2.getSalary()){
			res =1;
		}
		else
			res = -1;
		return res;
	}

}
