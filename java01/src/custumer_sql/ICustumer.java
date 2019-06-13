package custumer_sql;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface   ICustumer {
	
	
void	AddCustomer(Customer customer,Statement statement ) throws ClassNotFoundException, SQLException;
 List<Customer> GetCustomers(Statement statement) throws SQLException;
void UpdateCustomerByName(String name,Statement statement) throws ClassNotFoundException, SQLException;
void DeleteCustomerByName(String name,Statement statement) throws ClassNotFoundException, SQLException;
public boolean  SearchCustomerByName(String name,Statement statement) throws ClassNotFoundException, SQLException;
}
