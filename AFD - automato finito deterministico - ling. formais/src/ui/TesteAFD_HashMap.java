package ui;

import java.util.HashMap;
import java.util.Scanner;

import classes.AFD_HashMap;

public class TesteAFD_HashMap {

	public static void main(String[] args) throws Exception {
		HashMap<String, String> stateToNext = new HashMap<>();
		
		
		//Poderia passar uma matriz com estados, e usando for concatenar depois com a transição
		stateToNext.put("q0a", "q1");
		stateToNext.put("q0b", "q0");
		stateToNext.put("q1a", "q1");
		stateToNext.put("q1b", "q2");
		stateToNext.put("q2a", "q1");
		stateToNext.put("q2b", "q3");
		stateToNext.put("q3a", "q1");
		stateToNext.put("q3b", "q0");
		
		String [] entries = {"a","b"}, finals = {"q3"};
		String start = "q0";
		
		Scanner read = new Scanner(System.in);
		String entrada = "";
		
		System.out.println("Digite os caracteres da palavra: ");
		entrada = read.next();
		read.close();
		AFD_HashMap afd = new AFD_HashMap(stateToNext, entries, finals);
		String s = "";
		try{
			s=start;
			while(afd.position<entrada.length()){
				s = afd.move(s, String.valueOf(entrada.charAt(afd.position)));
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println(afd.isValid(s));
	}

}
