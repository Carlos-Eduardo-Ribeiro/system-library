package business.service;

import java.time.LocalDate;
import java.util.List;
import business.entities.ArtigoCientifico;
import business.entities.Livro;
import business.entities.ObraImpressa;
import business.repositories.RepositorioDeObras;


public class BibliotecaService {

private RepositorioDeObras repositorio;

public BibliotecaService() {

this.repositorio = RepositorioDeObras.getInstance(); 
}
	   
	public boolean adicionarLivro(String titulo, String autor,int quantidade, int numeroDePaginas, String idioma, LocalDate anoDePublicacao,
			String editora, String generoLiterario) {
	    
        Livro livro = new Livro(titulo,autor, quantidade, numeroDePaginas,idioma,anoDePublicacao,
    			editora,generoLiterario);
        
        livro.setTitulo(titulo);       
        livro.setAutor(autor);

        boolean sucesso =repositorio.create(livro);
        return sucesso;
    }
    
	
	public boolean cadastrarArtigoCientifico(String autor,String titulo, int quantidade, int numeroDePaginas, String idioma,
			LocalDate anoDePublicacao, String editora,String referenciaBibliografica,String resumo) {

	     ArtigoCientifico artigo = new ArtigoCientifico(autor,titulo,quantidade,numeroDePaginas,idioma,anoDePublicacao,editora,referenciaBibliografica,resumo);
	     
	        artigo.setTitulo(titulo);
	        artigo.setNumeroDePaginas(numeroDePaginas);
	        artigo.setQuantidade(quantidade);
	        artigo.setNumeroDePaginas(numeroDePaginas);
	        artigo.setIdioma(idioma);
	        artigo.setAnoDePublicacao(anoDePublicacao);
	        artigo.setEditora(editora);
	     
	     
	     boolean sucesso = repositorio.create(artigo);
	     
	     return sucesso;

	}
	public boolean remover(String titulo)
	{
		ObraImpressa rObra = (ObraImpressa) repositorio.buscarPorNomes(titulo);
		
		if(rObra==null)
		{
		 return false;
		}
		
			
		boolean sucesso = repositorio.removerPorNome(titulo);
		
		return sucesso;
	
	}
	public List<ObraImpressa> listaDeObras()
	{
		 
     List<ObraImpressa> todasAsObras = repositorio.read();
     
     return todasAsObras;
		
	}
	public ObraImpressa buscarO(String obra)
	{
		 
     ObraImpressa obraB = repositorio.buscarPorNomes(obra);
     
     return obraB;
		
	}
 
  public boolean atualizarTituloO (String titulo, String novoTitulo) {
  
	
	if(repositorio.buscarPorNomes(titulo)==null||repositorio.buscarPorNomes(novoTitulo)!=null)
	{
	 return false;
	}
	else{
	
	ObraImpressa atualizarObra = repositorio.buscarPorNomes(titulo);
	 
	atualizarObra.setTitulo(novoTitulo);
     
     repositorio.update(atualizarObra);
                
     return true;}  	       
    }	
    
       public boolean atualizarEditoraO (String titulo, String novaEditora) {
      
    	
    	if(repositorio.buscarPorNomes(titulo)==null)
    	{
    	 return false;
    	}
    	else{
    	
    	ObraImpressa atualizarObra = repositorio.buscarPorNomes(titulo);    	 
    	
    	atualizarObra.setEditora(novaEditora);
         
         repositorio.update(atualizarObra);
                    
         return true;}  	       
        }	
        
        
         public boolean atualizarNumeroDePaginasO (String titulo, int novoNumeroDePaginas) {
            
        	
        	if(repositorio.buscarPorNomes(titulo)==null)
        	{
        	 return false;
        	}
        	else{
        	
        	ObraImpressa atualizarObra = repositorio.buscarPorNomes(titulo);
        	 
        	atualizarObra.setNumeroDePaginas(novoNumeroDePaginas);
             
             repositorio.update(atualizarObra);
                        
             return true;}  	       
            }	
            
            
            public boolean atualizarQuantidadeDisponivelO (String titulo, int novaQuantidade) {
                
            	
            	if(repositorio.buscarPorNomes(titulo)==null)
            	{
            	 return false;
            	}
            	else{
            	
            	ObraImpressa atualizarObra = repositorio.buscarPorNomes(titulo);
            	            	
            	atualizarObra.setQuantidade(novaQuantidade);
            	
                 repositorio.update(atualizarObra);
                            
                 return true;}  	       
                }
            
            public boolean atualizarIdiomaDaO (String titulo, String novoIdioma) {
                
            	
            	if(repositorio.buscarPorNomes(titulo)==null)
            	{
            	 return false;
            	}
            	else{
            	
            	ObraImpressa atualizarObra = repositorio.buscarPorNomes(titulo);
            	 
                atualizarObra.setIdioma(novoIdioma);
                 
                 repositorio.update(atualizarObra);
                            
                 return true;}  	       
                }
}
