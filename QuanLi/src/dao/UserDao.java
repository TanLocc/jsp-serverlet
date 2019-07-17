package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.UserAccount;
import conn.ConnectionUtils;

public class UserDao {  
	  
	
public static int save(UserAccount u, Connection con){  
    int status=0;  
    try{  
         
        PreparedStatement ps=con.prepareStatement(  
"insert into USERACCOUNT(id,username,password,mail,role) values(?,?,?,?,?)");  
        ps.setFloat(1, getMaxId(con)+1);
        ps.setString(2,u.getUserName());  
        ps.setString(3,u.getPassword());  
        ps.setString(4,u.getMail());  
        ps.setInt(5,0); 
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int updateUser(Connection con,UserAccount u){  
    int status=0;  
    try{  
          
        PreparedStatement ps=con.prepareStatement(  
"update USERACCOUNT set  username=?,mail=?,password=?,role=? where id=?");  
        
        ps.setString(1,u.getUserName());  
        ps.setString(3,u.getPassword()); 
       
        ps.setString(2,u.getMail());  
        ps.setInt(4,0);  
        ps.setFloat(5,u.getId());  
       
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int delete(UserAccount u){  
    int status=0;  
    try{  
        Connection con=ConnectionUtils.getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from USERACCOUNT where password=?");  
        ps.setString(1,u.getPassword());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
  
public static UserAccount getRecordById(int id){  
	UserAccount u=null;  
    try{  
        Connection con=ConnectionUtils.getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from USERACCOUNT where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new UserAccount();  
           
            u.setUserName(rs.getString("name"));  
            u.setPassword(rs.getString("password"));  
            u.setMail(rs.getString("email"));  
            ps.setInt(4,0);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
} 
public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
	 String sql;
	if(userName.contains("gmail")) {
   	 sql = "Select a.Id, a.UserName, a.Password, a.Mail, a.Role from USERACCOUNT a " //
               + " where a.MAIL = ? and a.password= ?";	        	
   	 }
	
   else {
   	 sql = "Select a.Id, a.UserName, a.Password, a.Mail, a.Role from USERACCOUNT a " //
               + " where a.UserName = ? and a.password= ?";
   	 
   } 

	PreparedStatement pstm = conn.prepareStatement(sql);
    
    if(userName.equals("gmail")) pstm.setString(3, userName);        
    else pstm.setString(1, userName);
    pstm.setString(2, password);
    ResultSet rs = pstm.executeQuery();

    if (rs.next()) {
        
        UserAccount user = new UserAccount();
        user.setId(rs.getFloat("id"));
        user.setRole(rs.getInt("role"));
        user.setUserName(rs.getString("UserName"));;
        user.setPassword(password);
        user.setMail(rs.getString("mail")); 
        return user;
    }
    return null;
}
public static UserAccount findUser(Connection conn, String password) throws SQLException {
	 String sql = "Select * from USERACCOUNT a " //
              + " where a.password= ?";
  	 
	PreparedStatement pstm = conn.prepareStatement(sql);
   
        
  pstm.setString(1,password);

   ResultSet rs = pstm.executeQuery();

   if (rs.next()) {
       
       UserAccount user = new UserAccount();
       user.setId(rs.getFloat("id"));
       user.setRole(rs.getInt("role"));
       user.setUserName(rs.getString("UserName"));;
       user.setPassword(rs.getString("password"));
       user.setMail(rs.getString("mail")); 
       return user;
   }
   return null;
}
public static List<UserAccount> queryUser(Connection conn) throws SQLException {
    String sql = "Select a.id, a.UserName, a.Password, a.Mail, a.Role from USERACCOUNT a  ";

    PreparedStatement pstm = conn.prepareStatement(sql);

    ResultSet rs = pstm.executeQuery();
    List<UserAccount> list = new ArrayList<UserAccount>();
    while (rs.next()) {
        
        UserAccount user = new UserAccount();
        user.setId(rs.getFloat("id"));
        user.setRole(rs.getInt("role"));
        user.setUserName(rs.getString("UserName"));;
        user.setPassword(rs.getString("password"));
        user.setMail(rs.getString("mail")); 
        //if(user.getRole()!=1)  
        	list.add(user);
    }
    return list;
}
private static Float getMaxId(Connection conn) throws SQLException {
    String sql = "Select max(a.id) from USERACCOUNT a";
    PreparedStatement pstm = conn.prepareStatement(sql);
    ResultSet rs = pstm.executeQuery();
    if (rs.next()) {
        float max = rs.getFloat(1);
        return max;
    }
    return null;
}
}  
