package tdt4120;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 
 * 25. aug. 2014
 * 
 * @author GuoJunjun
 * 
 *         Oppgave
 * 
 *         Du skal lære å traversere (se på alle elementene) en lenket liste. I
 *         det utleverte rammeverket er det skrevet kode for å lage en lenket
 *         liste. Det viktige i denne øvingen er å forstå hvordan du kan lenke
 *         sammen elementer ved hjelp av referanser. Dette er veldig vanlig i
 *         objektorientert programmering. Trikset når du lager en lenket liste,
 *         er å koble sammen flere objekter av samme klasse, slik at hvert
 *         objekt har en referanse (lenke) til ett annet objekt (det 'neste'
 *         objektet'). Hvis du så et eller annet sted tar vare på en referanse
 *         til det første objektet i lenkingen (det eneste objektet som ikke
 *         blir lenket til av noen andre objekter), har du et utgangspunkt for å
 *         traverse hele listen av objekter.
 * 
 *         Input består av heltall separert av linjeskift. Programmet ditt skal
 *         legge inn disse i en lenket liste, traversere den lenkete listen, og
 *         skrive ut det høyeste tallet. Du kan tenke på tallene som vekter på
 *         dynamittkubber og lenkene du lager mellom kubbene som lunter koblet
 *         sammen.
 */
public class Sprengstoff {

	private static int spor(Kubbe kubbe) {
		// SKRIV DIN KODE HER
		int maks = -1;
		while (kubbe != null) {
			if (kubbe.vekt > maks)
				maks = kubbe.vekt;
			kubbe = kubbe.neste;
		}
		return maks;
	}

	public static void main(String args[]) {
		BufferedReader in;
		if (args.length > 0) {
			try {
				in = new BufferedReader(new FileReader(args[0]));
			} catch (FileNotFoundException e) {
				System.out.println("Kunne ikke åpne filen " + args[0]);
				return;
			}
		} else {
			// in = new BufferedReader(new InputStreamReader(System.in));
			try {
				in = new BufferedReader(
						new FileReader(
								"/Users/junjun/Dropbox/ntnu2014/algoritmerDatastrukturer/TDT4120/src/tdt4120/sprengstoff.txt"));
			} catch (FileNotFoundException e) {
				System.out.println("Kunne ikke åpne filen ");
				return;
			}

		}
		try {
			Kubbe forste = null, siste = null, forrige_siste = null;
			String linje = in.readLine();
			while (linje != null) {
				forrige_siste = siste;
				int i = Integer.parseInt(linje);
				siste = new Kubbe(i);
				if (forste == null)
					forste = siste;
				else
					forrige_siste.neste = siste;
				linje = in.readLine();
				System.out.println("ført " + forste.toString()
						+ " forrige_sist " + forrige_siste + " siste "
						+ siste.toString());
				//
				Kubbe newKubbe = forste.neste;
				Kubbe newforrige = forrige_siste;
				String forsteneste = "forste";
				String forrige = "forrige";
				while (newKubbe != null) {
					forsteneste += ".neste";
					System.out
							.println(forsteneste + ": " + newKubbe.toString());
					newKubbe = newKubbe.neste;
				}
				while (newforrige != null) {
					forrige += ".neste";
					System.out.println(forrige + ": " + newforrige.toString());
					newforrige = newforrige.neste;
				}
			}
			System.out.println(spor(forste));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Kubbe {
	int vekt;
	Kubbe neste;

	public Kubbe(int vekt) {
		this.vekt = vekt;
	}

	public String toString() {
		return "vekt: " + vekt;
	}
}
