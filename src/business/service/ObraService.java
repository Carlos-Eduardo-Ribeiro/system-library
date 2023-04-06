package business.service;

import java.time.LocalDate;
import business.entities.ObraImpressa;
import java.util.List;

public class ObraService {

    private BibliotecaService bService;

    private static ObraService instance;

    private ObraService() {
        this.bService = new BibliotecaService();
    }

    public static ObraService getInstance() {
        if (instance == null) {
            instance = new ObraService();
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

    public boolean atualizarTituloDaObra(String titulo, String novoTitulo) {
    	
       boolean obra = bService.atualizarTituloO(titulo, novoTitulo);
          
        return obra;
    }
    
    public boolean atualizarEditoraDaObra(String titulo, String novaEditora) {
    	
        boolean obra = bService.atualizarEditoraO(titulo,novaEditora);
           
         return obra;
     }
    
    public boolean atualizarNumeroDePaginasDaObra(String titulo, int novoNumeroDePaginas) {
    	
        boolean obra = bService.atualizarNumeroDePaginasO(titulo,novoNumeroDePaginas);
           
         return obra;
     }
    
    public boolean atualizarQuantidadeDisponivelDaObra(String titulo, int novaQuantidade) {
    	
        boolean obra = bService.atualizarQuantidadeDisponivelO(titulo,novaQuantidade);
           
         return obra;
     }
    
    public boolean atualizarIdiomaDaObra(String titulo, String novoIdioma) {
    	
        boolean obra = bService.atualizarIdiomaDaO(titulo,novoIdioma);
           
         return obra;
     }
    
}