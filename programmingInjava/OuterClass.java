package programmingInjava;

public class OuterClass {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return new InnerClass().getAge();
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	private class InnerClass{
		public InnerClass(){
			name="Johan";
			age=31;
		}
		public int getAge(){
			return age;
		}
		public String getName(){
			return name;
		}
	}
	public String display(){
		return new InnerClass().getName()+", age: "+age;
	}
	public static void main(String[] args) {
		OuterClass oc=new OuterClass();
		
		System.out.println(oc.display());
	}
}
