package upFile;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 

 
@WebServlet("/uploadImageToDB")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 8, // 2MB
       maxFileSize = 1024 * 1024 * 10, // 10MB
       maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UpdateImageToDB extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
 
       RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/uploadImage.jsp");
 
       dispatcher.forward(request, response);
   }
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = null;
       try {
           // Kết nối tới Database
           // (Xem thêm tài liệu JDBC).
           conn = ConnectionUtils.getMyConnection();
           conn.setAutoCommit(false);
 
          
 
    
           // Danh mục các phần đã upload lên (Có thể là nhiều file).
           for (Part part : request.getParts()) {
               String Name = extractFileName(part);
               if (Name != null && Name.length() > 0) {
                   // Dữ liệu file.
            	   System.out.println("part1="+part);
                   InputStream is = part.getInputStream();
          
                   // Ghi vào file.
                   this.writeToDB(conn, Name, is);
               }
           }
           conn.commit();
 
  
           // Upload thành công.
           response.sendRedirect(request.getContextPath() + "/uploadImageToDBResults");
       } catch (Exception e) {
           e.printStackTrace();
           request.setAttribute("errorMessage", "Error: " + e.getMessage());
           RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsps/uploadImage.jsp");
           dispatcher.forward(request, response);
       } finally {
           this.closeQuietly(conn);
       }
   }
 
   private String extractFileName(Part part) {
       // form-data; name="file"; filename="C:\file1.zip"
       // form-data; name="file"; filename="C:\Note\file2.zip"
       String contentDisp = part.getHeader("content-disposition");
       String[] items = contentDisp.split(";");
       for (String s : items) {
           if (s.trim().startsWith("filename")) {
               // C:\file1.zip
               // C:\Note\file2.zip
               String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
               clientFileName = clientFileName.replace("\\", "/");
               int i = clientFileName.lastIndexOf('/');
               // file1.zip
               // file2.zip
               return clientFileName.substring(i + 1);
           }
       }
       return null;
   }
 
   private Long getMaxPersonId(Connection conn) throws SQLException {
       String sql = "Select max(p.id) from Person p";
       PreparedStatement pstm = conn.prepareStatement(sql);
       ResultSet rs = pstm.executeQuery();
       if (rs.next()) {
           long max = rs.getLong(1);
           return max;
       }
       return 0L;
   }
   
   private void writeToDB(Connection conn, String Name, InputStream is) throws SQLException {
 
       String sql = "Insert into Person(Id,Name,IMAGE_DATA,Image_File_Name) " //
               + " values (?,?,?,?) ";
       System.out.println("Name"+Name);
       PreparedStatement pstm = conn.prepareStatement(sql);
       String Image_File_Name = String.join(Name, ".jpg");
       Long id = this.getMaxPersonId(conn) + 1;
       pstm.setLong(1, id);
       pstm.setString(2, Name);
       pstm.setBlob(3, is);
       pstm.setString(4, Image_File_Name);
       pstm.executeUpdate();
   }
 
   private void closeQuietly(Connection conn) {
       try {
           if (conn != null) {
               conn.close();
           }
       } catch (Exception e) {
       }
   }
 
}
