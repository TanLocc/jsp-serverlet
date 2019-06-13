package file;

import java.io.*;

import java.io.IOException;

public class TaoFile {
	public static void main(String[] args) throws IOException {
    	try {
	      File file = new File("C:\\Users\\XuanVinh\\Desktop\\tenfil"); // File được tạo ra tại ổ đĩa D
	      // File file = new File("tenfile.txt"); // File được tạo ra trong thư mục project
	      if (file.createNewFile()){
	        System.out.println("File tạo thành công!");
	      } else {
	        System.out.println("File đã tồn tại.");
	      }
    	} catch (IOException e) {
	      e.printStackTrace(); // In ra lỗi
	      
	}
    	String fileData = "Phú Trần IT";
    	FileOutputStream fos = new FileOutputStream("tenfile.txt");
    	fos.write(fileData.getBytes());
    	fos.flush();
    	fos.close();
    }
}
