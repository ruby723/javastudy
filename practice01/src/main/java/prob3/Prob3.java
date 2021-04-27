package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int num=scanner.nextInt();
		int sum=0;
		
		if(num%2==0) {
			for(int i=0;i<=num;i+=2) {
				sum+=i;
			}
		}
		else {
			for(int i=1;i<=num;i+=2) {
				sum+=i;
			}
		}
		
		System.out.println(sum);
		scanner.close();
	}
}
