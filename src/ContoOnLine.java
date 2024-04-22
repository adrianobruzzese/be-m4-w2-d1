package m4.w2.d1;

public class ContoOnLine extends ContoCorrente {
	// Importo massimo prelevabile dal conto online
	private double maxPrelievo;

	/**
	 * Costruttore della classe ContoOnline.
	 *
	 * @param titolare Il nome del titolare del conto.
	 * @param saldo Il saldo iniziale del conto.
	 * @param maxPrelievo L'importo massimo prelevabile dal conto.
	 */
	public ContoOnLine(String titolare, double saldo, double maxPrelievo) {
		super(titolare, saldo);
		this.maxPrelievo = maxPrelievo;
	}

	/**
	 * Metodo per stampare le informazioni del conto online.
	 */
	public void stampaSaldo() {
		System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
				+ " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
	}

	/**
	 * Metodo per prelevare denaro dal conto online.
	 *
	 * @param importo L'ammontare da prelevare.
	 * @throws BancaException Se il prelievo non è possibile a causa di un superamento del limite massimo di prelievo.
	 */
	@Override
	public void preleva(double importo) throws BancaException {
		if (importo <= maxPrelievo) {
			super.preleva(importo); // Effettua il prelievo utilizzando il metodo predefinito della classe ContoCorrente
		} else {
			throw new BancaException("Il prelievo non è disponibile. Il limite massimo è di: " + maxPrelievo);
		}
	}
}
