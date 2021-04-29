package chapter03;

public class StudentTest {

	public static void main(String[] args) {
		
		Student s1=new Student();
		s1.setName("둘리");
		s1.setGrade(4);
		s1.setMajor("CS");
		
		Person p1=s1;//(암시적)업캐스팅
		Student s2=(Student)p1;//다운캐스팅(명시적)
	}

}
