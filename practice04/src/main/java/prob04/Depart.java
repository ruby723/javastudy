package prob04;

public class Depart extends Employee{
	private String depart;
	
	public Depart(String name,int salary,String depart) {
		setName(name);
		setSalary(salary);
		this.depart=depart;
		//System.out.println( "이름:" + getName() + " 연봉:" + getSalary()+" 부서:"+depart );
	}
	
	public void getInformation() {
		System.out.println( "이름:" + getName() + " 연봉:" + getSalary()+" 부서:"+depart );
	}
}
