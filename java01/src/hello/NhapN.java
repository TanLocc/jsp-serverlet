package hello;
import java.util.Scanner;
public class NhapN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N,i=0;
		do{
		Scanner scan1 = new Scanner(System.in);		
		if(i==0)System.out.println("Nhap N ");
		else System.out.println("N phai >0 va < 1000, nhap lai N ");
		 N = scan1.nextInt();
		System.out.println(N);
		i=1;
		} while(N<0||N>1000);
		
		int K=0;
	for(int j=1;j<=N;j++){
		if(j%2==0){
			K++;
			if(K!=2) continue;
			 System.out.println("So chan thu 2 trong day so 0->"+N+" la "+ j);
		}
		
	}
	System.out.println("So chu so chan tu 0->"+N+" la "+ K);
		
	}

}
