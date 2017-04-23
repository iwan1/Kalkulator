package kalkulator;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Wczytywanie menuObiczanie;
		System.out.println("Menu:");
		System.out.println("1. Obliczenia");
		System.out.println("2. Czytanie z pliku");
		System.out.println("3. Koniec");
		Scanner odczyt = new Scanner(System.in);
		String wybor = "0";
		while(!wybor.equals("3")){
			wybor = odczyt.nextLine();
			switch(wybor){
			case "1":
				System.out.println("Wpisanie end konczy obliczanie.");
				menuObiczanie = new Wczytywanie();

				while(!menuObiczanie.getLancuch().equals("end")){
					if(!menuObiczanie.podzielTekst()){
						break;
					}
					
					menuObiczanie.wypisz();
					Kalkulator dzialanie = new Kalkulator(menuObiczanie.getSymbole(), menuObiczanie.getLiczby());
					System.out.printf("%.0f",dzialanie.obliczanie());
					System.out.println("\n\nWpisanie end konczy wpisywanie.");
					menuObiczanie = new Wczytywanie();
				}
				System.out.println("Menu:");
				System.out.println("1. Obliczenia");
				System.out.println("2. Czytanie z pliku");
				System.out.println("3. Koniec");
				break;
			case "2":
				File plik = new File("rownanie.txt");
				Scanner odczytPliku = new Scanner(plik);
				menuObiczanie = new Wczytywanie(odczytPliku);
				menuObiczanie.podzielTekst();
				menuObiczanie.wypisz();
				Kalkulator dzialanie = new Kalkulator(menuObiczanie.getSymbole(), menuObiczanie.getLiczby());
				System.out.printf("%.0f",dzialanie.obliczanie());
				System.out.println("\nWcisnij Enter.\n");
				break;
			case "3":
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nKoniec programu.");
				return;
			default:
				System.out.println("Menu:");
				System.out.println("1. Obliczenia");
				System.out.println("2. Czytanie z pliku");
				System.out.println("3. Koniec");
			}
		}
	}
}
