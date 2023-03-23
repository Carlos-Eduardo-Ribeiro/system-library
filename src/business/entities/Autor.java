package business.entities;

import java.time.LocalDate;

public class Autor extends Pessoa {
	
	
	private String pseudonimo;
	private String nacionalidade;
	   
	public Autor() {}

	public Autor(String nome,String pseudonimo,String nacionalidade, String cpf, LocalDate idade, String endereco) {
		super(nome,cpf, idade, endereco);
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
	           "-cpf='" + getCpf() + '\'' +"\n"+
	           "-idade=" + getIdade() +"\n"+
	           "-Idade=" + calcularIdade()+" anos";	           
	}
}