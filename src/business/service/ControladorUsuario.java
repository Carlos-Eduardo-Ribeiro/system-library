package business.service;

import java.time.LocalDate;
import java.util.List;
import business.entities.Autor;
import business.entities.Emprestimo;
import business.entities.ObraImpressa;
import business.entities.Pessoa;


	public class ControladorUsuario {

	    private UsuarioService uService;

	    private static  ControladorUsuario instance;

	    private ControladorUsuario() {
	        this.uService = new UsuarioService();
	    }

	    public static ControladorUsuario getInstance() {
	        if (instance == null) {
	            instance = new ControladorUsuario();
	        }
	        return instance;
	    }

	    public boolean cadastrarUsuario(String nome, String cpf, LocalDate idade, String endereco, String login, String password, boolean isAdmin) {
	    

	    boolean sucesso =uService.adicionarUsuario(nome,cpf,idade,endereco,login,password,isAdmin);

	    return sucesso;
	    }
	    
	    public boolean cadastrarAutor(String nome,String pseudonimo,String nacionalidade,String cpf, LocalDate idade, String endereco) {
	    

	    boolean sucesso =uService.adicionarAutor(nome,pseudonimo,nacionalidade,cpf,idade,endereco);

	    return sucesso;
	    }

	    public boolean bloquearUsuario(String Usuario) {
	    	    
	    
	        boolean sucesso = uService.bUsuario(Usuario);

	        return sucesso;
	        
	    }
	    public boolean liberarUsuario(String Usuario) {
    	    
		    
	        boolean sucesso = uService.libUsuario(Usuario);

	        return sucesso;
	    }
	    
	    public boolean advertirUsuario(String Usuario) {
	      
	        boolean sucesso = uService.advirUsuario(Usuario);

	        return sucesso;
	    }

	    public boolean removerUsuario(String Usuario) {
	            
	       boolean sucesso = uService.rUsuario(Usuario);
	        
	        return sucesso;
	    }

	    public String emprestrarObra(String numeroDeCadastro,String itemEmprestado, String usuarioQueRealizou) {
	    	
	   
	        String obra = uService.emprestarL(numeroDeCadastro,itemEmprestado,usuarioQueRealizou);
	          
	        return obra;
	    }
	    
        public String devolverLivro(String Usuario,String Obra) {
	    	
	        String obra = uService.devolverL(Usuario,Obra);
	          
	        return obra;
	    }
        public  List<Pessoa> listaDeUsuarios() {
        	
        	 List<Pessoa> usuarios = uService.lUsuarios();
             
             return usuarios;
         }
        
        public  List<Emprestimo> listaDeEmprestimos() {
        	
       	 List<Emprestimo> emprestimos = uService.lEmprestimos();
            
            return emprestimos;
        }
        public  List<Emprestimo> historicoDeEmprestimos() {
        	
          	 List<Emprestimo> emprestimos = uService.hEmprestimos();
               
               return emprestimos;
           }

        public  List<Autor> listaDeAutores(){
        	
       	 List<Autor> autores = uService.listaAutores();
            
            return autores;
        }
                                  
        public boolean atualizarUsuario(String cpf,String endereco, String login, String password,String numeroDeCadastro, boolean isAdmin) {
        	
            boolean usuarioAtulizado = uService.atualizarU(cpf,endereco,login,password,numeroDeCadastro,isAdmin);
              
            return usuarioAtulizado;
        }
        
        public void ativarContador()
        {
         uService.iniciarContador();
        } 
        
        public ObraImpressa buscarObraPorAutor(String obrasAutor) {
        	
       	 ObraImpressa bOPA = uService.bObraPorAutor(obrasAutor);
            
            return bOPA;
        }
        		
		}
		