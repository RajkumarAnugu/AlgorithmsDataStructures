package tdt4120;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 
 * I denne oppgaven skal du finne en subgraf i en større graf,
 * og finne tettheten i denne. For å finne subgrafen,
 * må hele grafen traverseres.
 * Du kan bruke dybde- eller bredde-først-søk for å traversere,
 * slik som i øvingen med traversering av tre.
 * Forskjellen fra tretraversering er at du må merke de nodene du besøker,
 * slik at du unngår å gå i sykel.
 * Subgrafen du skal finne er den delen av grafen som ikke kan nåes fra en gitt
 * node.
 *
 */
public class Prinsessejakt {

	public static BigDecimal subgraftetthet(boolean[][] nabomatrise,
			int startnode) {
		// SKRIV DIN KODE HER
		int n = nabomatrise.length; // 6: 6*6
		int antallNoderMed = n - 1;
		// alle er med
		boolean[] med = new boolean[n];
		for (int i = 0; i < n; i++) {
			med[i] = true;
		}
		ArrayList<Integer> ko = new ArrayList<Integer>();
		med[startnode] = false;
		ko.add(new Integer(startnode));
		// System.out.println(ko);
		int currentIndex = 0;
		while (currentIndex != ko.size()) {
			int currentNode = ko.get(currentIndex++);
			for (int j = 0; j < n; j++) {
				if (nabomatrise[currentNode][j] && med[j]) {
					// mark besøket node
					med[j] = false;
					antallNoderMed--;
					ko.add(new Integer(j));
				}
			}
		}
		/**
		 * tettheten T som:
		 * 
		 * T = E / V2 hvis V > 0,
		 * 0 hvis V = 0
		 */
		if (antallNoderMed == 0) {
			return new BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_UP);
		}
		int antallKanter = 0;
		for (int i = 0; i < n; i++) {
			if (med[i]) {
				for (int j = 0; j < n; j++) {
					if (nabomatrise[i][j] && med[j]) {
						antallKanter++;
					}
				}
			}
		}
		// System.out.println(antallKanter + " / " + antallNoderMed);

		/**
		 * Tettheten i en graf er et tall på hvor sammenknyttet den er.
		 * Tettheten i en graf kan være nyttig informasjon hvis en skal kjøre
		 * algoritmer på grafen. Gitt et problem, har man ofte flere
		 * forskjellige algoritmer og implementasjoner å velge mellom. Et
		 * eksempel på dette er å finne minimum spenntre med Prims algoritme (se
		 * Cormen side 570). Hvis en representerer grafen som en nabomatrise, er
		 * kjøretiden O(V2), der V er antall noder (vertices). Hvis vi
		 * representerer grafen med nabolister, og implementerer køen ved hjelp
		 * av en heap, blir kjøretiden O(E log V), der E er antall kanter
		 * (edges).
		 * 
		 * OBS: E og V er som regel definert som mengdene med kanter og noder,
		 * og da brukes |E| og |V| for å angi antall. E og V brukes ofte som
		 * antall i mindre formelle sammenhenger, fordi det er mer leselig uten
		 * |.
		 * 
		 * 
		 * Vi definerer tettheten T som:
		 * 
		 * T = E / V*V hvis V > 0,
		 * 0 hvis V = 0
		 * 
		 * Programmet ditt skal skrive ut T. I senere øvinger kan det være lurt
		 * å bruke T til å avgjøre om grafen er "dense" (den har høy tetthet)
		 * eller "sparse" (lav tetthet). Dersom T > log V er grafen "dense" og
		 * dersom T < log V er grafen "sparse", sett i lys av Prims algoritme
		 * som diskutert over.
		 */
		return new BigDecimal(antallKanter).divide(new BigDecimal(
				antallNoderMed * antallNoderMed), 3, BigDecimal.ROUND_HALF_UP);
	}

	public static void main(String[] args) {
		try {
			BufferedReader in;
			if (args.length > 0) {
				in = new BufferedReader(new FileReader(args[0]));
			} else {
				in = new BufferedReader(new InputStreamReader(System.in));

				// try {
				// in =
				// new BufferedReader(
				// new FileReader(
				// "/Users/junjun/Dropbox/ntnu2014/algoritmerDatastrukturer/TDT4120/src/tdt4120/Prinsessejakt.txt"));
				// } catch (FileNotFoundException e) {
				// System.out.println("Kunne ikke åpne filen ");
				// return;
				// }//

			}
			/**
			 * Input til programmet ditt er en nabomatrise og et sett med
			 * startnoder som definerer delgrafer. Første linje i input er
			 * antall noder V. De neste V linjene er rader i nabomatrisen til
			 * grafen. I en nabomatrise inneholder hver enkelt rad informasjon
			 * om kantene ut fra noden med samme nummer som raden. Etter
			 * nabomatrisen kommer det linjer med ett nummer på hver linje.
			 * Disse nummerne er nummerene på startnodene du skal bruke til å
			 * finne delgrafer.
			 */
			// leser først linje i denne textfil: 6
			int n = Integer.parseInt(in.readLine());
			boolean[][] nabomatrise = new boolean[n][n];
			String naboRad;
			// leser neste 6 linjer som er nabomatrise
			for (int i = 0; i < n; i++) {
				naboRad = in.readLine();
				for (int j = 0; j < n; j++)
					if (naboRad.charAt(j) == '1') nabomatrise[i][j] = true;
			}
			// leser linje nr 8: 1
			String linje = in.readLine();
			/**
			 * For hvert nummer skal du skrive ut tettheten i delgrafen du
			 * finner. Delgrafen består av de nodene som ikke kan nåes fra
			 * startnoden, og kantene mellom disse nodene. Tettheten skal
			 * skrives ut med tre desimaler.
			 */
			while (linje != null && linje.length() > 0) {
				int startnode = Integer.parseInt(linje);
				System.out.println(subgraftetthet(nabomatrise, startnode));
				// leser linje nr 9: 2
				linje = in.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
