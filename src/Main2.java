package m4.w2.d1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Inserire i chilometri percorsi: ");
			int kmPercorsi = scanner.nextInt();

			System.out.print("Inserire i litri di benzina consumati: ");
			double litriConsumati = scanner.nextDouble();

			if (litriConsumati == 0) {
				throw new ArithmeticException("Impossibile dividere per zero!");
			}

			double kmLitro = kmPercorsi / litriConsumati;
			System.out.printf("L'auto percorre %.2f km al litro\n", kmLitro);

		} catch (InputMismatchException e) {
			System.out.println("Errore: valore inserito non valido. Inserisci un numero intero per i km e un numero decimale positivo per i litri.");
			scanner.next(); // Svuota lo scanner per il prossimo input
		} catch (ArithmeticException e) {
			System.out.println("Impossibile che la tua macchina non consumi carburante, controlla i litri inseriti.");
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
