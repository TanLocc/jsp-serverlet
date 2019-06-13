package hello;

public class Tiger extends Animal {
	String typeAnimal;
	public Tiger(String name, int age, String typeAnimal) {
		super(name, age);
		// TODO Auto-generated constructor stub
		name="niki";
		age=10;
	}

	public void move(){
		
		super.setName("niki");
		super.setAge(5);
		System.out.println("tiger ten la "+ super.getName()+" "+super.getAge()+" tuoi"+" có typeAnimal la "+typeAnimal());
	}
	public String typeAnimal() {
		typeAnimal="tiger";
		return typeAnimal;
	}
}
