package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

import model.Item;
import model.Mochila;

/**
 * Classe que inicia a execução do algoritmo.
 */
public class Aplicacao {
	
	private Mochila mochila;
	
	private List<Item> itens = new ArrayList<Item>();
	
	public static void main(String[] args) {
		new Aplicacao().executar();
	}
	
	/**
	 * Inicia a aplicação.
	 */
	private void executar() {
		
		while(mochila == null) {
			try {
				mochila = new Mochila(Integer.parseInt(JOptionPane.showInputDialog("ALGORITMO GULOSO\n\nInforme o tamanho máximo da mochila (em kg)")));
			} catch (Exception e) {
			}
		}
		
		while (true) {
			try {
				String valor = JOptionPane.showInputDialog("ALGORITMO GULOSO\n\n" +
						"1 - Inserir Item\n" +
						"2 - Gula por peso\n" +
						"3 - Gula por caloria\n" +
						"4 - Gula por densidade\n" +
						"5 - Limpar Lista\n" +
						"6 - Sair");
				
				if (valor == null) {
					sair();
				}
				
				Integer opcaoMenu = Integer.parseInt(valor);
				
				if (opcaoMenu.equals(1)) {
					inserirItem();
					
				} else if (opcaoMenu.equals(2) || opcaoMenu.equals(3) || opcaoMenu.equals(4)) {
					arranjarItensNaMochila(opcaoMenu);
					
				} else if (opcaoMenu.equals(5)) {
					limparLista();
					
				} else if (opcaoMenu.equals(6)) {
					sair();
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ALGORITMO GULOSO\n\nInforme o nome do item");
			}
				
		}
		
	}
	
	private void sair() {
		System.exit(0);
	}
	
	/**
	 * Insere um item na lista
	 */
	private void inserirItem() {		
		String nome = JOptionPane.showInputDialog("ALGORITMO GULOSO\n\nInforme o nome do item");
		Integer peso = Integer.parseInt(JOptionPane.showInputDialog("ALGORITMO GULOSO\n\nInforme o peso do item (em kg)"));
		Integer caloria = Integer.parseInt(JOptionPane.showInputDialog("ALGORITMO GULOSO\n\nInforme a caloria item"));
		
		Item item = new Item(nome, peso, caloria);
		itens.add(item);		
	}
	
	/**
	 * Arranja os itens no mochila e exibe o resultado.
	 */
	private void arranjarItensNaMochila(Integer opcaoMenu) {
		mochila.limparItens();
		
		if (opcaoMenu.equals(2)) {
			Collections.sort(itens, new Comparator<Item>() {
				@Override
				public int compare(Item item01, Item item02) {
					if (item01.getPeso() < item02.getPeso()) {
						return 1;
					}
					
					return -1;
				}
			});
			
		} else if (opcaoMenu.equals(3)) {
			Collections.sort(itens, new Comparator<Item>() {
				@Override
				public int compare(Item item01, Item item02) {
					if (item01.getCaloria() < item02.getCaloria()) {
						return 1;
					}
					
					return -1;
				}
			});
			
		} else if (opcaoMenu.equals(4)) {
			Collections.sort(itens, new Comparator<Item>() {
				@Override
				public int compare(Item item01, Item item02) {
					if (item01.getDensidade() < item02.getDensidade()) {
						return 1;
					}
					
					return -1;
				}
			});
		}
		
		for (Item item : itens) {
			mochila.adicionarItem(item);
		}
		
		JOptionPane.showMessageDialog(null, mochila.toString());
	}
	
	/**
	 * Limpa os itens da lista
	 */
	private void limparLista() {
		itens.clear();
		mochila.limparItens();
	}

}
