package business.entities;
import java.time.LocalDate;

public class Livro extends ObraImpressa {
	
    private String generoLiterario;

	public Livro() {}

	public Livro(String titulo,String autor, int quantidade, int numeroDePaginas, String idioma, LocalDate anoDePublicacao,
			String editora, String generoLiterario) {
		super(titulo,autor, quantidade, numeroDePaginas, idioma, anoDePublicacao, editora);
		this.generoLiterario = generoLiterario;
	}

	public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    
    
    @Override
    public String toString() {
    return "\n(Livro)\n\n" +
    "-Autor:" + getAutor() + "\n" +
    "-Título:" + getTitulo() + "\n" +
    "-Gêneroliterário:" + generoLiterario + "\n" +
    "-Quantidade:" + getQuantidade() + "\n" +
    "-Número de páginas:" + getNumeroDePaginas() + "\n" +
    "-Idioma:" + getIdioma() + "\n" +
    "-Ano de publicação:" + getAnoDePublicacao() + "\n" +
    "-Editora:" + getEditora() + "\n" ;
    
    } 
}