package dataStructures;

import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet names = new HashSet(101);
		names.add("Harry");
		names.add("Sue");
		names.add("Nina");
		names.add("Susannah");
		names.add("Larry");
		names.add("Eve");
		names.add("Sarah");
		names.add("Adam");
		names.add("Tony");
		names.add("Katherine");
		names.add("Juliet");
		names.add("Romeo");
		System.out.println("names.contains(Romeo): " + names.contains("Romeo"));
		names.remove("Romeo");
		names.remove("George");
		System.out.println(names.contains(names));
		System.out.println("names.contains(Romeo): " + names.contains("Romeo"));
		Iterator<?> iter = names.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println(names.getOutprint());
	}
}
