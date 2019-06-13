package hello;

import java.util.Scanner;





public class MultiInter implements Shape_Interface {
	static double Area = 0; 
	
	

	public double getArea() {
		// TODO Auto-generated method stub
		
		return Area;
	}
	 
		
	 public  String toString1(){
		 System.out.println(getArea());
		return null;
		 
	 };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan1 = new Scanner(System.in);
		// For name
		System.out.println("Area: ");
		 Area = scan1.nextDouble();
		 MultiInter obj = new  MultiInter();
		 obj.toString1();
	
	}
	

}
