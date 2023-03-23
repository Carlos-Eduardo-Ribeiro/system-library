package business.service;

import java.time.LocalDate;
import business.entities.ObraImpressa;
import java.util.List;

public class ControladorObra {

    private BibliotecaService bService;

    private static ControladorObra instance;

    private ControladorObra() {
        this.bService = new BibliotecaService();
    }

    public static ControladorObra getInstance() {
        if (instance == null) {
            instance = new ControladorObra();
        }
        return instance;
    }

    public boolean cadastrarLivro(String titulo, String autor,int quantidade, int numeroDePaginas, String idioma, LocalDate anoDePublicacao,
			String editora, String generoLiterario) {
    

    boolean sucesso =bService.adicionarLivro(titulo,autor,quantidade,numeroDePaginas,idioma, anoDePublicacao,
			editora,generoLiterario);

    return sucesso;
    }

    public boolean cadastrarArtigoCientifico(String autor,String titulo, int quantidade, int numeroDePaginas, String idioma,
			LocalDate anoDePublicacao, String editora,String referenciaBibliografica,String resumo) {
    	    
    
        boolean sucesso = bService.cadastrarArtigoCientifico(autor,titulo,quantidade,numeroDePaginas,idioma,anoDePublicacao,editora,referenciaBibliografica,resumo);

        return sucesso;
    }
    
    public boolean excluirObra(String obra) {
      
        boolean sucesso = bService.remover(obra);

        return sucesso;
    }
    public ObraImpressa buscarObra(String obra) {
        
        ObraImpressa sucesso = bService.buscarO(obra);

        return sucesso;
    }

    public List<ObraImpressa> pesquisarObras() {
            
        List<ObraImpressa> obras = bService.listaDeObras();
        
        return obras;
    }

    public boolean atualizarObra(String titulo, String novoTitulo, String novaEditora, int novaQuantidade, int novoNumeroDePaginas, String novoIdioma) {
    	
        boolean obra = bService.atualizarNR( titulo, novoTitulo, novaEditora, novaQuantidade, novoNumeroDePaginas, novoIdioma);
          
        return obra;
    }
}