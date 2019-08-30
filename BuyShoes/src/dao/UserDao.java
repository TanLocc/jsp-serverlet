package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.InputStream;


import beans.UserAccount;
import conn.ConnectionUtils;

public class UserDao {  
	  
	
public static int save(UserAccount u, Connection con){  
    int status=0;  
    try{  
         
        PreparedStatement ps=con.prepareStatement(  
"insert into USERACCOUNT(username,avatar,password,mail,phone,address,role) values(?,?,?,?,?,?,?)");  
        //ps.setInt(1, getMaxId(con)+1);
        ps.setString(1,u.getUserName());
        ps.setBlob(2,u.getAvatar());
        ps.setString(3,u.getPassword());  
        ps.setString(4,u.getMail()); 
        ps.setString(5,u.getPhone());
        ps.setString(6,u.getPhone());
        ps.setInt(7,0); 
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int updateUser(Connection con,UserAccount u){  
    int status=0;  
    try{  
    	PreparedStatement ps=con.prepareStatement( "update USERACCOUNT set  username=?,mail=?,password=?,address=?,avatar=? where USER_ID=?");  
    	if(u.getAvatar()==null) {
        ps=con.prepareStatement( "update USERACCOUNT set  username=?,mail=?,password=?, address=? where USER_ID=?");  
    	}
    	System.out.println("avatar1 = "+u.getAvatar());
        ps.setString(1,u.getUserName());    
        ps.setString(2,u.getMail());  
        ps.setString(3,u.getPassword()); 
        ps.setString(4,u.getAddress());  
        if(u.getAvatar()==null) ps.setInt(5,u.getId());  
        else {
        	ps.setBlob(5,u.getAvatar());
        	ps.setInt(6,u.getId());
        }
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int deleteUser(Connection con, int id){  
    int status=0;  
    try{  
         
        PreparedStatement ps=con.prepareStatement("delete from USERACCOUNT where USER_ID=?");  
        ps.setInt(1,id);  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
  
public static UserAccount getRecordById(int id){  
	UserAccount u=null;  
    try{  
        Connection con=ConnectionUtils.getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from USERACCOUNT where USER_ID=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new UserAccount();  
           
            u.setUserName(rs.getString("name"));  
            u.setAvatar(rs.getAsciiStream("avatar"));
            u.setPhone(rs.getString("phone"));
            u.setAddress(rs.getString("address"));
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
   	 sql = "Select a.user_Id, a.UserName, a.Password, a.Mail, a.phone, a.Address, a.Role from USERACCOUNT a " //
               + " where a.MAIL = ? and a.password= ?";	        	
   	 }
	
   else {
   	 sql = "Select a.user_Id, a.UserName, a.Password, a.Mail, a.phone, a.Address, a.Role from USERACCOUNT a " //
               + " where a.UserName = ? and a.password= ?";
   	 
   } 

	PreparedStatement pstm = conn.prepareStatement(sql);
    
    if(userName.equals("gmail")) pstm.setString(3, userName);        
    else pstm.setString(1, userName);
    pstm.setString(2, password);
    ResultSet rs = pstm.executeQuery();

    if (rs.next()) {
        
        UserAccount user = new UserAccount();
        user.setId(rs.getInt("USER_ID"));
        user.setRole(rs.getInt("role"));
        user.setUserName(rs.getString("UserName"));;
        user.setPhone(rs.getString("phone"));
        user.setAddress(rs.getString("address"));
        user.setPassword(password);
        user.setMail(rs.getString("mail")); 
        return user;
    }
    return null;
}
public static UserAccount findUser(Connection conn, int id) throws SQLException {
	 String sql = "Select * from USERACCOUNT a " //
              + " where a.USER_ID= ?";
	PreparedStatement pstm = conn.prepareStatement(sql); 
    pstm.setInt(1,id);

    ResultSet rs = pstm.executeQuery();

    if (rs.next()) {
       
       UserAccount user = new UserAccount();
       user.setId(rs.getInt("USER_ID"));
       user.setRole(rs.getInt("role"));
       user.setUserName(rs.getString("UserName"));;
       user.setPhone(rs.getString("phone"));
       user.setAddress(rs.getString("address"));
       user.setPassword(rs.getString("password"));
       user.setMail(rs.getString("mail")); 
       return user;
   }
   return null;
}
public static List<UserAccount> queryUser(Connection conn) throws SQLException {
    String sql = "Select a.USER_ID, a.UserName,a.Avatar, a.Password, a.Mail, a.phone, a.address, a.Role from USERACCOUNT a  ";

    PreparedStatement pstm = conn.prepareStatement(sql);

    ResultSet rs = pstm.executeQuery();
    List<UserAccount> list = new ArrayList<UserAccount>();
    while (rs.next()) {
        
        UserAccount user = new UserAccount();
        user.setId(rs.getInt("USER_ID"));
        user.setRole(rs.getInt("role"));
        user.setUserName(rs.getString("UserName"));;
        user.setAvatar( rs.getAsciiStream("avatar"));
        user.setPassword(rs.getString("password"));
        user.setMail(rs.getString("mail")); 
        user.setPhone(rs.getString("phone"));
        user.setAddress(rs.getString("address"));
        //if(user.getRole()!=1)  
        	list.add(user);
    }
    return list;
}
@SuppressWarnings("unused")
private static int getMaxId(Connection conn) throws SQLException {
    String sql = "Select max(a.USER_ID) from USERACCOUNT a";
    PreparedStatement pstm = conn.prepareStatement(sql);
    ResultSet rs = pstm.executeQuery();
    if (rs.next()) {
        int max = rs.getInt(1);
        return max;
    }
    return 0;
}
}  
