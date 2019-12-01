package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/**
 * class searching by last name of employee or
 * volunteer
 *
 */
public class SearchByLastName {
	
	// test run
	/*public static void main(String[] args) {
		ArrayList<EmployeeClass> emps = EmpSearchByLastName("Jaynes");
		ArrayList<Admin> ad = AdminSearchByLastName("Jaynes");
		ArrayList<Volunteer> v = VolunSearchByLastName("Jaynes");
		
		System.out.print("\n\nAdmin: ");
		if (ad.isEmpty()) {
			System.out.print("\nNo one by that name");
		} else {
			Iterator<Admin> itera = ad.iterator();
			while (itera.hasNext()) {
				System.out.print("\n" + itera.next());
			}
		}
		System.out.print("\n\nEmployees: ");
		if (emps.isEmpty()) {
			System.out.print("\nNo one by that name");
		} else {
			Iterator<EmployeeClass> itera = emps.iterator();
			while (itera.hasNext()) {
				System.out.print("\n" + itera.next());
			}
		}
		System.out.print("\n\nVolunteers: ");
		if (v.isEmpty()) {
			System.out.print("\nNo one by that name");
		} else {
			Iterator<Volunteer> itera = v.iterator();
			while (itera.hasNext()) {
				System.out.print("\n" + itera.next());
			}
		}
	}*/
	
	public static ArrayList<EmployeeClass> EmpSearchByLastName(String name){
		HashMap<Integer, EmployeeClass> emps = new EmployeeTable().getEmployees();
		ArrayList<EmployeeClass> match = new ArrayList<>();
		
		for (Integer i : emps.keySet()) {
			if (emps.get(i).getLastName().equals(name)) {
				// if employee last name matches, add to list of matches
				match.add(emps.get(i));
			}
		}
		return match;
	}
	
	public static ArrayList<Volunteer> VolunSearchByLastName(String name){
		HashMap<Integer, Volunteer> v = new VolunteerTable().getVolunteers();
		ArrayList<Volunteer> match = new ArrayList<>();
		
		for (Integer i : v.keySet()) {
			if (v.get(i).getLastName().equals(name)) {
				match.add(v.get(i));
			}
		}
		return match;
	}
	
	public static ArrayList<Admin> AdminSearchByLastName(String name){
		HashMap<Integer, Admin> ad = new AdminTable().getAdmin();
		ArrayList<Admin> match = new ArrayList<>();
		
		for (Integer i : ad.keySet()) {
			if (ad.get(i).getLastName().equals(name)) {
				match.add(ad.get(i));
			}
		}
		return match;
	}
}
