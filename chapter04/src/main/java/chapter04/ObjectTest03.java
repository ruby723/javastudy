package chapter04;

public class ObjectTest03 {
	
	public static void main(String[] args) {
		String s1= new String("ABC");
		String s2= new String("ABC");
		
		System.out.println(s1==s2);//객체가 다름 : false
		System.out.println(s1.equals(s2)); // 내용이 같음 : true
		System.out.println(s1.hashCode()+":"+s2.hashCode());//hashCode 함수를 사용하여 해쉬코드값이 같다.
		System.out.println(System.identityHashCode(s1)+":"+System.identityHashCode(s2));//주소기반 해시코드값은 다르다.
		
		System.out.println("========================================");
		
		String s3="ABC";
		String s4="ABC";
		
		System.out.println(s3==s4);//객체가 같다고 나옴 : true
		System.out.println(s3.equals(s4)); // 내용이 같음 : true
		System.out.println(s3.hashCode()+":"+s4.hashCode());//hashCode 함수를 사용하여 해쉬코드값이 같다.
		System.out.println(System.identityHashCode(s3)+":"+System.identityHashCode(s4));//주소기반 해시코드값도 같다.
	}
}
