package trab_java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Coligacao implements Comparable<Coligacao> {
	//Attributes
	Set<Partido> col = new HashSet<Partido>();
	int votos_totais = 0;
	String nome;
	
	//Constructor
	public Coligacao(String pNomes, LinkedList<Partido> partidos) {
		this.nome = pNomes;
		String[] aux = pNomes.split(" / ");
		
		for(int i = 0; i < aux.length; i++) {
			boolean ok = false;
			for(Partido x: partidos) {
				if(x.getNome().replaceAll(" ", "").equals(aux[i].replaceAll(" ", ""))) {
					addPartido(x);
					x.setColigacao(this);
					ok = true;
					break;
				}
			}
			
			if(!ok) {
				if(Character.isWhitespace(aux[i].charAt(0))) {
					aux[i] = aux[i].substring(1);
				}
				Partido novo = new Partido(aux[i]);
				System.out.println(novo.getNome());
				addPartido(novo);
				partidos.add(novo);
			}
		}
	}
	
	//Getters
	public int getVotos() {
		return votos_totais;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	//Methods
	public void addVotos(int n) {
		votos_totais += n;
	}
	
	public void addPartido(Partido p) {
		this.col.add(p);
	}

	@Override
	public String toString() {
		String txt = "Coligação: ";
		int cont = 0;
		
		for(Partido x : col) {
			txt += x.getNome();
			if(cont > col.size()) {
				txt +=" / ";
			}
			
		}
		
		return txt;
	}
	
	@Override
	public int compareTo(Coligacao x) {
		return x.getVotos() - this.getVotos();
	}
}
