package custumer_sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerDAOImpl implements ICustumer {

	public void AddCustomer(Customer customer,Statement statement ) throws ClassNotFoundException, SQLException {
		
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap id: ");
		customer.Id = scan.nextInt();
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Nhap ten: ");
		customer.name = scan1.nextLine();
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Nhap tuoi: ");
		customer.age = scan3.nextInt();
		Scanner scan4 = new Scanner(System.in);
		System.out.println("Nhap dia chi: ");
		customer.addr = scan4.nextLine();
		Scanner scan5 = new Scanner(System.in);
		System.out.println("Nhap luong: ");
		customer.salary = scan5.nextFloat();
		Scanner scan6 = new Scanner(System.in);
		System.out.println("Nhap cus_id: ");
		customer.cust_id = scan6.nextInt();
		String sql = "Insert into CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY,CUST_ID) values ("
				   +customer.Id+",'"+customer.name+"',"+customer.age+",'"+customer.addr+"',"+customer.salary+","+customer.cust_id+")";
		int rowCount = statement.executeUpdate(sql);
	}

	public List<Customer> GetCustomers(Statement statement) throws SQLException {
		List<Customer> customers = new ArrayList<Customer>();
		String sql = "Select ID,NAME,AGE,ADDRESS,SALARY,CUST_ID from customers";

		// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
		ResultSet rs = statement.executeQuery(sql);

		System.out.println("--------SELECT------------");
		// Duyệt trên kết quả trả về.
		while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
			int id = rs.getInt(1);
			String name = rs.getString("NAME");
			int age = rs.getInt(3);
			String addr = rs.getString(4);
			float salary = rs.getFloat(5);
			int cust_id = rs.getInt(6);
			Customer customer = new Customer(id, name, age, addr, salary, cust_id);
			customers.add(customer);
		}
		return customers;
		
		// TODO Auto-generated method stub
		
	}
	public void UpdateCustomerByName(String name,Statement statement) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap id: ");
		int Id = scan.nextInt();
		String sql="UPDATE CUSTOMERS "+
		"SET NAME = '"+name+"' "+
		"WHERE ID ="+Id+"";
		System.out.println(sql);
		if(this.SearchCustomerByName(name, statement)){
		int rowCount = statement.executeUpdate(sql);}
		else System.out.println("Doi tuong da ton tai");
	}

	public void DeleteCustomerByName(String name,Statement statement) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		String sql="DELETE FROM CUSTOMERS "+
				"WHERE NAME ='"+name+"'";
		
		int rowCount = statement.executeUpdate(sql);
		
	}
	public boolean SearchCustomerByName(String name, Statement statement)
			throws ClassNotFoundException, SQLException {
		String sql = "Select * from CUSTOMERS ";
		ResultSet rs = statement.executeQuery(sql);
	
		while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
		    String NAME = rs.getString(2);	
		    if(NAME.equals(name)) return false ;
		  
		    
		}
				return true;
		// TODO Auto-generated method stub
		
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException{  
		CustomerDAOImpl obj = new CustomerDAOImpl();  
		Connection connection = Customer.getMyConnection();
		Statement statement = connection.createStatement();
		Customer customer = new Customer(0, "AN2", 0, null, 0, 0);
		//obj.AddCustomer(customer, statement);
        //obj.DeleteCustomerByName(customer.name, statement);
		obj.UpdateCustomerByName(customer.name, statement);
		List<Customer> customers = obj.GetCustomers(statement);
		for (Customer customerElement : customers) {
			System.out.println(customerElement.getId() + " " + customerElement.getName() + " " + customerElement.getAge() + " " + customerElement.getSalary());
			
		}
    }

	

	
	}

	


