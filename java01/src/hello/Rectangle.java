package hello;

public class Rectangle extends Shape {
   double Area;
   
	public Rectangle(String color, double length,double width) {
		super(color);
	
		Area=length*width;				// TODO Auto-generated constructor stub
			
		System.out.println(toString());
	};
	
		
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Area;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
	 String	Str="Hinh rectangle mau "+this.color+" co dien tich "+getArea();
	 return Str;
	}
    
	

}
