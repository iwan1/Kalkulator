package kalkulator;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;

public class Wczytywanie {
	
	//Pola
	private String lancuch;
	private StringTokenizer dzieltekst;
	private ArrayList<String> symbole;
	private ArrayList<Double> liczby;
	private Scanner odczyt;

	//Konstruktory
	public Wczytywanie(){
		symbole = new ArrayList<String>();
		liczby = new ArrayList<Double>();
		System.out.println("Prosze podac dzialanie:");
		odczyt = new Scanner(System.in);
		lancuch = odczyt.nextLine();
	}
	
	public Wczytywanie(Scanner odczytPliku){
		symbole = new ArrayList<String>();
		liczby = new ArrayList<Double>();
		odczyt = odczytPliku;
		lancuch = odczyt.nextLine();
	}

	//Metody
	public boolean podzielTekst(){
		dzieltekst = new StringTokenizer(lancuch, "+-*/", true);
		boolean pierwszaujemna = false;
		for(int i = 0;dzieltekst.hasMoreTokens(); i++) {
			String pom = new String();
			pom = dzieltekst.nextToken();
			
			if(StringUtils.isNumeric(pom) && i%2 == 0){
				liczby.add(Double.parseDouble(pom));
				if(i == 0 && pierwszaujemna){
					liczby.set(i, liczby.get(i) * -1);
					pierwszaujemna = false;
				}/*
				else if (i = 0 && pierwszaujemna){
					liczby.set(i, liczby.get(i) * -1);
					pierwszaujemna = false;
				}*/
			}
			else if ((pom.equals("+") || pom.equals("-") || pom.equals("*") || pom.equals("/")) && i%2 != 0){
				symbole.add(pom);
			}
			else if(pom.equals("-") && i == 0){
				pierwszaujemna = true;
				i--;
			}
			else if(pom.equals("-") && i%2 != 0){
				pierwszaujemna = true;
				i--;
			}
			else{
				System.out.println(pom);
				System.out.println("Niepoprawne rownanie!");
				return false;
			}			
		}
		return true;
	}
	
	public void wypisanie(){
		System.out.println("Wypisanie znakow:");
		for(int i = 0; symbole.size() > i; i++){
			System.out.println(i + ". " + symbole.get(i));
		}
		System.out.println("Wypisanie liczb:");
		for(int i = 0; liczby.size() > i; i++){
			System.out.println(i + ". " + liczby.get(i));
		}
	}
	public void wypisz(){
	System.out.println();	
		for(int i = 0 ; i < symbole.size() ; i++){
			System.out.printf("%.0f%s", liczby.get(i), symbole.get(i));
		}
		System.out.printf("%.0f=",liczby.get(symbole.size()));
		
	}
	//Gettery i settery
	public ArrayList<String> getSymbole() {
		return symbole;
	}

	public ArrayList<Double> getLiczby() {
		return liczby;
	}

	public String getLancuch(){
		return lancuch;
	}
	
	
	public void setSymbole(ArrayList<String> symbole) {
		this.symbole = symbole;
	}

	public void setLiczby(ArrayList<Double> liczby) {
		this.liczby = liczby;
	}
	
	
}
