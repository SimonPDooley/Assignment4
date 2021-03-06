//POGO!!!
public class User implements Comparable<User> {
	private String username;
	private String password;
	private String name;
	private String role;
	
	public User(){
	
	}
	
	public User(String username, String password, String name, String role) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.role = role;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public int compareTo(User that) {
		if (that.role.compareTo(this.role) == 0) {
			return this.name.compareToIgnoreCase(that.name);
		}else {
		return that.role.compareTo(this.role);
		}
	}
}
