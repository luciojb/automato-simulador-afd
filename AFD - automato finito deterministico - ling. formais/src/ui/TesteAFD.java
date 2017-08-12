package ui;

import java.util.Scanner;
import classes.AFD;

/**
 * @author Lúcio José Beirão
 * Simulador de um autômato finito deteminístico 
 * que valida uma cadeia de caracteres de acordo com uma matriz 
 * de programação do autômato, com os estados e as respectivas entradas
 */
public class TesteAFD {

	public static void main(String[] args) {
		AFD afd = new AFD();
		
		afd.inicializaAFD(
				new String[][]{
					{"estados/entradas", "0", "1"},
					{"a"               , "b", "b"},
					{"b"               , "c", "c"},
					{"c"               , "d", "c"},
					{"d"               , "d", "d"}
				},
				new String[]{
						"d"
				}
		);		
		
		Scanner read = new Scanner(System.in);
		String entrada = "";
		
		System.out.println("Digite os caracteres da palavra: ");
		entrada = read.next();
		read.close();

		afd.inicializaEntrada(entrada);
		
		try{
			while(afd.posicaoAtual<afd.palavra.length()){
				afd.mover(afd.estadoAtual, afd.palavra.charAt(afd.posicaoAtual));
			}
			System.out.println(afd.isValidEntry());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
