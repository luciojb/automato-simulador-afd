package classes;

import java.util.Arrays;

/**
 * @author Lúcio José Beirão
 */
public class AFD {
	private String[][] matriz;
	private final int LINHA_INICIAL = 1, ESTADO = 0, LINHA_ENTRADAS=0, INICIO_ENTRADAS=1;
	public int posicoesEntrada;
	public int posicaoAtual=0;
	public String palavra;
	public String estadoAtual;
	public String[] finalArray;
	
	/**
	 * Move a posição de verificação do caracter para o próximo se existir o estado. 
	 * Caso a palavra contenha um caractere inválido, não definido como alfabeto de entrada,
	 * será lançada uma exceção, com uma mensagem
	 * @param estado, o estado atual
	 * @param caracter, o caracter da proxima posição setada na variável posicaoAtual
	 * @throws Exception, a exceção com a mensagem retornando o caractere não definido
	 */
	public void mover(String estado, char caracter) throws Exception{
		if (Arrays.asList(this.matriz[LINHA_ENTRADAS]).contains(String.valueOf(caracter))){
			for(int i =0; i < this.matriz.length; i++){
				if(this.matriz[i][this.ESTADO].equals(this.estadoAtual)){
					for(int j=this.INICIO_ENTRADAS; j<this.posicoesEntrada; j++){
						if(this.matriz[this.LINHA_ENTRADAS][j].equals(String.valueOf(palavra.charAt(this.posicaoAtual)))){
							this.estadoAtual = this.matriz[i][j];
							break;
						}
					}
					break;
				}
			}
			this.posicaoAtual++;
		} else {
			throw new Exception("Caractere '"+caracter+"': não definido no alfabeto de entrada!");
		}
	}
	
	/**
	 * Inicializa os atributos principais da classe, verificando também quais as posições de entrada para usar no método mover
	 * @param matriz, a matriz programada com os estados e as entradas
	 * @param finalArray, o array com a lista de estados de finalização
	 */
	public void inicializaAFD(String[][] matriz, String[] finalArray){
		this.matriz = matriz;
		this.finalArray = finalArray; 
		this.estadoAtual = this.matriz[this.LINHA_INICIAL][this.ESTADO];
		this.posicoesEntrada =  this.matriz[this.LINHA_ENTRADAS].length;
	}
	
	/**
	 * @param entrada, a palavra a ser validada
	 */
	public void inicializaEntrada(String entrada){
		this.palavra = entrada;
	}
	
	/**
	 * Verifica se o estado atual está contido na lista de  estados de "Halt", ou finais. 
	 * @return {@link String} r, a mensagem se a palavra é válida ou não
	 */
	public String isValidEntry(){
		String r = "A palavra é inválida!";
		if(Arrays.asList(this.finalArray).contains(this.estadoAtual)){
			r = "A palavra é válida!";
		}
		return r;
	}
	
}
