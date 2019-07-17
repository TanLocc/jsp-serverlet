package beans;

public class UserAccount {
	 
	  
	 private float id; 
	   private String userName;
	   private String mail;
	   private String password;
	   private int role;
	    
	 
	   public UserAccount() {
	        
	   }
	    
	

	public UserAccount(float id, String userName, String mail, String password, int role) {
		super();
		this.id = id;
		this.userName = userName;
		this.mail = mail;
		this.password = password;
		this.role = role;
	}



	public float getId() {
		return id;
	}



	public void setId(float id) {
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



	
	 
	}
