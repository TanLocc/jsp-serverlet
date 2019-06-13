package hello;

import java.util.ArrayList;
import java.util.Scanner;

public class Operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
					
		           Operation main = new Operation();
				Employee nv1 = main.enterEmployeeInfo();
				Employee nv2 = main.enterEmployeeInfo();
				Employee nv3 = main.enterEmployeeInfo();	
				Employee nv4 = main.enterEmployeeInfo();	
				Employee nv5 = main.enterEmployeeInfo();
				ArrayList<Employee> employees = new ArrayList<Employee>();
				employees.add(nv1);
				employees.add(nv2);
				employees.add(nv3);
				employees.add(nv4);
				employees.add(nv5);
				
					main.testJob(employees);
					
				}
				
		        private void testJob(ArrayList<Employee> employees){
	        	for(int i=0; i < employees.size();i++){
					if(employees.get(i).getJob().getName().equals("Developer")){
						System.out.println("employee  cong viec la Developer");
					
					}	
				}
	        }

			private Employee enterEmployeeInfo() {

				Employee nv = new Employee() ;
				Scanner scan1 = new Scanner(System.in);
				// For name
				System.out.println("Name Employee: ");
				String name = scan1.nextLine();
				nv.setName(name);

				Scanner scan2 = new Scanner(System.in);
				// For age
				System.out.println("Age Employee: ");
				int age = scan2.nextInt();
				nv.setAge(age);

				Scanner scan3 = new Scanner(System.in);
				// For job
				System.out.println("Job Employee: ");
				String developer = scan3.nextLine();
				Job job = new Job();
				job.setName(developer);
				nv.setJob(job);

				Scanner scan4 = new Scanner(System.in);
				// For salary
				System.out.println("Salary Employee: ");
				double sal = scan4.nextDouble();
				nv.setSalary(sal);

				return nv;
			}
	}


