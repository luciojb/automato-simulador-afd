package classes;

import java.util.Arrays;
import java.util.HashMap;

public class AFD_HashMap {
	private HashMap<String,String> map;
	private String[] alphabet, finals;
	public int position;
	
	public AFD_HashMap(HashMap<String,String> map, String[] alphabet, String[] finals){
		this.map = map;
		this.alphabet = alphabet;
		this.finals = finals;
	}
	
	public String move(String state, String caracter) throws Exception{
		if(Arrays.asList(alphabet).contains(String.valueOf(caracter))){
			state+=caracter;
			if(map.containsKey(state)){
				state = map.get(state);
			} else 
				throw new Exception("Encontrado erro em transição com estado "+state+" e caracter "+caracter);
		} else 
			throw new Exception("Caractere '"+caracter+"': não definido no alfabeto de entrada!");
		position++;
		return state.substring(0, state.length());
	}
	
	public String isValid(String s){
		return Arrays.asList(finals).contains(s)?"Entrada válida":"Entrada inválida";
	}
}
