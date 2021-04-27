package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		char[] rev=new char[str.length()];
		
		for(int i=str.length()-1;i>=0;i--) {
			rev[str.length()-1-i]=str.charAt(i);
		}
		return rev;
	}

	public static void printCharArray(char[] array){
		System.out.println( array );
	}
}