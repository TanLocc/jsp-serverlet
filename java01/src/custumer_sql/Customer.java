package custumer_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Customer {
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	int Id;
	String name;
	int age;
	String addr;
	float salary ;
	int cust_id;
	public Customer(int id, String name, int age, String addr, float salary,
			int cust_id) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.salary = salary;
		this.cust_id = cust_id;
	}
	public static Connection getMyConnection() throws ClassNotFoundException, SQLException{
		String hostName = "localhost"	;
		String dbName   = "demo1";
		String userName = "root";
		String password = "941997";
		return getMyConnection(hostName, dbName, userName, password) ;
		}

		public static Connection getMyConnection(String hostName, String dbName,
				String userName, String password) throws SQLException,
		        ClassNotFoundException {
			 Class.forName("com.mysql.jdbc.Driver");
			// TODO Auto-generated method stub
			 String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			 Connection conn = DriverManager.getConnection(connectionURL, userName,
			            password);
			
			    return conn;
		}
		
}
