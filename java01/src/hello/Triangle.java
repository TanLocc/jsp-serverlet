package hello;

public class Triangle extends Shape{
	
	  double Area = 0;

	public Triangle(String color, double base,double height) {
		super(color);	
		Area=0.5*base*height;				// TODO Auto-generated constructor stub	
		System.out.println(toString());
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Area;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		 String	Str="Hinh Triangle mau "+this.color+" co dien tich "+getArea();
		 return Str;
	}
    
}
