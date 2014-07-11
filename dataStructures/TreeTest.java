package dataStructures;

public class TreeTest {
	public static void main(String[] args) {
		Tree t= new Tree("grandpa");		
		System.out.println(t.toString()+"\n");
		
		Tree t2 = new Tree("father");
		t.addSubtree(t2);
		System.out.println("size: "+t.getSize());
		System.out.println(t.toString()+"\n");
		
		t.addSubtree(new Tree("mother"));
		System.out.println("family size: "+t.getSize());
		System.out.println(t.toString()+"\n");
		
		t2.addSubtree(new Tree("Tro"));
		t2.addSubtree(new Tree("Ole"));
		t2.addSubtree(new Tree("Kari"));
		System.out.println("family size: "+t.getSize());
		System.out.println(t.toString()+"\n");
	}
}
