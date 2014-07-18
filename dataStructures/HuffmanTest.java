package dataStructures;

import java.util.HashMap;
import java.util.Map;

public class HuffmanTest {
	public static void main(String[] args) {
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		frequencyMap.put('A', 2089);
		frequencyMap.put('E', 576);
		frequencyMap.put('H', 357);
		frequencyMap.put('I', 671);
		frequencyMap.put('K', 849);
		frequencyMap.put('L', 354);
		frequencyMap.put('M', 259);
		frequencyMap.put('N', 660);
		frequencyMap.put('O', 844);
		frequencyMap.put('P', 239);
		frequencyMap.put('U', 472);
		frequencyMap.put('W', 74);
		frequencyMap.put('\'', 541);
		HuffmanTree tree = new HuffmanTree(frequencyMap);

		Map<Character, String> encodingMap = tree.getEncodingMap();
		String encoded = encode("ALOHAW", encodingMap);
		System.out.println(encoded);
		String decoded = tree.decode(encoded);
		System.out.println(decoded);
		System.out.println();

		String encoded2 = encode("A", encodingMap);
		System.out.println(encoded2);
		String decoded2 = tree.decode(encoded2);
		System.out.println(decoded2);

		System.out.println();

		String encoded3 = encode("P", encodingMap);
		System.out.println(encoded3);
		String decoded3 = tree.decode(encoded3);
		System.out.println(decoded3);

	}

	public static String encode(String toEncode,
			Map<Character, String> encodingMap) {
		String result = "";
		for (int i = 0; i < toEncode.length(); i++) {
			char ch = toEncode.charAt(i);
			result = result + encodingMap.get(ch);// get the value of the key
			System.out.println(encodingMap.get(ch));
		}
		return result;
	}
}
