package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class BinarySearchSortByID {
	
	//test run of binary search and id sort
	//public static void main(String[] args) {
	//	EmployeeClass emp = BinarySearchByID(2); // check if there
	//	EmployeeClass emp2 = BinarySearchByID(3);
	//	
	//	System.out.print(emp.toString());
	//	System.out.print(emp2.toString());
	//	
	//	if (emp2.getEmployeeUser() == null) {
	//		System.out.print("\nEmployee does not exist");
	//	}
	//	
	//	LinkedList<Volunteer> volun = VolunteersSortByID();
	//	
	//	for (Volunteer i : volun) {
	//		System.out.print(i.toString());
	//	}
	//}

	public static EmployeeClass BinarySearchByID(int id){
		HashMap<Integer, EmployeeClass> employees = new EmployeeTable().getEmployees();
		try {
			int low = 1;
			int high = employees.size();
			int middle = (low + high - 1) / 2;
			
			do {
				if (id == employees.get(middle).getEmployeeID()) {
					return employees.get(middle);
				} else if (id < employees.get(middle).getEmployeeID()) {
					high = middle - 1;
				} else {
					low = middle + 1;
				}
				middle = (low + high - 1) / 2;
			} while (low <= high);
			return new EmployeeClass();
		} catch (NullPointerException ex) { // don't do anything if middle number 
			//is a id value that is not contained within the HashMap
		}
		return new EmployeeClass();
	}
	
	// id is sorted by default by database
	// example of linkedlist with smallest id # being first in list
	public static LinkedList<Admin> AdminSortByID(){
		HashMap<Integer, Admin> admin = new AdminTable().getAdmin();
		ArrayList<Admin> temp = new ArrayList<>();
		LinkedList<Admin> adminSorted = new LinkedList<>();
		
		for (Integer i : admin.keySet()) {
			temp.add(admin.get(i));
		}
		
		Iterator<Admin> itera = temp.iterator();
		
		while(itera.hasNext()) {
			adminSorted.add(itera.next());
		}
		return adminSorted;
	}
	
	public static LinkedList<EmployeeClass> EmployeeSortByID(){
		HashMap<Integer, EmployeeClass> emps = new EmployeeTable().getEmployees();
		ArrayList<EmployeeClass> temp = new ArrayList<>();
		LinkedList<EmployeeClass> empSorted = new LinkedList<>();
		
		for (Integer i : emps.keySet()) {
			temp.add(emps.get(i));
		}
		
		Iterator<EmployeeClass> itera = temp.iterator();
		
		while(itera.hasNext()) {
			empSorted.add(itera.next());
		}
		return empSorted;
	}
	
	public static LinkedList<Volunteer> VolunteersSortByID(){
		HashMap<Integer, Volunteer> v = new VolunteerTable().getVolunteers();
		ArrayList<Volunteer> temp = new ArrayList<>();
		LinkedList<Volunteer> vSorted = new LinkedList<>();
		
		for (Integer i : v.keySet()) {
			temp.add(v.get(i));
		}
		
		Iterator<Volunteer> itera = temp.iterator();
		
		while(itera.hasNext()) {
			vSorted.add(itera.next());
		}
		return vSorted;
	}

}
