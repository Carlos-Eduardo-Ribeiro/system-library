package business.entities;

import java.time.LocalDate;

public class Autor extends Pessoa {
	
	
	private String pseudonimo;
	private String nacionalidade;
	   
	public Autor() {}

	public Autor(String nome, LocalDate idade, String endereco, String pseudonimo,String nacionalidade) {
		super(nome,null, idade, endereco);
		this.pseudonimo=pseudonimo;
		this.nacionalidade=nacionalidade;
	}

	public String getPseudonimo() {
		return pseudonimo;
	}

	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@Override
	public String toString() {
	    return "\n(Autor)\n\n" + 
	           "-pseudonimo='" + pseudonimo + '\'' +"\n"+
	           "-nacionalidade='" + nacionalidade + '\'' +"\n"+
	           "-nome='" + getNome() + '\'' +"\n"+           
	           "-idade=" + getIdade() +"\n"+
	           "-Idade=" + calcularIdade()+" anos";	           
	}
}