package mobili;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {
			System.out.println("Scegli una delle seguenti opzioni:");
			System.out.println("-----------------------------------");

			while (true) {
				try {
					System.out.println("1.Aggiungi mobile");
					System.out.println("2.Visualizza mobili");
					System.out.println("3.Modifica mobile");
					System.out.println("4.Elimina mobile");
					System.out.println("5.Aggiungi ordine");
					System.out.println("6.Visualizza ordini");
					System.out.println("0.Esci dal programma");
					int opzioneScelta = scanner.nextInt();

					switch (opzioneScelta) {
					case 1: {
						System.out.println("Inserisci il nome del mobile");
						String nomeMobile = scanner.next();
						scanner.nextLine();
						System.out.println("Inserisci il prezzo del mobile");
						double prezzoMobile = scanner.nextDouble();
						if (prezzoMobile > 0) {
							MobiliCRUD.aggiungiMobile(nomeMobile, prezzoMobile);
							System.out.println("-----------------------------------");
							break;
						} else {
							System.out.println("Il prezzo deve essere maggiore di zero. Riprova..");
							System.out.println("-----------------------------------");
							break;
						}
					}
					case 2: {
						MobiliCRUD.visualizzaMobili();
						System.out.println("-----------------------------------");
						break;
					}
					case 3: {
						System.out.println("Inserisci l'id del mobile da modificare");
						int id = scanner.nextInt();
						System.out.println("Inserisci il nuovo nome del mobile");
						String nuovoNomeMobile = scanner.next();
						scanner.nextLine();
						System.out.println("Inserisci il nuovo prezzo del mobile");
						double nuovoPrezzoMobile = scanner.nextDouble();
						if (nuovoPrezzoMobile > 0) {
							MobiliCRUD.modificaMobile(nuovoNomeMobile, nuovoPrezzoMobile, id);
							System.out.println("-----------------------------------");
							break;
						} else {
							System.out.println("Il prezzo deve essere maggiore di zero. Riprova..");
							System.out.println("-----------------------------------");
							break;
						}
					}
					case 4: {
						System.out.println("Inserisci l'id del mobile da eliminare");
						int id = scanner.nextInt();
						MobiliCRUD.eliminaMobile(id);
						System.out.println("-----------------------------------");
						break;
					}
					case 5: {
						System.out.println("Inserisci l'username del cliente");
						String usernameCliente = scanner.next();
						scanner.nextLine();
						System.out.println("Inserisci l'id del mobile ordinato");
						int idMobile = scanner.nextInt();
						System.out.println("Inserisci la quantita");
						int quantita = scanner.nextInt();
						if (quantita > 0) {
							Ordini.aggiungiOrdine(usernameCliente, idMobile, quantita);
							System.out.println("-----------------------------------");
							break;
						} else {
							System.out.println("La quantità deve essere maggiore di zero. Riprova..");
							System.out.println("-----------------------------------");
							break;
						}
					}
					case 6: {
						Ordini.visualizzaOrdini();
						System.out.println("-----------------------------------");
						break;
					}
					case 0: {
						System.out.println("Programma terminato!");
						return;
					}
					default:
						System.out.println("Opzione non presente. Riprova..");
						System.out.println("-----------------------------------");
					}

				} catch (InputMismatchException e) {
					System.out.println(
							"Inserisci un numero intero per opzioni, id e quantità. Usa il punto per i decimali(prezzo). Riprova..");
					System.out.println("-----------------------------------");
					scanner.nextLine();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}

}
