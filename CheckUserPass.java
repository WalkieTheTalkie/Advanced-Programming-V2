package application;

import java.util.HashMap;
/**
 * Checks password of a User based on job
 * @returns 0 or 1 
 * @returns fail if check is 0
 * @returns passes if check is 1
 */
public class CheckUserPass {
/**
 * Checks Admin
 * @param user Username
 * @param pass Password
 * @return pass or fail
 */
	public int CheckUserPassAdmin(String user, String pass) {
		HashMap<Integer, Admin> admin = new AdminTable().getAdmin();
		for (int i = 1; i <= admin.size(); i++) {
			if (user.equals(admin.get(i).getUsername())) {
				if (pass.equals(admin.get(i).getPassword())) {
					return 1; // username and password match/valid
				}
			}
		}
		return 0; // username/password do not match
	}
	/**
	 * checks Employees
	 * @param user Employee User
	 * @param pass Employee Password
	 * @return pass or fail
	 */
	public int CheckUserPassEmployee(String user, String pass) {
		HashMap<Integer, EmployeeClass> emps = new EmployeeTable().getEmployees();
		for (int i = 1; i <= emps.size(); i++) {
			if (user.equals(emps.get(i).getEmployeeUser())) {
				if (pass.equals(emps.get(i).getEmployeePass())) {
					return 1;
				}
			}
		}
		return 0;
	}
	/**
	 * Checks Volunteer
	 * @param user Volunteer Username
	 * @param pass Volunteer Password
	 * @return pass or fail
	 */
	public int CheckUserPassVolunteer(String user, String pass) {
		HashMap<Integer, Volunteer> volun = new VolunteerTable().getVolunteers();
		for (int i = 1; i <= volun.size(); i++) {
			if (user.equals(volun.get(i).getUserName())) {
				if (pass.equals(volun.get(i).getPassword())) {
					return 1;
				}
			}
		}
		return 0;
	}
}
