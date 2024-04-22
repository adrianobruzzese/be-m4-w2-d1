package m4.w2.d1;

public class ContoCorrente {
	// Nome del titolare del conto
	private String titolare;

	// Numero di movimenti effettuati sul conto
	private int nMovimenti;

	// Numero massimo di movimenti consentiti
	private final int maxMovimenti = 50;

	// Saldo attuale del conto
	private double saldo;

	/**
	 * Costruttore della classe ContoCorrente.
	 */
	public ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		this.nMovimenti = 0;
	}

	public void preleva(double importo) throws BancaException {
		if (nMovimenti < maxMovimenti) {
			saldo -= importo;
		} else {
			saldo -= importo + 0.5; // Commissione per il superamento del numero massimo di movimenti
		}

		if (saldo < 0) {
			throw new BancaException("Il conto è in rosso.");
		}

		nMovimenti++;
	}

	/**
	 * Metodo per consultare il saldo del conto.
	 *
	 * @return Il saldo attuale del conto.
	 */
	public double restituisciSaldo() {
		return saldo;
	}
}
