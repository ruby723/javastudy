package chapter03;

public class Student extends Person {
	private int grade;
	private String major;
	
	public Student() {
		//자식의 모든생성자에서 부모의 특정 생성자를 명시하지 않으면
		//암시적으로 부모의 기본생성자가 자식 생성자 코드앞에 호출된다.
		//super();
		System.out.println("Student() called");
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
}
