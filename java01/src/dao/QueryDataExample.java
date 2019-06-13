package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QueryDataExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
Connection connection = ConnectionUtils.getMyConnection();
Statement statement = connection.createStatement();
String sql = "Select * from CUSTOMERS ";
ResultSet rs = statement.executeQuery(sql);
System.out.println(rs.getFetchDirection());
int i=0;
while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
    int Id = rs.getInt(1);
    String NAME = rs.getString(2);
    int age = rs.getInt("AGE");
    System.out.println("--------------------");
    System.out.println("Id:" + Id );
    System.out.println("NAME:" + NAME);
    System.out.println("age:" + age);
}

Scanner scan = new Scanner(System.in);
System.out.println("Nhap id: ");
int id = scan.nextInt();
Scanner scan1 = new Scanner(System.in);
System.out.println("Nhap ten: ");
String name = scan1.nextLine();
Scanner scan3 = new Scanner(System.in);
System.out.println("Nhap tuoi: ");
int age = scan3.nextInt();
Scanner scan4 = new Scanner(System.in);
System.out.println("Nhap dia chi: ");
String addr = scan4.nextLine();
Scanner scan5 = new Scanner(System.in);
System.out.println("Nhap luong: ");
float salary = scan5.nextFloat();
Scanner scan6 = new Scanner(System.in);
System.out.println("Nhap cus_id: ");
int cust_id = scan6.nextInt();
String sql1 = "Insert into CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY,CUST_ID) values ("
   +id+",'"+name+"',"+age+",'"+addr+"',"+salary+","+cust_id+")";
String sql2 = "DELETE FROM CUSTOMERS"+
              "WHERE "+id+ "";
// Thực thi câu lệnh.
// executeUpdate(String) sử dụng cho các loại lệnh Insert,Update,Delete.
int rowCount = statement.executeUpdate(sql1);

// In ra số dòng được trèn vào bởi câu lệnh trên.
System.out.println("Row Count affected = " + rowCount);
	}

	

}
