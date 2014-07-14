package dataStructures;

public class TreeTest {
	public static void main(String[] args) {
		Tree t= new Tree("grandpa");		
		System.out.println(t.toString()+"\n");
		
		Tree t2 = new Tree("father");
		t.addSubtree(t2);
		System.out.println("size: "+t.getSize());
		System.out.println(t.toString()+"\n");
		Tree t3 = new Tree("mother");
		t.addSubtree(t3);
		System.out.println("family size: "+t.getSize());
		System.out.println(t.toString()+"\n");
		
		Tree tt = new Tree("Tro");
		Tree to = new Tree("Ole");
		t2.addSubtree(tt);
		
		t2.addSubtree(to);
		t2.addSubtree(new Tree("Kari"));
		System.out.println("family size: "+t.getSize());
		System.out.println(t.toString()+"\n");
		
		t3.addSubtree(tt);
		t3.addSubtree(to);
		t3.addSubtree(new Tree("Threse"));
		System.out.println("family size: "+t.getSize());
		System.out.println(t.toString()+"\n");
		
		tt.addSubtree(new Tree("Simon"));
		tt.addSubtree(to);
		tt.addSubtree(new Tree("Threse"));
		System.out.println("family size: "+t.getSize());
		System.out.println(t.toString()+"\n");
	}
}
