package hello;

public class Dog1 extends Animal {
	String typeAnimal;
	public Dog1(String name, int age, String typeAnimal) {
		super(name, age);
		
		
		// TODO Auto-generated constructor stub
	}
	public void move(){
		
		super.setName("kiki");
		super.setAge(3);
		System.out.println("dog ten la "+ super.getName()+" "+super.getAge()+" tuoi"+" có typeAnimal la "+typeAnimal());
	}
	public String typeAnimal() {
		typeAnimal="dog";
		return typeAnimal;
	}
}
