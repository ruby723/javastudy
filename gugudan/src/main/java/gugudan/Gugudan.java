package gugudan;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Gugudan {
	private int a;
	private int b;
	private int result;
	
	public void test() {
		Random rand=new Random();
		
		int a=rand.nextInt(9)+1;
		int b=rand.nextInt(9)+1;
		this.a=a;
		this.b=b;
		this.result=a*b;
		
		System.out.println(a+" x "+b+" = ?");
		
		Set<Integer> set=new HashSet<Integer>();
		
		set.add(result);
		
		while(set.size()<9) {
			int c=rand.nextInt(9)+1;
			int d=rand.nextInt(9)+1;
			int result2=c*d;
			set.add(result2);
		}
		Iterator iterator=set.iterator();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(iterator.next()+"\t");
			}
			System.out.println();
		}
	}
	
	public int write() {
		Scanner sc=new Scanner(System.in);
		System.out.print("answer : ");
		int answer=sc.nextInt();
		return answer;
	}
	
	public void answer(){
		if(write()==result) {
			System.out.println();
			System.out.println("정답");
		}else {
			System.out.println();
			System.out.println("오답");
		}
	}
}
