package QuanLi;

import java.util.*;




public class MainQuanLi implements QuanLi {
	public static List<NhanVien> nhanViens;
	public static Set<KySu> kySus;
	public static HashMap<String, CongNhan> congNhans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainQuanLi quanLyCanBo = new MainQuanLi();
		nhanViens = quanLyCanBo.khoiTaoNhanVien();
		kySus = quanLyCanBo.khoiTaoKySu();
		congNhans = quanLyCanBo.khoiTaoCongNhan();
		LoaiCanBo loaiCanBo = null;
		int Cach = 1;
		String loai;
		
		while(true){
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap loai can bo muon hien danh sach: ");
		loai =scan.nextLine();
		if(loai.equals("sv")) loaiCanBo=LoaiCanBo.NV;
		else if (loai.equals("ks")) loaiCanBo=LoaiCanBo.KS;
		else if (loai.equals("cn")) loaiCanBo=LoaiCanBo.CN;
		quanLyCanBo.hienThiDanhSachCanBo(loaiCanBo);
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Bam 0 de khong nhap tiep ");
		Cach=scan1.nextInt();
		if(Cach==0) break;
			}
		while(true){
			Scanner scan3 = new Scanner(System.in);
			System.out.println("Nhap ten can bo muon tiem kiem: ");
			Scanner scan4 = new Scanner(System.in);
			System.out.println("Nhap loai can bo muon hien danh sach: ");
			loai =scan4.nextLine();
			if(loai.equals("sv")) loaiCanBo=LoaiCanBo.NV;
			else if (loai.equals("ks")) loaiCanBo=LoaiCanBo.KS;
			else if (loai.equals("cn")) loaiCanBo=LoaiCanBo.CN;
			quanLyCanBo.timKiemCanBo(scan3.nextLine(), loaiCanBo);
			Scanner scan5 = new Scanner(System.in);
			System.out.println("Bam 0 de khong nhap tiep ");
			Cach=scan5.nextInt();
			if(Cach==0) break;
		}
	}
	public List<NhanVien> khoiTaoNhanVien() {
		// TODO Auto-generated method stub
		List<NhanVien> nhanViens = new ArrayList<NhanVien>();
		int Cach = 1;
		while(true){
			
		NhanVien nv = new NhanVien(null, 0, null, null, null);
		Scanner scan = new Scanner(System.in);
		System.out.println("Ho ten nhan vien: ");
		nv.setHoTen( scan.nextLine());
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Nam sinh nhan vien: ");
		nv.setNamSinh( scan1.nextInt());
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Gioi Tinh nhan vien: ");
		nv.setGioiTinh( scan2.nextLine());
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Dia chi nhan vien: ");
		nv.setDiaChi( scan3.nextLine());
		Scanner scan4 = new Scanner(System.in);
		System.out.println("Cong viec nhan vien: ");
		nv.setCongviec( scan4.nextLine());
		nhanViens.add(nv);
		Scanner scan5 = new Scanner(System.in);
		System.out.println("Bam 0 de khong nhap tiep ");
		Cach=scan5.nextInt();
		if(Cach==0) break;
		
		}
		return nhanViens;
		
	}

	@SuppressWarnings("resource")
	public Set<KySu> khoiTaoKySu() {
		// TODO Auto-generated method stub
		Set<KySu> kySus = new HashSet<KySu>();
		int Cach = 1;
		while(true){
			
		KySu ks = new KySu(null, 0, null, null, null);
		Scanner scan = new Scanner(System.in);
		System.out.println("Ho ten ky su: ");
		ks.setHoTen( scan.nextLine());
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Nam sinh ky su: ");
		ks.setNamSinh( scan1.nextInt());
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Gioi Tinh ky su: ");
		ks.setGioiTinh( scan2.nextLine());
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Dia chi ky su: ");
		ks.setDiaChi( scan3.nextLine());
		Scanner scan4 = new Scanner(System.in);
		System.out.println("Nganh dao tao ky su: ");
		ks.setNganhdaotao( scan4.nextLine());
		kySus.add(ks);
		Scanner scan5 = new Scanner(System.in);
		System.out.println("Bam 0 de khong nhap tiep ");
		Cach=scan5.nextInt();
		if(Cach==0) break;
		
		}
		return kySus;
		
		
	}

	public HashMap<String, CongNhan> khoiTaoCongNhan() {
		// TODO Auto-generated method stub
		HashMap<String, CongNhan> congNhans = new HashMap<String, CongNhan>();
		int Cach = 1;
		while(true){
			
		CongNhan cn = new CongNhan(null, 0, null, null, null);
		Scanner scan = new Scanner(System.in);
		System.out.println("Ho ten cong nhan: ");
		cn.setHoTen( scan.nextLine());
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Nam sinh cong nhan: ");
		cn.setNamSinh( scan1.nextInt());
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Gioi Tinh cong nhan: ");
		cn.setGioiTinh( scan2.nextLine());
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Dia chi cong nhan: ");
		cn.setDiaChi( scan3.nextLine());
		Scanner scan4 = new Scanner(System.in);
		System.out.println("Bac cong nhan: ");
		cn.setBac(scan4.nextLine());
		congNhans.put(cn.getHoTen(),cn);
		Scanner scan5 = new Scanner(System.in);
		System.out.println("Bam 0 de khong nhap tiep ");
		Cach=scan5.nextInt();
		if(Cach==0) break;
		
		}
		return congNhans;
		
	}

	public void hienThiDanhSachCanBo(LoaiCanBo loaiCB) {
		// TODO Auto-generated method stub
		switch (loaiCB) {
		case NV:
			hienThiDanhSachNhanVien();
			break;
		case KS:
			hienThiDanhSachKySu();
			break;
		case CN:
			hienThiDanhSachCongNhan();
			break;
		default:
			break;
		}
		
	}
	public static void hienThiDanhSachNhanVien() {
		System.out.println("     Ho Ten         | Loai Can Bo | Cong Viec");
		for (int i = 0 ; i < nhanViens.size(); i++) {
			NhanVien nv = nhanViens.get(i);
			System.out.println(i+1 + ", " + nv.getHoTen() + "    nhan vien    " + nv.getCongviec());
		}
	}
	
	public static void hienThiDanhSachKySu() {
		System.out.println("     Ho Ten         | Loai Can Bo | Cong Viec");
		Iterator<KySu> it = kySus.iterator();
		int i = 1;
        while (it.hasNext()) {
        	KySu element = (KySu) it.next();
        	System.out.println(i + ", " + element.getHoTen() + "    ky su    " + element.getNganhdaotao());
        	i++;
        }
	}
	
	public static void hienThiDanhSachCongNhan() {
		System.out.println("     Ho Ten         | Loai Can Bo | Cong Viec");
		int i = 1;
	    for (HashMap.Entry<String, CongNhan> entry : congNhans.entrySet()) {
	    	CongNhan cn = (CongNhan) entry.getValue();
	    	System.out.println(i + ", " + cn.getHoTen() + "    cong nhan    " + cn.getBac());
		}
	}

	public void timKiemCanBo(String name, LoaiCanBo loaiCB) {
		// TODO Auto-generated method stub
		switch (loaiCB) {
		case NV:
			NhanVien nv = timNhanVien(name);
			if (nv != null && nv.getHoTen() != null) {
				System.out.println("   Ho Ten   | Loai Can Bo | Cong Viec");
				System.out.println(nv.getHoTen() + "    nhan vien    " + nv.getCongviec());
			} else {
				System.out.println("Khong tim thay!!!");
			}
			break;
		case KS:
			KySu ks = timKySu(name);
			if (ks != null && ks.getHoTen() != null) {
				System.out.println("   Ho Ten  | Loai Can Bo | Cong Viec");
        		System.out.println(ks.getHoTen() + "    ky su    " + ks.getNganhdaotao());
			} else {
				System.out.println("Khong tim thay!!!");
			}
			break;
		case CN:
			CongNhan cn = timCongNhan(name);
			if (cn != null && cn.getHoTen() != null) {
				System.out.println("   Ho Ten  | Loai Can Bo | Cong Viec");
        		System.out.println(cn.getHoTen() + "    cong nhan    " + cn.getBac());
			} else {
				System.out.println("Khong tim thay!!!");
			}
			break;
		default:
			break;
		}
	}

	public static NhanVien timNhanVien(String name) {
		for (int i = 0 ; i < nhanViens.size(); i++) {
			NhanVien nv = nhanViens.get(i);
			if (name != null && nv.getHoTen().equals(name)) {
				return nv;
			}
		}
		return null;
	}
	
	public static KySu timKySu(String name) {
		Iterator<KySu> it = kySus.iterator();
		while (it.hasNext()) {
        	KySu kySu = (KySu) it.next();
        	if (name != null && kySu.getHoTen().equals(name) ) {
        		
        		return kySu;
        	}
        }
		return null;
	}
	
	public static CongNhan timCongNhan(String name) {
		for (HashMap.Entry<String, CongNhan> entry : congNhans.entrySet()) {
	    	CongNhan cn = (CongNhan) entry.getValue();
	    	System.out.println(congNhans.entrySet());
	    	if (name != null && cn.getHoTen().equals(name)) {
	    		return cn;
	    	}
		}
		return null;
	}

}
