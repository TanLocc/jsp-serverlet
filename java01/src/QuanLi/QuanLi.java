package QuanLi;

import java.util.*;

public interface QuanLi {
	public List<NhanVien> khoiTaoNhanVien();
	public Set<KySu> khoiTaoKySu();
	public HashMap<String, CongNhan> khoiTaoCongNhan();
	public void hienThiDanhSachCanBo(LoaiCanBo loaiCB);
	public void timKiemCanBo(String name, LoaiCanBo loaiCB);
}
