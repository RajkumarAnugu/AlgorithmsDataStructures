package dataStructures;

public class CircularArrayQueueTest {
	public static void main(String[] args) {
		CircularArrayQueue cq = new CircularArrayQueue();
		cq.add("Ola");
		cq.add("Tor");
		cq.add("Karri");
		System.out.println(cq.toString());
		cq.add("Nodman");
		cq.add("Johan");
		System.out.println(cq.toString());
		cq.add("Lee");
		System.out.println(cq.toString());
		cq.add("Simen");
		cq.add("Filip");
		System.out.println(cq.toString());
		System.out.println(cq.remove());// remove Ola
		System.out.println(cq.toString());
		cq.add("Jokob");
		cq.add("William");
		System.out.println(cq.toString());
		cq.add("Lucus");
		System.out.println(cq.toString());
		System.out.println(cq.remove());// remove Tor
		System.out.println(cq.toString());
		cq.add("Oscar");
		System.out.println(cq.toString());
	}
}
