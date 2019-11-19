package application;

import java.util.HashMap;

public class CheckUserPass {

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
