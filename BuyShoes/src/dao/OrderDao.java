package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Order;
import beans.UserAccount;

public class OrderDao {
	

	public static List<Order> queryOrder(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ORDERS AS O" + 
				     " INNER JOIN USERACCOUNT AS U ON O.USER_ID = U.USER_ID" + 
				     " INNER JOIN PRODUCT AS P ON O.PRODUCT_ID = P.PRODUCT_ID ";

	    PreparedStatement pstm = conn.prepareStatement(sql);

	    ResultSet rs = pstm.executeQuery();
	    List<Order> list = new ArrayList<Order>();
	    while (rs.next()) {
	        
	        Order order = new Order();
	        order.setId(rs.getInt("id"));
	        order.setCus_id(rs.getInt("user_id"));
	        order.setPro_id(rs.getInt("product_id"));
	        order.setAmount(rs.getInt("amount"));
	        order.setState(rs.getInt("state"));
	        order.setUserName(rs.getString("username"));
	        order.setMail(rs.getString("mail"));
	        order.setPhone(rs.getString("phone"));
	        order.setAddress(rs.getString("address"));
	        order.setAVATAR(rs.getAsciiStream("avatar"));
	        order.setImage(rs.getAsciiStream("image"));
	        order.setName(rs.getString("name"));
	        order.setCate(rs.getString("category"));
	        order.setPrice(rs.getFloat("price"));
	        order.setDes(rs.getString("des"));
	        order.setDetail(rs.getString("detail"));
	        
	        //if(user.getRole()!=1)  
	        	list.add(order);
	    }
	    return list;
	}
	
	public static int findUser_ID(Connection conn,String userName) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT ID FROM USERACCOUNT WHERE USERNAME=?" ;

	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1,userName);
	    ResultSet rs = pstm.executeQuery();
	    int id = 0;
	    while (rs.next()) {
	        
	    id = rs.getInt("id");
	       
	    }
	    return id;
	}
	public static int save(Order o, Connection con){  
	    int status=0;  
	    try{  
	         
	        PreparedStatement ps=con.prepareStatement(  
	"insert into ORDERS(user_id,product_id,amount,state) values(?,?,?,?)");  
	        //ps.setInt(1, getMaxId(con)+1);
	        
	        ps.setInt(1, o.getCus_id());
	        ps.setInt(2, o.getPro_id());  
	        ps.setInt(3, o.getAmount());
	        ps.setInt(4, o.getState());
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}

	public static List<Order> queryOrderByUser_ID(Connection conn,int user_id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ORDERS AS O" + 
			     " INNER JOIN USERACCOUNT AS U ON O.USER_ID = U.USER_ID" + 
			     " INNER JOIN PRODUCT AS P ON O.PRODUCT_ID = P.PRODUCT_ID "+
			     " WHERE U.USER_ID=?";

   PreparedStatement pstm = conn.prepareStatement(sql);
   pstm.setInt(1, user_id);
   ResultSet rs = pstm.executeQuery();
   
   List<Order> list = new ArrayList<Order>();
   while (rs.next()) {
       
       Order order = new Order();
       order.setId(rs.getInt("id"));
       order.setCus_id(rs.getInt("user_id"));
       order.setPro_id(rs.getInt("product_id"));
       order.setAmount(rs.getInt("amount"));
       order.setState(rs.getInt("state"));
       order.setUserName(rs.getString("username"));
       order.setMail(rs.getString("mail"));
       order.setPhone(rs.getString("phone"));
       order.setAddress(rs.getString("address"));
       order.setAVATAR(rs.getAsciiStream("avatar"));
       order.setImage(rs.getAsciiStream("image"));
       order.setName(rs.getString("name"));
       order.setCate(rs.getString("category"));
       order.setPrice(rs.getFloat("price"));
       order.setDes(rs.getString("des"));
       order.setDetail(rs.getString("detail"));
       
       //if(user.getRole()!=1)  
       	list.add(order);
   }
   return list;
	} 
public static int updateState( Connection con, int id){  
	    int status=0;  
	    try{  
	         
	        PreparedStatement ps=con.prepareStatement(  "UPDATE orders SET state= not state WHERE id=?");  
	        //ps.setInt(1, getMaxId(con)+1);
	        
	        ps.setInt(1, id);
	       
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}

public static int updateAmount(Connection conn, int amount, int id, int state) {
	// TODO Auto-generated method stub
	 int status=0;  
	 String sql = "UPDATE product SET amount=amount-? WHERE product_id=?";
	 if(state==1) sql = "UPDATE product SET amount=amount+? WHERE product_id=?";
	    try{  
	    	  PreparedStatement ps=conn.prepareStatement(sql);  
	    	
	        //ps.setInt(1, getMaxId(con)+1);
	        
	        ps.setInt(1, amount);
	        ps.setInt(2, id);
	       
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
}

}
