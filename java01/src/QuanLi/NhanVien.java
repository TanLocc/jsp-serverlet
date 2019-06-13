package QuanLi;

public class NhanVien extends CanBo{
	String congviec;	
public NhanVien(String hoten, int nansinh, String gioitinh, String diachi,String congviec) {
		super(hoten, diachi, gioitinh, nansinh);
		
		// TODO Auto-generated constructor stub
	}
public String getCongviec() {
	return congviec;
}
public void setCongviec(String congviec) {
	this.congviec = congviec;
}


}
