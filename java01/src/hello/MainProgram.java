package hello;

public class MainProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Student student1 = new Student("Dave", 7, "male");
       Student student2 = new Student("Join", 7, "boy");
       Student student3 = new Student("juli", 6, "girl");
       System.out.println(student1);
       System.out.println("name "+"age "+"gender ");
       System.out.println(student1.getName() + " " + student1.getAge()+ "   " + student1.getGender());
       System.out.println(student2.getName() + " " + student2.getAge()+ "   " + student2.getGender());
       System.out.println(student3.getName() + " " + student3.getAge()+ "   " + student3.getGender());
       student1.setAge(8);
       System.out.print("........student 1 updated....... \n");
       System.out.println(student1.getName() + " " + student1.getAge()+ "   " + student1.getGender());
	}

}
