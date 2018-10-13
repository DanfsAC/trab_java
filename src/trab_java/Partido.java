package trab_java;

import java.util.HashSet;
import java.util.Set;

public class Partido {
	//Attributes
	String nome;
	int total_votos;
	int eleitos;
	Set<Candidato> candidatos;
	Coligacao col = null;
	
	//Constructor
	public Partido(String nome) {
		this.nome = nome;
		this.total_votos = 0;
		this.eleitos = 0;
		this.candidatos = new HashSet<Candidato>();
	}
	
	//Getters
	public String getNome() {
		return this.nome;
	}
	
	public int getVotos() {
		return this.total_votos;
	}
	
	public Coligacao getColigacao() {
		return col;
	}
	
	//Setters
	public void setColigacao(Coligacao c) {
		col = c;
	}
		
	//Methods
	public void addCandidato(Candidato x) {
		this.candidatos.add(x);
		this.total_votos += x.getVotos();
		
		if (x.isEleito()) this.eleitos++;
		
		if (this.hasColigacao()) this.col.addVotos(x.getVotos());
	}

	public boolean hasColigacao() {
		return col!=null;
	}
	
	@Override
	public String toString() {
		String txt = nome;
		
		txt += ", " + this.total_votos + " votos, " + this.eleitos;
		
		if (this.eleitos > 1) txt += "candidatos eleitos";
		else txt += "candidato eleito";
		
		return txt;
	}
}
