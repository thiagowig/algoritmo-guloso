package model;

/**
 * Representa um item da mochila
 */
public class Item {

	private final String nome;

	private final int peso;

	private final int caloria;
	
	/**
	 * Inicializa os atributos do item
	 */
	public Item(String nome, int peso, int caloria) {
		this.nome = nome;
		this.peso = peso;
		this.caloria = caloria;
	}

	/**
	 * Retorna a densidade (caloria / peso)
	 */
	public double getDensidade() {
		return caloria / peso;
	}
	
	public String getNome() {
		return nome;
	}

	public int getPeso() {
		return peso;
	}

	public int getCaloria() {
		return caloria;
	}
	
}
