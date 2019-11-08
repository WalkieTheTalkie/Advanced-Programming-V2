package application;

import java.util.Scanner;

public class EmployeeRegistrar {
	
	
	//min and max must be 10,000 and 49,999 respectively
	//outputs a random number to apply to employee
	public static int randomEmployeeId(int min, int max) {
		int x = (int) ((Math.random()*((max-min)+1))+min);
		return x;
	}
	
	public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	
	EmployeeClass thePeople = new EmployeeClass();
	
	
	
	
	
	}
}
