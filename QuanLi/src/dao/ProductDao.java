package dao;

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
	"insert into PRODUCT(id,image,name,category,price,des,detail) values(?,?,?,?,?,?,?)");  
	        //ps.setInt(1, getMaxId(con)+1);
	        ps.setInt(1,pr.getId());
	        ps.setBlob(2,pr.getImage());
	        ps.setString(3,pr.getName()); 
	        ps.setString(4,pr.getCate()); 
	        ps.setFloat(5,pr.getPrice());  
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
		    	System.out.println("product ="+rs.getString("name"));
		        Product product = new Product();
		        product.setId(rs.getInt("id"));
		        product.setImage(rs.getAsciiStream("image"));
		        product.setName(rs.getString("name"));
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
	              + " where p.id= ?";
		PreparedStatement pstm = conn.prepareStatement(sql); 
	    pstm.setInt(1,id);

	    ResultSet rs = pstm.executeQuery();

	    if (rs.next()) {
	       
	    	Product product = new Product();
	    	product.setId(rs.getInt("id"));
	        product.setImage(rs.getAsciiStream("image"));
	        product.setName(rs.getString("name"));
	        product.setPrice(rs.getFloat("price"));
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
		    	PreparedStatement ps=con.prepareStatement( "update PRODUCT set  name=?,category=?,price=?,des=?,detail=?,image=? where id=?");  
		    	if(product.getImage()==null) {
		        ps=con.prepareStatement( "update PRODUCT set  name=?,category=?,price=?,des=?,detail=? where id=?");  
		    	}
		    	
			        ps.setString(1,product.getName()); 
			        ps.setString(2,product.getCate());
			        ps.setFloat(3,product.getPrice());  
			        ps.setString(4,product.getDes()); 
			        ps.setString(5,product.getDetail()); 
		        if(product.getImage()==null) ps.setInt(6,product.getId());  
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
	         
	        PreparedStatement ps=con.prepareStatement("delete from Product where id=?");  
	        ps.setInt(1,id);  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	}

