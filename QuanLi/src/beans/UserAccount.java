package beans;

import java.io.InputStream;

public class UserAccount {
	 
	  
	 private int id; 
	   private String userName;
	   private String mail;
	   private String password;
	   private int role;
	   private InputStream avatar;
	    
	 
	   public UserAccount() {
	        
	   }
	    
	

	public UserAccount(int id, String userName, InputStream avatar, String mail, String password, int role) {
		super();
		this.id = id;
		this.userName = userName;
		this.avatar = avatar;
		this.mail = mail;
		this.password = password;
		this.role = role;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getRole() {
		return role;
	}



	public void setRole(int role) {
		this.role = role;
	}



	public InputStream getAvatar() {
		return avatar;
	}



	public void setAvatar(InputStream avatar) {
		this.avatar = avatar;
	}

    

	
	 
	}
