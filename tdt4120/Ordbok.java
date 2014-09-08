package tdt4120;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * 
 * Du skal lage et program for å finne ord i en tekst. For å gjøre dette, kan du
 * lage en funksjon som bygger et tre og en funksjon som bruker treet til å
 * søke.
 * Første linje av input til programmet er en streng som består av tegnene
 * [a-z] og mellomrom. Dette representerer dokumentet det skal søkes i.
 * 
 * De neste linjene i input er spørringer etter ord. Programmet skal søke etter
 * disse ordene i teksten, og returnere hvilke posisjoner ordet finnes på.
 * Tegnet ? brukes til å angi at her kan det stå en hvilket som helst bokstav
 * fra alfabetet [a-z].
 * 
 * En måte å løse denne oppgaven på er å putte ordene inn i et tre, hvor hver
 * bokstav i ordet tilsvarer en peker til neste node.
 * Nedenfor ser du treet for setningen ha ha mons har en hund med moms hun er en
 * hunn. Legg merke til at noen av nodene inne i treet tilsvarer slutten på ord,
 * mens andre ikke gjør det. Legg også merke til at noen ord finnes på flere
 * steder i dokumentet.
 *
 */
public class Ordbok {
	/**
	 * 
	 * @param ordliste
	 * @return root Node
	 */
	public static Node3 bygg(String[] ordliste) {
		// SKRIV DIN KODE HER
		Node3 root = new Node3();
		int currentPosition = 0;
		// for (String string : ordliste) {
		// same runtime with for (int j = 0; j < ordliste.length; j++)
		for (int j = 0; j < ordliste.length; j++) {
			Node3 current = root;
			for (int i = 0; i < ordliste[j].length(); i++) {
				String k = ordliste[j].charAt(i) + "";
				if (!current.barn.containsKey(String.valueOf(k))) {
					current.barn.put(k, new Node3());
				}
				current = (Node3) current.barn.get(String.valueOf(k));
			}
			current.posisjoner.add(currentPosition);
			currentPosition += ordliste[j].length() + 1;
		}
		return root;
	}

	/**
	 * 
	 * @param ord
	 * @param index
	 * @param currentNode
	 * @return
	 * 
	 *         Funksjonen posisjoner(ord, indeks, node) som skal returnerer
	 *         posisjonene til alle treff på ord i trestrukturen med rot node.
	 *         indeks sier hvor langt i ordet vi har kommet. For å finne disse
	 *         posisjonene kan den bruke rekursjon. Å bruke rekursjon vil si å
	 *         utføre rekursive kall. Et kall til funksjonen selv er et
	 *         rekursivt kall. Rekursjon brukes som regel til å dele opp et
	 *         problem i mindre deler, for deretter å sette sammen løsningene. I
	 *         dette problemet er det ordene som inneholder ? som kan gi flere
	 *         delproblemer. Når du ser ? skal du kalle posisjoner én gang for
	 *         alle mulige erstatninger for ? med de tilhørende delene av treet.
	 */
	public static ArrayList<Integer> posisjoner(String ord, int index,
			Node3 currentNode) {
		// SKRIV DIN KODE HER
		if (index >= ord.length()) {
			return currentNode.posisjoner;
		} else if (ord.charAt(index) == '?') {
			ArrayList<Integer> list = new ArrayList<Integer>();
			Iterator<String> it = currentNode.barn.keySet().iterator();
			while (it.hasNext()) {
				list.addAll(posisjoner(ord, index + 1,
						(Node3) currentNode.barn.get((String) it.next())));
			}
			return list;
		} else if (currentNode.barn.containsKey(String.valueOf(ord
				.charAt(index)))) {
			return posisjoner(ord, index + 1,
					(Node3) currentNode.barn.get((String.valueOf(ord
							.charAt(index)))));
		}
		return new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		try {
			BufferedReader in;
			if (args.length > 0) {
				try {
					in = new BufferedReader(new FileReader(args[0]));
				} catch (FileNotFoundException e) {
					System.out.println("Kunne ikke åpne filen " + args[0]);
					return;
				}
			} else {
				in = new BufferedReader(new InputStreamReader(System.in));

				// try {
				// in =
				// new BufferedReader(
				// new FileReader(
				// "/Users/junjun/Dropbox/ntnu2014/algoritmerDatastrukturer/TDT4120/src/tdt4120/ordbokInput.txt"));
				// } catch (FileNotFoundException e) {
				// System.out.println("Kunne ikke åpne filen ");
				// return;
				// }//
			}
			StringTokenizer st = new StringTokenizer(in.readLine());
			String[] ord = new String[st.countTokens()];
			int i = 0;
			while (st.hasMoreTokens())
				ord[i++] = st.nextToken();
			Node3 rotNode = bygg(ord);
			String sokeord = in.readLine();
			while (sokeord != null) {
				sokeord = sokeord.trim();
				System.out.print(sokeord + ":");
				ArrayList<Integer> pos = posisjoner(sokeord, 0, rotNode);
				int[] posi = new int[pos.size()];
				for (i = 0; i < posi.length; i++)
					posi[i] = ((Integer) pos.get(i)).intValue();
				Arrays.sort(posi);
				for (i = 0; i < posi.length; i++)
					System.out.print(" " + posi[i]);
				System.out.println();
				sokeord = in.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Node3 {
	public ArrayList<Integer> posisjoner;
	public HashMap<String, Node3> barn;

	public Node3() {
		posisjoner = new ArrayList<Integer>();
		barn = new HashMap<String, Node3>();
	}
}