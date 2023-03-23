package business.service;

import java.time.LocalDate;

import business.repositories.RepositorioDeObras;
import business.repositories.RepositorioDeUsuarios;
import java.util.List;
import java.util.Random;
import business.entities.Autor;
import business.entities.ObraImpressa;
import business.entities.Pessoa;
import business.entities.Usuario;
import business.enums.Status;
import business.entities.Emprestimo;


	public class UsuarioService {

	private RepositorioDeUsuarios repositorio;
	private RepositorioDeObras obrasUser;
	private Status status;

	public UsuarioService() {
	    this.repositorio = RepositorioDeUsuarios.getInstance(); 
	    this.obrasUser = RepositorioDeObras.getInstance();
	}
		
	 public boolean adicionarUsuario(String nome, String cpf, LocalDate idade, String endereco, String login, String password, boolean isAdmin) {
	    
		if(repositorio.buscarPorNomes(cpf)!=null||repositorio.buscarPorNomes(nome)!=null)
		{
		 return false;
		}
        Status atribuirStatusDeCadastro= status.RELEASED;        
        Usuario aqui;
        String numeroDeCadastro;
        
        do {
        	        
        Random gerador = new Random();
        long valor = gerador.nextInt(10001) + 10000;
        numeroDeCadastro = String.valueOf(valor);
        aqui = (Usuario) repositorio.buscarPorNomes(numeroDeCadastro);
       
        }
        while(aqui != null && numeroDeCadastro.equals(aqui.getNumeroDeCadastro()));
                      
	    Usuario usuario= new Usuario(nome,cpf,idade,endereco,login,password,atribuirStatusDeCadastro,numeroDeCadastro,isAdmin);
	   
	    usuario.setNome(nome);
	    usuario.setCpf(cpf);
	    usuario.setEndereco(endereco);
	    usuario.setLogin(login);
	    usuario.setPassword(password);
	    usuario.setStatus(atribuirStatusDeCadastro);
	    usuario.setNumeroDeCadastro(numeroDeCadastro);
	    usuario.setAdmin(isAdmin);
	    
	    boolean sucesso = repositorio.create(usuario);
	    
	    return sucesso;
	    }
	 
	 public boolean adicionarAutor(String nome,String pseudonimo,String nacionalidade,String cpf, LocalDate idade, String endereco) {
	    

	    Autor autor= new Autor(nome,pseudonimo,nacionalidade,cpf,idade,endereco);
	    
	    autor.setNome(nome);
	    autor.setPseudonimo(pseudonimo);
	    autor.setNacionalidade(nacionalidade);
	    autor.setCpf(cpf);
	    autor.setIdade(idade);
	    autor.setEndereco(endereco);
	    
	    boolean sucesso = repositorio.create(autor);
	    
	    return sucesso;
	    }
		
		public boolean bUsuario(String Usuario) {
			
			Usuario user = (business.entities.Usuario) repositorio.buscarPorNomes(Usuario);
    	    
			if(user!=null) {
				
	        boolean sucesso = repositorio.updateStatus(Usuario,status.BLOCKED);

	        return sucesso;
			}
			return false;
	    }
		
		 public boolean libUsuario(String Usuario) {
	    	    
			   Usuario user = (business.entities.Usuario) repositorio.buscarPorNomes(Usuario);
			    
			    if(user!=null) {
		        boolean sucesso = repositorio.updateStatus(Usuario,status.RELEASED);

		        return sucesso;
			    }
			    return false;
		    }
        
        
        public boolean advirUsuario(String Usuario) {
  	       
            Usuario user = (business.entities.Usuario) repositorio.buscarPorNomes(Usuario);
    	    
			if(user!=null) {
	        boolean sucesso = repositorio.updateStatus(Usuario,status.WARNED);

	        return sucesso;
			}
			return false;
	    }
        
        public boolean rUsuario(String Usuario) {
            
 	       boolean sucesso = repositorio.removerPorNome(Usuario);
 	        
 	        return sucesso;
 	    }
        public List<Pessoa> lUsuarios()
		{
			 
	     List<Pessoa> todasosUsuarios = repositorio.read();
	     
	     return todasosUsuarios;
		}   
        
        //EMPRESTIMO//
        
         public String emprestarL(String numeroDeCadastro, String itemEmprestado, String usuarioQueRealizou) {
	    	      
        	
        	 
        	 Usuario checarU= (Usuario) repositorio.buscarPorNomes(usuarioQueRealizou);
        	 ObraImpressa checarO =obrasUser.buscarPorNomes(itemEmprestado);             
             
             if(checarU==null||checarO==null)
             {
              return "Usuario ou Obra não existe";
             }
             else if(checarO.getQuantidade()>=1&&checarU.getStatus()==status.RELEASED||checarU.getStatus()==status.WARNED)
             {
            checarO.setdebiatarObra();        	        	        	
        	LocalDate agora = LocalDate.now();
        	LocalDate dataFinalParaDevoçao = agora.plusDays(15);
        	
	        Emprestimo emprestimo= new Emprestimo(numeroDeCadastro,agora,itemEmprestado);	                  
	        emprestimo.setDataDeEntrega(dataFinalParaDevoçao);       
	        emprestimo.setItemEmprestado(checarO);
	        emprestimo.setUsuarioQueRealizou(checarU);
	        emprestimo.setItemEmprestadoo(itemEmprestado);
	        	        	                    	        	     	        
	        repositorio.createEmpretimo(emprestimo);  
	        
	        checarU.setEmprestimo(emprestimo);
	        
	        return "\nEmprestimo cadastrado";
        	} 
             else
             {
              return "\n(O usuario não pode executar emprestimos)\nUsuário Status :"+checarU.getStatus();
             }
            }
         public String devolverL(String nome,String Obra) {
 	    	
         Usuario checarU= (Usuario) repositorio.buscarPorNomes(nome);         
         ObraImpressa checarO =obrasUser.buscarPorNomes(Obra);        
         LocalDate agora = LocalDate.now();
         String a = checarO.getTitulo();
         Emprestimo atualizar = repositorio.buscarPorEmpretimo(a);
         
         if(atualizar.getItemEmprestado()==checarO) {
        	 
         atualizar.setDataDeDevolucaoEfetiva(agora);
          
       	 checarO.setCreditarObra();         
       	 
       	 checarU.atualizar(atualizar);
       	 
       	
       	 repositorio.devolverLivroR(atualizar);
                 
         if(checarU.getStatus()==status.WARNED)
         {
        	checarU.setStatus(status.RELEASED);
         }
         return "\nObra devolvida com sucesso";
         
       	 }
        
         return "\nObra ou Usuario não emcontrado";
        
         }
         
         public  Emprestimo buscUsuario(String usuario) {
         	
        	 Emprestimo usuarios = repositorio.buscarPorEmpretimo(usuario);
             
             return usuarios;
         }
         
         public boolean atualizarU (String cpf,String endereco, String login, String password,String numeroDeCadastro, boolean isAdmin) {
             
         	if(repositorio.buscarPorNomes(cpf)==null) 
         	{
         	 return false;
         	}
         	
            Usuario usuario= (Usuario) repositorio.buscarPorNomes(cpf);
         	 
         	usuario.setEndereco(endereco);
         	usuario.setLogin(login);
         	usuario.setPassword(password);
         	usuario.setAdmin(isAdmin);
              
            repositorio.update(usuario);
            
            return true;
            
         	}
         
         public  List<Emprestimo> lEmprestimos() {
         	
           	 List<Emprestimo> emprestimos = repositorio.listaEmprestimos();
                
                return emprestimos;
            }
         public  List<Emprestimo> hEmprestimos() {
         	
          	 List<Emprestimo> emprestimos = repositorio.lHEmprestimos();
               
               return emprestimos;
           }
         public  List<Autor> listaAutores() {
          	
           	 List<Autor> autores = repositorio.listaA();
                
                return autores;
            }
         
         public void iniciarContador()
         {
          repositorio.iniciarVerificacaoEntregasAtrasadas();
       
         }
         public  ObraImpressa bObraPorAutor (String obrasAutor) {
         	
           	 ObraImpressa bOPA = obrasUser.buscObraPorAutor(obrasAutor);
              
                return bOPA;
            }
          
}