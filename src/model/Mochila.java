package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Objeto que representa a mochila.
 */
public class Mochila {

	private final String FORMATO_MENSAGEM = "Nome: %s. Peso: %s. Caloria: %s. Densidade: %s.\n";
	
	private final Integer pesoMaximo;
	
	private Integer pesoAtual;
	
	private List<Item> itens;
	
	/**
	 * Inicializa os atributos da mochila.
	 */
	public Mochila(Integer pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
		this.itens = new ArrayList<Item>();
		this.pesoAtual = 0;
	}
	
	/**
	 * Adiciona um item na mochila.
	 */
	public boolean adicionarItem(Item item) {
		if (validarInsercaoItem(item)) {
			pesoAtual += item.getPeso();
			this.itens.add(item);
			
			return true;
		}
		
		return false;
	}

	/**
	 * Valida se o item pode ser adicionado à mochila, ou seja, não ultrapassa o valor máximo permitido.
	 */
	private boolean validarInsercaoItem(Item item) {
		return item.getPeso() + pesoAtual <= pesoMaximo;
	}
	
	/**
	 * Limpa os itens da mochila.
	 */
	public void limparItens() {
		this.itens.clear();
		this.pesoAtual = 0;
	}
	
	/**
	 * Exibe os itens que constam na mochila.
	 */
	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("ALGORITMO GULOSO\n\n");
		
		for (Item item : itens) {
			resultado.append(String.format(FORMATO_MENSAGEM, item.getNome(), item.getPeso(), item.getCaloria(), item.getDensidade()));
		}
		
		return resultado.toString();
	}

}
