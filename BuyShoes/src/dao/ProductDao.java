package dao;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Product;
import beans.UserAccount;

public class ProductDao {
	public static int save(Product pr, Connection con){  
	    int status=0;  
	    try{  
	         
	        PreparedStatement ps=con.prepareStatement(  
	"insert into PRODUCT(image,name,category,price,amount,des,detail) values(?,?,?,?,?,?,?)");  
	        //ps.setInt(1, getMaxId(con)+1);
	        //ps.setInt(1,pr.getId());
	        ps.setBlob(1,pr.getImage());
	        ps.setString(2,pr.getName()); 
	        ps.setString(3,pr.getCate()); 
	        ps.setFloat(4,pr.getPrice()); 
	        ps.setInt(5,pr.getAmount());
	        ps.setString(6,pr.getDes()); 
	        ps.setString(7,pr.getDetail());
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}

	public static List<Product> queryProduct(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "Select * from PRODUCT  ";

		    PreparedStatement pstm = conn.prepareStatement(sql);

		    ResultSet rs = pstm.executeQuery();
		    List<Product> list = new ArrayList<Product>();
		    while (rs.next()) {
		        Product product = new Product();
		        product.setId(rs.getInt("product_id"));
		        product.setImage(rs.getAsciiStream("image"));
		        product.setName(rs.getString("name"));
		        product.setAmount(rs.getInt("amount"));
		        product.setPrice(rs.getFloat("price"));
		        product.setDes(rs.getString("des"));
		        product.setDetail(rs.getString("detail"));
		        product.setCate(rs.getString("category"));
		       
		       
		        	list.add(product);
		    }
		    return list;
	}

	public static Product findProduct(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "Select * from Product p " //
	              + " where p.product_id= ?";
		PreparedStatement pstm = conn.prepareStatement(sql); 
	    pstm.setInt(1,id);

	    ResultSet rs = pstm.executeQuery();

	    if (rs.next()) {
	       
	    	Product product = new Product();
	    	product.setId(rs.getInt("product_id"));
	        product.setImage(rs.getAsciiStream("image"));
	        product.setName(rs.getString("name"));
	        product.setPrice(rs.getFloat("price"));
	        product.setAmount(rs.getInt("amount"));
	        product.setDes(rs.getString("des"));
	        product.setDetail(rs.getString("detail"));
	        product.setCate(rs.getString("category"));
	       return product;
	   }
	    return null;
	  
	}

	public static int updateProduce(Connection con, Product product) {
		// TODO Auto-generated method stub
		 int status=0;  
		    try{  
		    	PreparedStatement ps=con.prepareStatement( "update PRODUCT set  name=?,category=?,price=?,amount=?,des=?,detail=?,image=? where product_id=?");  
		    	if(product.getImage()==null) {
		        ps=con.prepareStatement( "update PRODUCT set  name=?,category=?,price=?,amount=?,des=?,detail=? where product_id=?");  
		    	}
		    	
			        ps.setString(1,product.getName()); 
			        ps.setString(2,product.getCate());
			        ps.setFloat(3,product.getPrice());
			        ps.setInt(4,product.getAmount());
			        ps.setString(5,product.getDes()); 
			        ps.setString(6,product.getDetail()); 
		        if(product.getImage()==null) ps.setInt(7,product.getId());  
		        else {
		        	ps.setBlob(7,product.getImage());
			        ps.setInt(8,product.getId());
		        }
		        status=ps.executeUpdate();  
		    }catch(Exception e){System.out.println(e);}  
		    return status;  
		}

	public static int deleteProduce(Connection con, int id) {
		// TODO Auto-generated method stub
		int status=0;  
	    try{  
	         
	        PreparedStatement ps=con.prepareStatement("delete from Product where product_id=?");  
	        ps.setInt(1,id);  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}

	public static List<Product> finndByText(Connection conn, String text) throws SQLException {
		// TODO Auto-generated method stub
		text =String.join("","%",text,"%");
		String sql = "SELECT*FROM PRODUCT"+
				     " WHERE name LIKE  ? or category like ? or des like ? or detail like ?";
		PreparedStatement pstm = conn.prepareStatement(sql); 
	    pstm.setString(1,text);
	    pstm.setString(2,text);
	    pstm.setString(3,text);
	    pstm.setString(4,text);

	    ResultSet rs = pstm.executeQuery();
	    List<Product> list = new ArrayList<Product>();
	    while (rs.next()) {
	        Product product = new Product();
	        product.setId(rs.getInt("product_id"));
	        product.setImage(rs.getAsciiStream("image"));
	        product.setName(rs.getString("name"));
	        product.setAmount(rs.getInt("amount"));
	        product.setPrice(rs.getFloat("price"));
	        product.setDes(rs.getString("des"));
	        product.setDetail(rs.getString("detail"));
	        product.setCate(rs.getString("category"));
	       
	       
	        	list.add(product);
	    }
	    return list;
	}

	public static List<Product> queryPopularProduct(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "SELECT P.PRODUCT_ID,P.IMAGE,P.NAME,P.CATEGORY,P.PRICE,P.AMOUNT,P.DES,P.DETAIL,SUM(O.AMOUNT)" + 
		 		      " FROM ORDERS as O " + 
		 		      " INNER JOIN PRODUCT AS P ON O.PRODUCT_ID = P.PRODUCT_ID" + 
		 		      " GROUP BY PRODUCT_ID;";
 
		    PreparedStatement pstm = conn.prepareStatement(sql);

		    ResultSet rs = pstm.executeQuery();
		    List<Product> list = new ArrayList<Product>();
		    int i=0;
		    while (rs.next()) {
		    	if(rs.getInt("SUM(O.AMOUNT)")>=20){
		        Product product = new Product();
		        product.setId(rs.getInt("product_id"));
		        product.setImage(rs.getAsciiStream("image"));
		        product.setName(rs.getString("name"));
		        product.setAmount(rs.getInt("amount"));
		        product.setPrice(rs.getFloat("price"));
		        product.setDes(rs.getString("des"));
		        product.setDetail(rs.getString("detail"));
		        product.setCate(rs.getString("category"));
		        	list.add(product);}
		    	i++;
		    	if(i==5) return list;
		    }
		    return list;
	}
	}

