package m4.w2.d1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numeri = getRandomArray(); // Inizializza l'array

		boolean continua = true;
		while (continua) {  // Ciclo di modifica dell'array
			stampaArray(numeri);

			System.out.println("\nInserire un numero da inserire nell'array (0 per uscire): ");
			try {
				int numeroDaInserire = scanner.nextInt();

				if (numeroDaInserire == 0) {
					continua = false;
				} else {
					System.out.println("Inserire la posizione dove inserirlo: ");
					int posizione = scanner.nextInt();
					inserisciValore(numeri, posizione, numeroDaInserire);
				}
			} catch (InputMismatchException e) {
				System.out.println("Errore: valore inserito non valido. Inserisci un numero intero.");
				scanner.next(); // Svuota lo scanner per permettere il prossimo inserimento
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Errore: posizione fuori dai limiti dell'array.");
			}
		}
		scanner.close();
	}

	private static int[] getRandomArray() {
		int[] array = new int[5];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(1, 11); // Numeri da 1 a 10 (inclusi)
		}
		return array;
	}

	private static void stampaArray(int[] array) {
		System.out.println("\nArray:");
		for (int numero : array) {  // Stampa efficiente con il ciclo for-each
			System.out.print(numero + " ");
		}
	}

	private static void inserisciValore(int[] array, int posizione, int numero) {
		if (posizione >= 0 && posizione < array.length) { // Verifica che la posizione sia valida
			array[posizione] = numero;
		} else {
			throw new ArrayIndexOutOfBoundsException("Posizione non valida");
		}
	}
}
