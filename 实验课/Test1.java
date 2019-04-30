class Stu{
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public int getAge() {
		if(age>=20 && age<=30) {
			return age;
		}
		else {
			return -1;
		}
	}
	
	public void study(){
		System.out.println(this.name + " " + this.age + " " + "study");
	}
}

class Teacher{
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		if(age>=30 && age<=70) {
			return age;
		}
		else {
			return -1;
		}
	}
	
	public void study(){
		System.out.println(this.name + " " + this.age + " " + "teach");
	}
}



public class Test1 {

	public static void main(String[] args) {
		Teacher t1 = new Teacher();
		t1.setName("Li");
		t1.setAge(50);
		t1.study();
		
		Stu s1 = new Stu();
		s1.setAge(15);
		s1.setName("Wang");
		s1.study();
	}

}
