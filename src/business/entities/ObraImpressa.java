package business.entities;

import java.time.LocalDate;

public class ObraImpressa {
	
    private String titulo;
    private int quantidade;
    private int numeroDePaginas;
    private String idioma;
    private LocalDate anoDePublicacao;
    private String editora;
    private String autor;

    public ObraImpressa() {}
    
    public ObraImpressa(String autor,String titulo, int quantidade, int numeroDePaginas,
                        String idioma, LocalDate anoDePublicacao, String editora) {
    	this.autor=autor;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.numeroDePaginas = numeroDePaginas;
        this.idioma = idioma;
        this.anoDePublicacao = anoDePublicacao;
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public LocalDate getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(LocalDate anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

   public void setCreditarObra() {
    	
    	
		this.quantidade=quantidade+1;
    	
	}
    public void setdebiatarObra() {
    	
    	if(quantidade>=1)
    	{
		this.quantidade=quantidade-1;
    	}
    	
	}
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
	    return "(Obra Impressa)\n\n" + 
	           "-titulo='" + titulo + '\'' +
	           "-quantidade=" + quantidade +
	           "-numeroDePaginas=" + numeroDePaginas +
	           "-idioma='" + idioma + '\'' +
	           "-anoDePublicacao=" + anoDePublicacao +
	           "-editora='" + editora + '\'' +
	           "-autores=" + autor ;
	           
	}
        
}