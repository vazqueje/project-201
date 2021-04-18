import java.sql.Date;

public class User {
	private String username;
	private String password;
	private String email;
	private Date dob;
	private int privileges;

	public User(String username, String password, String email, Date dob, int privileges) {
		this.username = username;
		this.password =password;
		this.email =email;
		this.dob= dob;
		this.privileges = privileges;

	}

	public int getPrivileges() {
		return privileges;
	}

	public void setPrivileges(int privileges) {
		this.privileges = privileges;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public int getAge() {
		return (java.time.LocalDate.now().getYear() - this.getDob().getYear());
	}
	
}
