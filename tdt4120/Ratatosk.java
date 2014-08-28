package tdt4120;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ratatosk {

	/**
	 * Denne metoden skal gjøre et bredde-først-søk i treet. Den skal returnere
	 * dybden til ratatosk-noden.
	 * 
	 * @param rot
	 *            - rotnoden i treet
	 *
	 * @return dybden til ratatosknoden
	 *
	 *         Rotnoden er på dybde 0. DFS kan enten implementeres ved hjelp av
	 *         en stakk eller med rekursjon, men i denne øvingen skal du bruke
	 *         en stakk
	 */
	public static int bfs(Node rot) {
		// SKRIV DIN KODE HER
		Queue<Node> queue = new LinkedList<>();// use queue for bfs
		rot.dybde = 0;
		queue.add(rot);
		while (queue.size() != 0) {
			Node aNode = queue.poll();
			System.out.println("dybd: " + aNode.dybde);
			if (aNode.ratatosk) {
				return aNode.dybde;
			}
			if (aNode.barn.size() > 0) {
				for (int i = 0; i < aNode.barn.size(); i++) {
					Node theNode = (Node) aNode.barn.get(i);
					theNode.dybde = aNode.dybde + 1;
					queue.add(theNode);
				}
			}
		}
		return -1;
	}

	/**
	 * Denne metoden skal gjøre et dybde-først-søk i treet vha. en stack. Den
	 * skal returnere dybden til ratatosk-noden.
	 * 
	 * @param rot
	 *            - rotnoden i treet
	 *
	 * @return dybden til ratatosknoden
	 *
	 *         Rotnoden er på dybde 0. DFS kan enten implementeres ved hjelp av
	 *         en stakk eller med rekursjon, men i denne øvingen skal du bruke
	 *         en stakk
	 */
	public static int dfs(Node rot) {
		// SKRIV DIN KODE HER
		Stack<Node> stack = new Stack<Node>();// use stack for dfs
		rot.dybde = 0;// set rot dybde to 0
		stack.add(rot);
		// int result = 0;
		while (stack.size() != 0) {
			Node newNode = stack.pop();
			System.out.println("dybe: " + newNode.dybde);
			if (newNode.ratatosk) {
				return newNode.dybde;
				// result = newNode.dybde;
			}
			if (newNode.barn.size() > 0) {// last node first into stack
				for (int i = newNode.barn.size() - 1; i >= 0; i--) {
					Node node = (Node) newNode.barn.get(i);
					node.dybde = newNode.dybde + 1;
					stack.add(node);
				}
			}
		}
		return -1;
		// return result;
	}

	/**
	 * Main-metoden som leser inn inputdataene fra stdin og kaller den metoden
	 * man må. Dersom input sier velg
	 */
	public static void main(String args[]) {
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
				// in = new BufferedReader(
				// new FileReader(
				// "/Users/junjun/Dropbox/ntnu2014/algoritmerDatastrukturer/TDT4120/src/tdt4120/Ratatosk.txt"));
				// } catch (FileNotFoundException e) {
				// System.out.println("Kunne ikke åpne filen ");
				// return;
				// }//
			}
			String funksjon = in.readLine().trim();
			int antallNoder = Integer.parseInt(in.readLine());
			ArrayList noder = new ArrayList();
			// N: lage en tom list med antall noder :10
			for (int i = 0; i < antallNoder; i++) {
				noder.add(new Node());
			}
			Node rotNode = (Node) noder.get(Integer.parseInt(in.readLine()));// root:0
			// setter ratatosknode: 7
			((Node) noder.get(Integer.parseInt(in.readLine()))).ratatosk = true;
			String linje = in.readLine();// begynne lese træ
			while (linje != null) {
				StringTokenizer st = new StringTokenizer(linje);
				Node currentNode = (Node) noder.get(Integer.parseInt(st
						.nextToken()));
				while (st.hasMoreTokens()) {
					currentNode.barn.add(noder.get(Integer.parseInt(st
							.nextToken())));
				}
				linje = in.readLine();
			}
			if (funksjon.equals("dfs")) {
				System.out.println("" + dfs(rotNode));
			} else if (funksjon.equals("bfs")) {
				System.out.println("" + bfs(rotNode));
			} else if (funksjon.equals("velg")) {
				System.out.println("write search method: dfs or bfs");
				Scanner sc = new Scanner(System.in);
				String searchMethod = sc.next();
				sc.close();
				if (searchMethod.equalsIgnoreCase("dfs")) {
					System.out.println("" + dfs(rotNode));
				} else if (searchMethod.equalsIgnoreCase("bfs")) {
					System.out.println("" + bfs(rotNode));
				} else {
					System.out
							.println("Can not do " + searchMethod + " search");
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}

class Node {
	boolean ratatosk;
	ArrayList barn;
	// Denne kan du velge om du vil ha med eller ikke. Det er meningen at den
	// skal representere
	// dybden denne noden har i treet, og at det skal regnes ut underveis i din
	// algoritme.
	// (Du kan selvfølgelig droppe å bruke hele rammeverket)
	int dybde;

	public Node() {
		ratatosk = false;
		barn = new ArrayList();
		dybde = -1;
	}
}