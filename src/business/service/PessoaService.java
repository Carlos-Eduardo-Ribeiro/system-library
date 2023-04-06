package business.service;

import java.time.LocalDate;
import java.util.List;
import business.entities.Autor;
import business.entities.Emprestimo;
import business.entities.ObraImpressa;
import business.entities.Pessoa;
import business.exceptions.ElementoJaExisteException;
import business.exceptions.ElementoNaoEncontradoException;

	public class PessoaService {

	    private UsuarioService uService;

	    private static  PessoaService instance;

	    private PessoaService() {
	        this.uService = new UsuarioService();
	    }

	    public static PessoaService getInstance() {
	        if (instance == null) {
	            instance = new PessoaService();
	        }
	        return instance;
	    }

	    //Usuário//
	    
	    public boolean cadastrarUsuario(String nome, String cpf, LocalDate idade, String endereco, String login, String password, boolean isAdmin)throws ElementoJaExisteException {
	    

	    boolean sucesso =uService.adicionarUsuario(nome,cpf,idade,endereco,login,password,isAdmin);

	    return sucesso;
	    }
	    public boolean bloquearUsuario(String Usuario) throws ElementoNaoEncontradoException {
    	    
		    
	        boolean sucesso = uService.bUsuario(Usuario);

	        return sucesso;
	        
	    }
	    public boolean liberarUsuario(String Usuario) throws ElementoNaoEncontradoException {
    	    
		    
	        boolean sucesso = uService.libUsuario(Usuario);

	        return sucesso;
	    }
	    
	    public boolean advertirUsuario(String Usuario) throws ElementoNaoEncontradoException {
	      
	        boolean sucesso = uService.advirUsuario(Usuario);

	        return sucesso;
	    }

	    public boolean removerUsuario(String id) throws ElementoNaoEncontradoException {
	            
	       boolean sucesso = uService.rUsuario(id);
	        
	        return sucesso;
	    }
	    public  List<Pessoa> listaDeUsuarios() {
        	
       	 List<Pessoa> usuarios = uService.lUsuarios();
            
            return usuarios;
        }

        public boolean atualizarEmderecoDoUsuario (String id,String novoEmdereco) throws ElementoNaoEncontradoException {
         
      	
        boolean sucesso = uService.atualizarUEmdereco(id, novoEmdereco);
        
        return sucesso;
         
      	}
        public boolean atualizarLoginESenhaDoUsuario (String login, String password,String novoLogin, String novoPassword) throws ElementoNaoEncontradoException {
                    	
        boolean sucesso = uService.atualizarULoginESenha(login, password, novoLogin, novoPassword);
        
        return sucesso;
        
        }
        
        public boolean atualizarStatusAdiminUsuario (String cpf, boolean isAdmin) throws ElementoNaoEncontradoException {                     
            	
         boolean sucesso= uService.atualizarUAdimin(cpf, isAdmin);           	               		                        	 
               
         return sucesso;
               
        }
  
	    //Autor//
	    
	    public boolean cadastrarAutor(String nome, LocalDate idade, String endereco, String pseudonimo,String nacionalidade) throws ElementoJaExisteException {
	    

	    boolean sucesso =uService.adicionarAutor(nome, idade, endereco, pseudonimo, nacionalidade);

	    return sucesso;
	    }
	    
	    public  List<Autor> listaDeAutores(){
        	
	       	 List<Autor> autores = uService.listaAutores();
	            
	            return autores;
	        }
	                                         
	        
	    public List<ObraImpressa> buscarObraPorAutor(String obrasAutor) throws ElementoNaoEncontradoException {
	        	
         	 List<ObraImpressa> bOPA = uService.bObraPorAutor(obrasAutor);
	            
              return bOPA;
	        }

	    //Empréstimo//
	    
	    public String emprestrarObra(String numeroDeCadastro,String itemEmprestado, String usuarioQueRealizou) throws ElementoNaoEncontradoException {
	    	
	   
	        String obra = uService.emprestarL(numeroDeCadastro,itemEmprestado,usuarioQueRealizou);
	          
	        return obra;
	    }
	    
        public String devolverLivro(String Usuario,String Obra) throws ElementoNaoEncontradoException {
	    	
	        String obra = uService.devolverL(Usuario,Obra);
	          
	        return obra;
	    }
       
        
        public  List<Emprestimo> listaDeEmprestimos() {
        	
       	 List<Emprestimo> emprestimos = uService.lEmprestimos();
            
            return emprestimos;
        }
        
        public  List<Emprestimo> historicoDeEmprestimos() {
        	
          	 List<Emprestimo> emprestimos = uService.hEmprestimos();
               
               return emprestimos;
           }

        public  List<Emprestimo> emprestimosAtrazados() {
        	
         	 List<Emprestimo> emprestimos = uService.epAtrasados();
              
              return emprestimos;
          }
        public  List<Emprestimo> buscarEmprestimosDoUsuario(String nomeOuNdc) throws ElementoNaoEncontradoException {
        	
        	 List<Emprestimo> emprestimos = uService.empDoUsuario(nomeOuNdc);
             
             return emprestimos;
         }
     
        public void ativarContador()
        {
         uService.iniciarContador();
        } 
        
		}
		