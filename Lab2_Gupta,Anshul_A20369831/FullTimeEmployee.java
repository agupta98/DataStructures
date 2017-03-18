import java.text.DecimalFormat;

public class FullTimeEmployee {
	
	String pattern = "$0.00";
	DecimalFormat MONEY = new DecimalFormat(pattern);
	
	private String name;
	private double salary;
	
	public FullTimeEmployee(String name,double salary){
		
		this.name = name;
		this.salary = salary;
		
	}

	public String getName() {
		return name;
	}

	

	public double getSalary() {
		return salary;
	}

	public boolean equals (Object obj) { 
		if (!(obj instanceof FullTimeEmployee)) 
			return false; 
		FullTimeEmployee full = (FullTimeEmployee)obj; 
		return name.equals (full.name) && MONEY.format (salary).equals (MONEY.format (full.salary)); 
		} // method equals 
	//Comparable Interface method
	public int compareTo(FullTimeEmployee f11) {
		// TODO Auto-generated method stub
		double compareSalary = ((FullTimeEmployee)f11).getSalary();
		return (int) (this.salary - compareSalary);
		
		
	}
	
	
	
	

}
