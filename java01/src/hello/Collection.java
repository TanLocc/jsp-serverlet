package hello;

import java.util.*;


public class Collection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map m1 = new HashMap();
		m1.put("zala","8");
        m1.put("loc","14");
        String ten = (String) m1.get("zala");
        System.out.println();
        System.out.println("Map elements: ");
        System.out.println("\t"+ten);
        System.out.println("\t"+m1);
	}

}
