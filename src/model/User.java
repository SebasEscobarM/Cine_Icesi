package model;

public class User {
	//attributes
	private String nameUsers;
	private String idUsers;

	//relations
	
	//methods
	public User(String nameUsers, String idUsers) {
		this.nameUsers = nameUsers;
		this.idUsers = idUsers;
	}
	
	public String getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(String idUsers) {
		this.idUsers = idUsers;
	}

	public String getNameUsers() {
		return nameUsers;
	}

	public void setNameUsers(String nameUsers) {
		this.nameUsers = nameUsers;
	}
}
