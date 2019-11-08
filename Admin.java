package application;

public class Admin extends Person{
	private String username;
	private String password;
	private int id;
	
	Admin(){
		
	}
	
	Admin(String user, String pass){
		this.username = user;
		this.password = pass;
	}
	
	Admin(String user, String pass, String fname, String middle, String lname, String email, String phone, String gender,
			String address, String birth, String contact){
		super(fname, middle, lname, email, phone, gender, address, birth, contact);
		this.username = user;
		this.password = pass;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() { // Admin password should be secure
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
}
