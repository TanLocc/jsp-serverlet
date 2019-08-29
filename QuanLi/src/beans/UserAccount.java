package beans;

import java.io.InputStream;

public class UserAccount {
	 
	  
	 private int id; 
	   private String userName;
	   private String mail;
	   private String phone;
	   private String address;
	   private String password;
	   private int role;
	   private InputStream avatar;
	    
	 
	   public UserAccount() {
	        
	   }
	    
	

	public UserAccount(int id, String userName, InputStream avatar, String mail, String phone, String address, String password, int role) {
		super();
		this.id = id;
		this.userName = userName;
		this.avatar = avatar;
		this.mail = mail;
		this.address = address;
		this.password = password;
		this.role = role;
		this.phone = phone;
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



	public String getPhone() {
		return phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void setPhone(String phone) {
		this.phone = phone;
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
