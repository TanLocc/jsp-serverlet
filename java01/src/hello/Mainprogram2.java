package hello;

public class Mainprogram2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Dog dog1= new Dog("vang", "jig", "Viet Nam","barking");
     Dog dog2= new Dog("xam", "led", "Nhat","barking");
     System.out.println("dog 1 mau " + dog1.getColor()+" ten la\n "+ dog1.getName()+" thuoc giong\n "+dog1.getBreed()+" dang "+ dog1.getBehavior());
	}

}
