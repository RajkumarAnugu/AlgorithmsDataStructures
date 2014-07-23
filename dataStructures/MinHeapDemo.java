package dataStructures;

public class MinHeapDemo {
	public static void main(String[] args) {
		MinHeap mh = new MinHeap();
		mh.add("20");
		mh.add("75");
		mh.add("43");
		mh.add("84");
		mh.add("90");
		mh.add("57");
		mh.add("71");
		mh.add("96");
		mh.add("91");
		mh.add("93");

		System.out.println(mh.getElements().toString());
		mh.remove();
		System.out.println(mh.getFixHeapString());
		System.out.println("\n - - - -\n");

		MinHeap q = new MinHeap();
		q.add(new WorkOrder(3, "Shampoo carpets"));
		q.add(new WorkOrder(7, "Empty trash"));
		q.add(new WorkOrder(8, "Water plants"));
		q.add(new WorkOrder(10, "Remove pencil sharpener shavings"));
		q.add(new WorkOrder(6, "Replace light bulb"));
		q.add(new WorkOrder(1, "Fix broken sink"));
		q.add(new WorkOrder(9, "Clean coffee maker"));
		q.add(new WorkOrder(2, "Order cleaning supplies"));

		System.out.println(q.getElements().toString());
		while (!q.empty()) {
			System.out.println(q.remove());
		}
	}
}
