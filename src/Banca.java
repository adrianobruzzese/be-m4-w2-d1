package m4.w2.d1;

public class Banca {
	public static void main(String[] args) {
		// Creo un nuovo conto corrente per Adriano Bruzzese con un saldo iniziale di 20.000€
		ContoCorrente conto1 = new ContoCorrente("Adriano Bruzzese", 20000.0);

		// Stampo il saldo iniziale del conto
		System.out.println("Saldo conto Adriano Bruzzese: " + conto1.restituisciSaldo());

		// Provo a prelevare 1.750,50€ dal conto
		try {
			conto1.preleva(1750.5);

			// Se il prelievo ha avuto successo, stampo il nuovo saldo
			System.out.println("Saldo conto Adriano Bruzzese dopo prelievo: " + conto1.restituisciSaldo());
		} catch (BancaException e) {
			// Se il prelievo ha fallito, gestisco l'eccezione
			System.out.println("❗ Errore durante il prelievo per Adriano Bruzzese: " + e.getMessage());
			// Stampo il messaggio di errore e lo stack trace (facoltativo)
			e.printStackTrace();
		}

		// Creo un nuovo conto online per Adriana Bruzzese con un saldo iniziale di 50.350€ e un limite di prelievo di 1.500€
		ContoOnLine conto2 = new ContoOnLine("Adriana Bruzzese", 50350.0, 1500);

		// Stampo le informazioni del conto online
		conto2.stampaSaldo();

		// Provo a prelevare 1.500€ dal conto online
		try {
			conto2.preleva(1500);

			// Se il prelievo ha avuto successo, stampo il nuovo saldo
			System.out.println("Saldo conto online Adriana Bruzzese dopo prelievo: " + conto2.restituisciSaldo());
		} catch (BancaException e) {
			// Se il prelievo ha fallito, gestisco l'eccezione
			System.out.println("❗ Errore durante il prelievo per Adriana Bruzzese (conto online): " + e.getMessage());
			// Stampo il messaggio di errore e lo stack trace (facoltativo)
			e.printStackTrace();
		}
	}
}
