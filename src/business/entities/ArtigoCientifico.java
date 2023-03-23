package business.entities;

import java.time.LocalDate;

public class ArtigoCientifico extends ObraImpressa {

    public ArtigoCientifico() {}
    
    private String resumo;
    private String referenciaBibliografica;
    
	public ArtigoCientifico(String autor,String titulo, int quantidade, int numeroDePaginas, String idioma,
			LocalDate anoDePublicacao, String editora,String referenciaBibliografica,String resumo) {
		super(autor,titulo, quantidade, numeroDePaginas, idioma, anoDePublicacao, editora);
		this.referenciaBibliografica=referenciaBibliografica;
		this.resumo=resumo;
	}
	
	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getReferenciaBibliografica() {
		return referenciaBibliografica;
	}
	public void setReferenciaBibliografica(String referenciaBibliografica) {
		this.referenciaBibliografica = referenciaBibliografica;
	}

	@Override
	public String toString() {
	return "\n(ArtigoCientifico)\n\n" +
	"-titulo=" + getTitulo() + "\n" +
	"-quantidade=" + getQuantidade() +"\n"+
	"-numeroDePaginas=" + getNumeroDePaginas() +"\n"+
	"-idioma=" + getIdioma() + "\n" +
	"-anoDePublicacao=" + getAnoDePublicacao() +"\n"+
	"-editora=" + getEditora() + "\n" +
	"-autor=" + getAutor()+"\n" ;
	
	}
}

