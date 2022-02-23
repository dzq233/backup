package model;

public class User {
	private int id;
	private String userName;
	private String passWord;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUseName() {
		return userName;
	}
	public User(String useName, String passWord) {
		this.userName = useName;
		this.passWord = passWord;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public void setUseName(String useName) {
		this.userName = useName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
