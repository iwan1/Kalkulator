package kalkulator;

import java.util.ArrayList;

public class Kalkulator {
	
	//Pola
	private ArrayList<String> symbole;
	private ArrayList<Double> liczby;
	private double wynik;
	
	//Konstruktory
	public Kalkulator(ArrayList<String> symbole, ArrayList<Double> liczby){
		this.symbole = symbole;
		this.liczby = liczby;
	}
	
	//Metody
	public double obliczanie(){
		for(int i = 0; i < symbole.size(); i++){
			if(symbole.get(i).equals("*")){
				liczby.set(i, liczby.get(i) * liczby.get(i+1));
				liczby.remove(i+1);
				symbole.remove(i);
				i--;
			}	
			else if( symbole.get(i).equals("/")){
				liczby.set(i, liczby.get(i) / liczby.get(i+1));
				liczby.remove(i+1);
				symbole.remove(i);
				i--;
			}
		}
		for(int i = 0; i < symbole.size(); i++){
			if(symbole.get(i).equals("+")){
				liczby.set(i, liczby.get(i) + liczby.get(i+1));
				liczby.remove(i+1);
				symbole.remove(i);
				i--;
			}					
			else{
				liczby.set(i, liczby.get(i) - liczby.get(i+1));
				liczby.remove(i+1);
				symbole.remove(i);
				i--;
			}
		}
		wynik = liczby.get(0);
		return wynik;
	}
	
}
